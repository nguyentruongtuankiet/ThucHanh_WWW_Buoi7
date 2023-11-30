package vn.edu.iuh.fit.thwww_buoi7.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.thwww_buoi7.backend.enums.ProductStatus;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Employee;
import vn.edu.iuh.fit.thwww_buoi7.backend.models.Product;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.OrderRepository;
import vn.edu.iuh.fit.thwww_buoi7.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.thwww_buoi7.frontend.dto.StatisticItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/statistic")

public class StatisticController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getstatisticmonthandyear")
    public String getStatisticMonthAndYear(Model model) {
        getStatisticByMonthAndYear(model, false);
        return "admin/product/statistic";
    }


    @GetMapping("/getstatistic")
    public String getStatistic(Model model, @RequestParam("month") String month, @RequestParam("year") String year) {
        List<StatisticItem> statisticItemList = new ArrayList<>();
        List<Object[]> objectslist = orderRepository.getOrderDetailsByYearAndMonth(Integer.parseInt(year), Integer.parseInt(month));
        for (Object[] o : objectslist) {
            Product product = new Product();
            product.setProduct_id(Long.valueOf(o[7].toString()));
            StatisticItem statisticItem = new StatisticItem();
            statisticItem.setProduct(product);
            statisticItem.setQuantity((int) Double.parseDouble(o[6].toString()) + 1);
            statisticItem.setTotal(Double.valueOf(o[6].toString()) * Double.valueOf(o[5].toString()));
            boolean found = false;
            for (StatisticItem statisticItem1 : statisticItemList) {
                if (statisticItem1.getProduct() != null && statisticItem.getProduct() != null &&
                        statisticItem1.getProduct().getProduct_id() == statisticItem.getProduct().getProduct_id()) {
                    statisticItem1.setQuantity(statisticItem1.getQuantity() + statisticItem.getQuantity());
                    statisticItem1.setTotal(statisticItem1.getTotal() + statisticItem.getTotal());
                    found = true;
                    break;
                }
            }

            if (!found) {
                statisticItemList.add(statisticItem);
            }
            List<String> productnamelist = new ArrayList<>();
            List<String> producttotallist = new ArrayList<>();
            List<String> productquantitylist = new ArrayList<>();

            for (StatisticItem statisticItem1 : statisticItemList) {
                productnamelist.add(productRepository.findById(statisticItem1.getProduct().getProduct_id()).orElse(new Product()).getName());
                producttotallist.add(String.valueOf(statisticItem1.getTotal()));
                productquantitylist.add(String.valueOf(statisticItem1.getQuantity()));
            }
            getStatisticByMonthAndYear(model, true);
            model.addAttribute("productnamelist", productnamelist);
            model.addAttribute("producttotallist", producttotallist);
            model.addAttribute("productquantitylist", productquantitylist);
            model.addAttribute("monthselect", month);
            model.addAttribute("yearselect", year);
        }
        return "admin/product/statistic";
    }

    private void getStatisticByMonthAndYear(Model model, Boolean aBoolean) {
        List<Object[]> list = orderRepository.getAllOrderMonthsAndYears();
        List<String> months = new ArrayList<>();
        List<String> years = new ArrayList<>();
        for (Object[] o : list) {
            String month = String.valueOf(o[0]);
            String year = String.valueOf(o[1]);
            if (!months.contains(month)) {
                months.add(month);
            }
            if (!years.contains(year)) {
                years.add(year);
            }
        }
        model.addAttribute("found", aBoolean);
        model.addAttribute("months", months);
        model.addAttribute("years", years);
    }
    @GetMapping("/goback")
    public String goback() {
        return "redirect:/admin/products";
    }


}
