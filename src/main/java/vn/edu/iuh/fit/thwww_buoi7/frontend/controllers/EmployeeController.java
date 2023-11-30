package vn.edu.iuh.fit.thwww_buoi7.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.thwww_buoi7.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.thwww_buoi7.backend.enums.ProductStatus;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Employee;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Product;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.EmployeeRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.services.EmployeeServices;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/listemployee")
    public String getAll(Model model) {
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "admin/emps/listemployee";
    }

    @GetMapping("/show-add-form")
    public String showAddForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        EmployeeStatus[] employeeStatuses = EmployeeStatus.values();
        model.addAttribute("employeeStatuses", employeeStatuses);
        return "admin/emps/add-form";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee/listemployee";
    }

    @GetMapping("/goback")
    public String goback() {
        return "redirect:/admin/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        employeeRepository.delete(employeeRepository.findById(Long.valueOf(id)).orElse(new Employee()));
        return "redirect:/employee/listemployee";
    }
}
