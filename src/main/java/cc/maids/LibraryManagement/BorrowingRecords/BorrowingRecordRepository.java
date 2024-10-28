package cc.maids.LibraryManagement.BorrowingRecords;

import cc.maids.LibraryManagement.Books.Book;
import cc.maids.LibraryManagement.Patrons.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {

    // Find a borrowing record by book and patron to allow returning of borrowed books
    Optional<BorrowingRecord> findByBookAndPatron(Book book, Patron patron);
}
