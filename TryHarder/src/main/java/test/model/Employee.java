package test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMP_TBL")
public class Employee implements Serializable {
    private static final long serialVersionUID = 3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(columnDefinition = "varchar(255) COLLATE utf8_general_ci")
    private String name;

    @Column(columnDefinition = "varchar(255) COLLATE utf8_general_ci")
    private String email;

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
}
