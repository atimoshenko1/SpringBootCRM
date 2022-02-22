package Anna.CRM.Contacts.Repository;

import Anna.CRM.Contacts.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactsRepository extends JpaRepository<Contacts, Long> {
}