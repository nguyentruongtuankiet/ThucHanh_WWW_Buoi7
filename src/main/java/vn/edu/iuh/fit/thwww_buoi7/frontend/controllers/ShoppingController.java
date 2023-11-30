package vn.edu.iuh.fit.thwww_buoi7.frontend.controllers;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Product;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.ProductImage;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.ProductPrice;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.ProductImageRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.ProductPriceRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.services.ProductServices;
import vn.edu.iuh.fit.thwww_buoi7.frontend.dto.CartItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductPriceRepository productPriceRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @GetMapping()
    public String showProductListPaging(
            HttpSession session,
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

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
        return "client/index";
    }

    @GetMapping("/add2cart/{id}")
    public String add2Cart(HttpSession session, Model model, @PathVariable("id") long id) {
        List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cartItemList");
        if (cartItemList == null) {
            cartItemList = new ArrayList<>();
        }
        Product product = productRepository.findById(id).orElse(new Product());
        boolean found = false;
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getProduct().getProduct_id() == id) {
                cartItem.setAmount(cartItem.getAmount() + 1);
                found = true;
                break;
            }
        }
        if (!found) {
            CartItem newCartItem = new CartItem();
            newCartItem.setProduct(product);
            newCartItem.setAmount(1);
            cartItemList.add(newCartItem);
        }
        List<ProductImage> productImageLis = productImageRepository.findAll();
        List<ProductPrice> productPriceList = productPriceRepository.findAll();
        for (CartItem cartItem : cartItemList) {
            cartItem.getProduct().getProductImageList().get(0).setPath(productImageLis.get(0).getPath());
            ProductPrice productPrice = productPriceRepository.findByProduct(cartItem.getProduct()).get(0);
            cartItem.getProduct().getProductPrices().get(0).setPrice(productPrice.getPrice());
        }
        Double total = 0.0;
        for (CartItem cartItem : cartItemList) {
            total += cartItem.getAmount() * cartItem.getProduct().getProductPrices().get(0).getPrice();
        }
        session.setAttribute("total", total);
        session.setAttribute("cartItemList", cartItemList);
        session.setAttribute("sizecartItemList", cartItemList.size());
        return "redirect:/shopping";
    }

}