package metahorizon.test.coding.enrolleedependentapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "enrollees")
public class Enrollee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dob")
    private LocalDate dob;

    @OneToMany(mappedBy = "enrollee", cascade = CascadeType.ALL)
    private List<Dependent> dependentList = new ArrayList<>();

    public int getId() {
        return id;
    }

    @Column(name = "activation")
    private boolean activation;

    @Column(name = "phone")
    private String phone;

    public Enrollee(){}
    public Enrollee(String name, LocalDate dob, boolean activation, String phone){
        this.name = name;
        this.dob = dob;
        this.activation = activation;
        this.phone = phone;
    }

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

    public boolean isActivation() {
        return activation;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Dependent> getDependentList(){
        return this.dependentList;
    }

    @Override
    public String toString() {
        return "{ id:" + this.id + ", name:" + this.name + ", activation: " + this.activation + ", dob: " + this.dob + "}";
    }
}
