package cc.maids.LibraryManagement.Books;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.*;
import cc.maids.LibraryManagement.BorrowingRecords.BorrowingRecord;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title is required")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;

    @NotNull(message = "Author is required")
    @Size(min = 1, max = 50, message = "Author name must be between 1 and 50 characters")
    private String author;


    private LocalDate  publicationYear;

    @NotNull(message = "ISBN is required")
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
    private String isbn;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowingRecord> borrowingRecords;

private boolean bookState;
    public Book() {
    }

    public Book(String title, String author, LocalDate publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.bookState = true;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setBookState(boolean bookState) {
        this.bookState = bookState;
    }

    public boolean isBookState() {
        return bookState;
    }

    public Book(Long id, String title, String author, LocalDate publicationYear, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }

    public @NotNull(message = "Author is required") @Size(min = 1, max = 50, message = "Author name must be between 1 and 50 characters") String getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public @NotNull(message = "Title is required") @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters") String getTitle() {
        return title;
    }



    public @NotNull(message = "ISBN is required") @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters") String getIsbn() {
        return isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(@NotNull(message = "Title is required") @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters") String title) {
        this.title = title;
    }

    public void setAuthor(@NotNull(message = "Author is required") @Size(min = 1, max = 50, message = "Author name must be between 1 and 50 characters") String author) {
        this.author = author;
    }


    public void setBorrowingRecords(List<BorrowingRecord> borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }

    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setIsbn(@NotNull(message = "ISBN is required") @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters") String isbn) {
        this.isbn = isbn;
    }
}
