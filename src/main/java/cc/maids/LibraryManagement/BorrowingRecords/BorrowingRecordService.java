package cc.maids.LibraryManagement.BorrowingRecords;

import cc.maids.LibraryManagement.Books.Book;
import cc.maids.LibraryManagement.Books.BookRepository;
import cc.maids.LibraryManagement.Patrons.Patron;
import cc.maids.LibraryManagement.Patrons.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowingRecordService {

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    @Autowired
    public BorrowingRecordService(BorrowingRecordRepository borrowingRecordRepository,
                                  BookRepository bookRepository,
                                  PatronRepository patronRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    // Borrow a book
    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + bookId));

        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new RuntimeException("Patron not found with id " + patronId));
        if (!book.isBookState()) {
            throw new IllegalStateException("Book is already borrowed");
        }
        // Change book state to false (assuming state is a boolean indicating if it's borrowed)
        book.setBookState(false);
        bookRepository.save(book); // Save the updated book state

        // Create a new borrowing record
        BorrowingRecord record = new BorrowingRecord(patron, book, LocalDate.now(), null);
        return borrowingRecordRepository.save(record);
    }

    // Return a book
    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + bookId));

        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new RuntimeException("Patron not found with id " + patronId));

        // Find the borrowing record
        BorrowingRecord record = borrowingRecordRepository.findByBookAndPatron(book, patron)
                .orElseThrow(() -> new RuntimeException("Borrowing record not found for book ID " + bookId + " and patron ID " + patronId));

        // Change book state to true
        book.setBookState(true);
        bookRepository.save(book); // Save the updated book state

        // Update return date in the borrowing record
        record.setReturnDate(LocalDate.now());
        return borrowingRecordRepository.save(record);
    }
}
