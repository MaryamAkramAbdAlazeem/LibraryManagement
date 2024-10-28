package cc.maids.LibraryManagement.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    @Transactional
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    @Transactional
    public Book updateBook(Long id, Book updatedBook) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with ID: " + id);
        }
        updatedBook.setId(id);
        return bookRepository.save(updatedBook);
    }
    @Transactional
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with ID: " + id);
        }
        bookRepository.deleteById(id);
    }
}
