package Anna.CRM.Accounts.Controller;
import Anna.CRM.Accounts.Accounts;
import Anna.CRM.Accounts.Repository.AccountsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountsController {
    private final AccountsRepository AccountsRepository;

    public AccountsController(AccountsRepository AccountsRepository) {
        this.AccountsRepository = AccountsRepository;
    }

    @GetMapping
    public List<Accounts> getAccounts() {
        return AccountsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Accounts getAccounts(@PathVariable Long id) {
        return AccountsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity addAccount(@RequestBody Accounts accounts) throws URISyntaxException {
        Accounts savedAccount = AccountsRepository.save(accounts);
        return ResponseEntity.created(new URI("/accounts/" + savedAccount.getId())).body(savedAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAccounts(@PathVariable Long id, @RequestBody Accounts Accounts) {
        Accounts currentAccounts = AccountsRepository.findById(id).orElseThrow(RuntimeException::new);
        currentAccounts.setName(Accounts.getName());
        currentAccounts.setEmail(Accounts.getEmail());
        currentAccounts = AccountsRepository.save(Accounts);

        return ResponseEntity.ok(currentAccounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        AccountsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
