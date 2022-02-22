package Anna.CRM.Leads.Repository;

import Anna.CRM.Leads.Leads;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LeadsRepository extends JpaRepository<Leads, Long> {
}