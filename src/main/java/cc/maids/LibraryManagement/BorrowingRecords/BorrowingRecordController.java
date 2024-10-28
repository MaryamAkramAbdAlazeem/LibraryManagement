package cc.maids.LibraryManagement.BorrowingRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class BorrowingRecordController {

    private final BorrowingRecordService borrowingRecordService;

    @Autowired
    public BorrowingRecordController(BorrowingRecordService borrowingRecordService) {
        this.borrowingRecordService = borrowingRecordService;
    }

    // POST /api/borrow/{bookId}/patron/{patronId} - Allow a patron to borrow a book
    @PostMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordService.borrowBook(bookId, patronId);
        return ResponseEntity.status(201).body(borrowingRecord);
    }

    // PUT /api/return/{bookId}/patron/{patronId} - Record the return of a borrowed book by a patron
    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordService.returnBook(bookId, patronId);
        return ResponseEntity.ok(borrowingRecord);
    }
}
