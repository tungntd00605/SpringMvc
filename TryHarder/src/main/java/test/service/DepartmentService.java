package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.Department;
import test.model.Employee;
import test.repositories.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repo;

    public void addDepartment(Department department){
        repo.save(department);
    }

    public List<Department> getAllDepartment(){
        List<Department> listDep = repo.findAll();
        return listDep;
    }

    public Department getDepartmentById(Integer depId){
        Department foundDep = repo.findById(depId).orElseThrow(() -> new RuntimeException());
        return foundDep;
    }

    public void updateEmployee(Department department){
        repo.findById(department.getId()).orElseThrow(() -> new RuntimeException());
        repo.save(department);
    }

    public void deleteEmployee(Integer depId){
        Department deleteDepartment = repo.findById(depId).orElseThrow(() -> new RuntimeException());
        repo.delete(deleteDepartment);
    }
}
