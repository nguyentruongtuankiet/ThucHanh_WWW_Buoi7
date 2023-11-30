package vn.edu.iuh.fit.thwww_buoi7.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Customer;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Employee;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.EmployeeRepository;

import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
}
