package vn.edu.iuh.fit.thwww_buoi7;

import jakarta.transaction.Transactional;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.thwww_buoi7.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.thwww_buoi7.backend.enums.ProductStatus;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.*;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.*;
import vn.edu.iuh.fit.thwww_buoi7.backend.services.ProductServices;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ThwwwBuoi7Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ThwwwBuoi7Application.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductPriceRepository productPriceRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductServices productServices;

    @Override
    @Transactional
    public void run(String... args) {
        Faker faker = new Faker();
        Random rnd = new Random();
        Device devices = faker.device();

        // Tạo dữ liệu mẫu cho Employee
//        for (int i = 0; i < 5; i++) {
//            Employee employee = new Employee(
//                    faker.name().fullName(),
//                    faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    faker.internet().emailAddress(),
//                    faker.phoneNumber().cellPhone(),
//                    faker.address().fullAddress(),
//                    EmployeeStatus.ACTIVE // Hoặc EmployeeStatus.INACTIVE tùy thuộc vào trạng thái
//            );
//            employeeRepository.save(employee);
//        }
//
//        // Tạo dữ liệu mẫu cho Customer
//        for (int i = 0; i < 10; i++) {
//            Customer customer = new Customer(
//                    faker.name().fullName(),
//                    faker.internet().emailAddress(),
//                    faker.phoneNumber().cellPhone(),
//                    faker.address().fullAddress()
//            );
//            customerRepository.save(customer);
//        }
//
//        // Tạo dữ liệu mẫu cho Product
//        for (int i = 0; i < 50; i++) {
//            Product product = new Product(
//                    devices.modelName(),
//                    faker.lorem().paragraph(30),
//                    "piece",
//                    devices.manufacturer(),
//                    ProductStatus.ACTIVE
//            );
//            product = productRepository.save(product);
//
//            ProductImage img = new ProductImage("assets/img-sample.png", "sample image");
//            img.setProduct(product);
//            productImageRepository.save(img);
//
//            ProductPrice price = new ProductPrice(LocalDateTime.now(), rnd.nextInt(1500), "Note #" + i);
//            price.setProduct(product);
//            productPriceRepository.save(price);
//        }
//
//        // Tạo dữ liệu mẫu cho Order và OrderDetail
//        List<Employee> employees = employeeRepository.findAll();
//        List<Customer> customers = customerRepository.findAll();
//        List<Product> products = productRepository.findAll();
//        for (int i = 0; i < 50; i++) {
//            Employee randomEmployee = employees.get(rnd.nextInt(employees.size()));
//            Customer randomCustomer = customers.get(rnd.nextInt(customers.size()));
//            Product randomProduct = products.get(rnd.nextInt(products.size()));
//
//            Order order = new Order(LocalDateTime.now(), randomEmployee, randomCustomer);
//            order = orderRepository.save(order);
//
//            OrderDetail orderDetail = new OrderDetail(
//                    rnd.nextDouble() * 10,
//                    rnd.nextDouble() * 10,
//                    "Note #" + i,
//                    order,
//                    randomProduct
//            );
//            orderDetailRepository.save(orderDetail);
//        }
    }
}
