package datasets;

import javax.persistence.*;

/**
 * Created by artur on 12/05/17.
 */
@Entity
@Table(name = "assessment")
public class AssessmentDataset {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserDataset user;

    @Column(name = "grade", nullable = false)
    private long grade;

    public enum Status {
        RUNNING,
        OK,
        TIMEOUT
    }

    @Column(name = "status")
    private Status status;

    //Important for Hibernate
    public AssessmentDataset() {
    }

    public AssessmentDataset(UserDataset user, long grade, Status status) {
        this.user = user;
        this.grade = grade;
        this.status = status;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AssessmentDataset{" +
                "id=" + id +
                ", user_id='" + user + '\'' +
                ", grade='" + grade + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
