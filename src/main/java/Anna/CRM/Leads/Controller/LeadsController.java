package Anna.CRM.Leads.Controller;
import Anna.CRM.Leads.Leads;
import Anna.CRM.Leads.Repository.LeadsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/Leads")
public class LeadsController {
    private final LeadsRepository LeadsRepository;

    public LeadsController(LeadsRepository LeadsRepository) {
        this.LeadsRepository = LeadsRepository;
    }

    @GetMapping
    public List<Leads> getLeads() {
        return LeadsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Leads getLeads(@PathVariable Long id) {
        return LeadsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity addLead(@RequestBody Leads Leads) throws URISyntaxException {
        Leads savedLead = LeadsRepository.save(Leads);
        return ResponseEntity.created(new URI("/Leads/" + savedLead.getId())).body(savedLead);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateLeads(@PathVariable Long id, @RequestBody Leads Leads) {
        Leads currentLeads = LeadsRepository.findById(id).orElseThrow(RuntimeException::new);
        currentLeads.setName(Leads.getName());
        currentLeads.setEmail(Leads.getEmail());
        currentLeads = LeadsRepository.save(Leads);

        return ResponseEntity.ok(currentLeads);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLead(@PathVariable Long id) {
        LeadsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
