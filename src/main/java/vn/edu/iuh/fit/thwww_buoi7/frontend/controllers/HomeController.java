package vn.edu.iuh.fit.thwww_buoi7.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Customer;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Employee;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.services.CustomerServices;
import vn.edu.iuh.fit.thwww_buoi7.backend.services.EmployeeServices;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private EmployeeServices employeeServices;
    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/")
    public String login() {
        return "client/login";
    }

    @GetMapping("/login")
    public String checkLoGin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        List<Employee> employeeList = employeeServices.getAll();
        for (Employee employee : employeeList) {
            if (employee.getEmail().equals(username) && employee.getFullname().equals(password)) {
                // Nếu thông tin đăng nhập chính xác, thực hiện đăng nhập và chuyển hướng đến trang quản trị
                return "redirect:/admin/products";
            }
        }
        List<Customer> customerList = customerServices.getAll();
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(username) && customer.getName().equals(password)) {
                // Nếu thông tin đăng nhập chính xác, thực hiện đăng nhập và chuyển hướng đến trang quản trị
                return "redirect:/shopping";
            }
        }
        // Nếu thông tin không đúng, thiết lập thông báo lỗi trong session và trả về trang đăng nhập
        session.setAttribute("error", "Tài khoản hoặc mật khẩu không chính xác");
        return "client/login";
    }

}