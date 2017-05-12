package datasets;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by artur on 12/05/17.
 */
@Entity
@Table(name = "users")
public class UserDataset {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name = "lname")
    private String lname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "regtime")
    private Date regtime;

    @Column(name = "is_tester")
    private boolean is_tester;

    @OneToMany
    private List<AssessmentDataset> assessments;

    //Important for Hibernate
    public UserDataset() {
    }

    public UserDataset(String name, String email, boolean is_tester) {
        this.lname = name;
        this.email = email;
        this.regtime = new Date();
        this.is_tester = is_tester;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", regtime='" + regtime + '\'' +
                ", is_tester='" + is_tester + '\'' +
                '}';
    }

}
