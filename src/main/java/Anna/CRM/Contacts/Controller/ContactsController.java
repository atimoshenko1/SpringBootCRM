package Anna.CRM.Contacts.Controller;
import Anna.CRM.Contacts.Contacts;
import Anna.CRM.Contacts.Repository.ContactsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/contacts")
public class ContactsController {
    private final ContactsRepository ContactsRepository;

    public ContactsController(ContactsRepository ContactsRepository) {
        this.ContactsRepository = ContactsRepository;
    }

    @GetMapping
    public List<Contacts> getContacts() {
        return ContactsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Contacts getContacts(@PathVariable Long id) {
        return ContactsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity addContact(@RequestBody Contacts contacts) throws URISyntaxException {
        Contacts savedContact = ContactsRepository.save(contacts);
        return ResponseEntity.created(new URI("/contacts/" + savedContact.getId())).body(savedContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateContacts(@PathVariable Long id, @RequestBody Contacts Contacts) {
        Contacts currentContacts = ContactsRepository.findById(id).orElseThrow(RuntimeException::new);
        currentContacts.setName(Contacts.getName());
        currentContacts.setEmail(Contacts.getEmail());
        currentContacts = ContactsRepository.save(Contacts);

        return ResponseEntity.ok(currentContacts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        ContactsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
