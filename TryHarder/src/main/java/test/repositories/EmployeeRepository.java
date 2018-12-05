package test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import test.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
