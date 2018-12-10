package test.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEP_TBL")
public class Department {
    @Id
    @Column(name = "DEPT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "varchar(255) COLLATE utf8_general_ci")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
