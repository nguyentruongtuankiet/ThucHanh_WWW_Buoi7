package vn.edu.iuh.fit.thwww_buoi7.frontend.controllers;


import jakarta.servlet.http.HttpSession;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.thwww_buoi7.backend.enums.ProductStatus;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Product;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.ProductImage;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.ProductPrice;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.ProductImageRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.ProductPriceRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.services.ProductServices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductPriceRepository productPriceRepository;


    @GetMapping("/products")
    public String showProductListPaging(
            HttpSession session,
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);

        Page<Product> candidatePage = productServices.findPaginated(currentPage - 1,
                pageSize, "name", "asc");

        model.addAttribute("productPage", candidatePage);

        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "admin/product/listing";
    }

    @GetMapping("/products/show-add-form")
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        ProductStatus[] productStatus = ProductStatus.values();
        model.addAttribute("productStatus", productStatus);
        return "admin/product/add-form";
    }

    @PostMapping("/products/add")
    public String addProducts(
            @ModelAttribute("product") Product product,
            BindingResult result, Model model) {
        Faker faker = new Faker();
        Random rnd = new Random();
        Device devices = faker.device();
        int i = productRepository.findAll().size();
        productRepository.save(product);
        ProductImage img = new ProductImage("assets/img-sample.png", "sample image");
        img.setProduct(product);
        productImageRepository.save(img);
        ProductPrice price = new ProductPrice(LocalDateTime.now(), rnd.nextInt(1500), "Note #" + i+1 );
        price.setProduct(product);
        productPriceRepository.save(price);
        return "redirect:/admin/products";
    }

    //    @DeleteMapping("/products/delete/{id}")
    @GetMapping("/products/delete/{id}")
    public String addProducts(@PathVariable("id") long id) {
        Product product = productRepository.findById(id).orElse(new Product());
        productRepository.delete(product);
        return "redirect:/admin/products";
    }


}