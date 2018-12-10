package test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import test.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
