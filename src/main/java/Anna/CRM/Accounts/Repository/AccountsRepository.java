package Anna.CRM.Accounts.Repository;

import Anna.CRM.Accounts.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountsRepository extends JpaRepository<Accounts, Long> {
}