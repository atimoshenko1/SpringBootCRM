package Anna.CRM.Leads;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Leads")
public class Leads {
    @Id
    @GeneratedValue
    private Long id;
    private Long account_id;
    private String name;
    private String email;
    public Leads() {
    }

    public Leads(Long account_id, String name, String email) {
        this.account_id = account_id;
        this.name = name;
        this.email = email;
    }

    public Leads(Long id, Long account_id, String name, String email) {
        this.id = id;
        this.account_id = account_id;
        this.name = name;
        this.email = email;
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
