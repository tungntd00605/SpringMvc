package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.Employee;
import test.repositories.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public void addEmployee(Employee employee){
        repo.save(employee);
    }

    public List<Employee> getAllEmployee(){
        List<Employee> listEmp = repo.findAll();
        return listEmp;
    }

    public Employee getEmployeeById(Integer empId){
        Employee foundEmp = repo.findById(empId).orElseThrow(() -> new RuntimeException());
        return foundEmp;
    }

    public void updateEmployee(Employee employee){
        repo.findById(employee.getId()).orElseThrow(() -> new RuntimeException());
        repo.save(employee);
    }

    public void deleteEmployee(Integer empId){
        Employee deleteEmployee = repo.findById(empId).orElseThrow(() -> new RuntimeException());
        repo.delete(deleteEmployee);
    }
}
