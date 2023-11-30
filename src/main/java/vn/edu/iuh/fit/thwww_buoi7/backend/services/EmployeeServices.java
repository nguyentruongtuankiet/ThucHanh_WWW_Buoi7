package vn.edu.iuh.fit.thwww_buoi7.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Employee;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

   public List<Employee> getAll(){
       return employeeRepository.findAll();
   }

}
