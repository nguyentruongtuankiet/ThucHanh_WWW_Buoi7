package vn.edu.iuh.fit.thwww_buoi7.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Product;
import vn.edu.iuh.fit.thwww_buoi7.frontend.dto.CartItem;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @GetMapping("/view-cart")
    public String view_cart(Model model, HttpSession session) {

        return "client/checkout";
    }


    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        Object obj = session.getAttribute("items");
        List<Product> lst = (List<Product>) obj;
        return "";
    }

    @GetMapping("/plus/{id}")
    public String plus(HttpSession session, @PathVariable("id") String id) {
        List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cartItemList");
        if (cartItemList == null) {
            return "";
        } else {
            for (CartItem cartItem : cartItemList) {
                if (cartItem.getProduct().getProduct_id() == Long.valueOf(id)) {
                    cartItem.setAmount(cartItem.getAmount() + 1);
                    break;
                }
            }
            Double total = 0.0;
            for (CartItem cartItem : cartItemList) {
                total += cartItem.getAmount() * cartItem.getProduct().getProductPrices().get(0).getPrice();
            }
            session.setAttribute("total", total);
            session.setAttribute("cartItemList", cartItemList);
            return "client/checkout";
        }
    }

    @GetMapping("/minus/{id}")
    public String minus(HttpSession session, @PathVariable("id") String id) {
        List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cartItemList");
        if (cartItemList == null) {
            return "";
        } else {
            for (CartItem cartItem : cartItemList) {
                if (cartItem.getProduct().getProduct_id() == Long.valueOf(id)) {
                    if (cartItem.getAmount() <= 1) {
                        cartItem.setAmount(1);
                        break;
                    } else {
                        cartItem.setAmount(cartItem.getAmount() - 1);
                        break;
                    }
                }
            }
            Double total = 0.0;
            for (CartItem cartItem : cartItemList) {
                total += cartItem.getAmount() * cartItem.getProduct().getProductPrices().get(0).getPrice();
            }
            session.setAttribute("total", total);
            session.setAttribute("cartItemList", cartItemList);
            return "client/checkout";
        }
    }
}