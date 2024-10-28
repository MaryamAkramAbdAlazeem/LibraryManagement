package cc.maids.LibraryManagement.Patrons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService {

    private final PatronRepository patronRepository;

    @Autowired
    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    // Retrieve all patrons
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    // Retrieve a patron by ID
    public Optional<Patron> getPatronById(Long id) {
        return patronRepository.findById(id);
    }

    // Create a new patron
    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    // Update an existing patron
    public Patron updatePatron(Long id, Patron patronDetails) {
        Patron patron = patronRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patron not found with id " + id));

        patron.setName(patronDetails.getName());
        patron.setContactInformation(patronDetails.getContactInformation());

        return patronRepository.save(patron);
    }

    // Delete a patron by ID
    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
