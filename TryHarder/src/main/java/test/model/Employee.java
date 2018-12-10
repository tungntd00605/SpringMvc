package test.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "EMP_TBL")
public class Employee implements Serializable {
    private static final long serialVersionUID = 3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(columnDefinition = "varchar(255) COLLATE utf8_general_ci")
    @NotEmpty(message = "Tên không được để trống")
    @Size(min = 2, message = "Tên không được nhỏ hơn 2 ký tự")
    private String name;

    @Column(columnDefinition = "varchar(255) COLLATE utf8_general_ci")
    private String email;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private Department department;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
