package cc.maids.LibraryManagement.BorrowingRecords;

import cc.maids.LibraryManagement.Books.Book;
import cc.maids.LibraryManagement.Patrons.Patron;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class BorrowingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Patron is required")
    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @NotNull(message = "Book is required")
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @NotNull(message = "Borrow date is required")
    private LocalDate borrowDate;

    private LocalDate returnDate;

    // Constructors, getters, and setters
    public BorrowingRecord() {}

    public BorrowingRecord(Patron patron, Book book, LocalDate borrowDate, LocalDate returnDate) {
        this.patron = patron;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
