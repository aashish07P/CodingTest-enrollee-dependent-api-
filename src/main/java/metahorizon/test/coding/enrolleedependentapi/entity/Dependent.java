package metahorizon.test.coding.enrolleedependentapi.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dependents")
public class Dependent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dob")
    private LocalDate dob;

/*    @Column(name = "enrollee_id")
    private int enrolleeId;*/

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    @JoinColumn(name = "enrollee_id", nullable = false)
    private Enrollee enrollee;

    public int getId() {
        return id;
    }

    public Dependent(){}
/*    public Dependent(String name, LocalDate dob, int enroleeId){
        this.name = name;
        this.dob = dob;
        this.enrolleeId = enroleeId;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEnrollee(Enrollee enrollee) {
        this.enrollee = enrollee;
    }

    @Override
    public String toString() {
        return "{ id:" + this.id + ", name:" + this.name +  ", dob: " + this.dob + "}";
    }
}
