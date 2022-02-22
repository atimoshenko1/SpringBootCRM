package Anna.CRM.Accounts;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Accounts {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    public Accounts() {
    }

    public Accounts(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Accounts(Long id, String name, String email) {
        this.id = id;
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
