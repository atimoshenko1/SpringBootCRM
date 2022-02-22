package Anna.CRM.Contacts;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contacts")
public class Contacts {
    @Id
    @GeneratedValue
    private Long id;
    private Long account_id;
    private String title;
    private String name;
    private String email;
    public Contacts() {
    }

    public Contacts(Long account_id, String title , String name, String email) {
        this.title = title;
        this.account_id = account_id;
        this.name = name;
        this.email = email;
    }

    public Contacts(Long id, Long account_id, String title, String name, String email) {
        this.id = id;
        this.title = title;
        this.account_id = account_id;
        this.name = name;
        this.email = email;
    }


    public Long getId() {
        return id;
    }
    public Long getAccountId() {
        return account_id;
    }

    public String getTitle() {
        return title;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setAccountId(Long account_id) {
        this.account_id = account_id;
    }

    public void setTitle(String title) {
        this.title = title;
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
