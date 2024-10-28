package cc.maids.LibraryManagement.Patrons;

import cc.maids.LibraryManagement.BorrowingRecords.BorrowingRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    @Size(min = 1, max = 100)
    private String name;

    @NotNull(message = "Contact information is required")
    private String contactInformation;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BorrowingRecord> borrowingRecords;

    // Constructors, getters, and setters
    public Patron() {}

    public Patron(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setBorrowingRecords(List<BorrowingRecord> borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }
}
