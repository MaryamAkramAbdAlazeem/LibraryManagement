package cc.maids.LibraryManagement.Patrons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    private final PatronService patronService;

    @Autowired
    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    // Get all patrons
    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    // Get a specific patron by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
        return patronService.getPatronById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new patron
    @PostMapping
    public ResponseEntity<Patron> createPatron(@RequestBody Patron patron) {
        Patron createdPatron = patronService.createPatron(patron);
        return new ResponseEntity<>(createdPatron, HttpStatus.CREATED);
    }

    // Update an existing patron
    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @RequestBody Patron patronDetails) {
        Patron updatedPatron = patronService.updatePatron(id, patronDetails);
        return ResponseEntity.ok(updatedPatron);
    }

    // Delete a patron
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }
}
