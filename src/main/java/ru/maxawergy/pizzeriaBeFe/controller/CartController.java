package ru.maxawergy.pizzeriaBeFe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.maxawergy.pizzeriaBeFe.entity.Customer;
import ru.maxawergy.pizzeriaBeFe.service.CustomerService;

@Controller
public class CartController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/cart")
    public String getCart(Model model){
        Customer current_user = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("dishes", customerService.getCustomerDishes(current_user));
        model.addAttribute("totalCost", customerService.getTotalCost(current_user));
        return "cart";
    }

    @GetMapping("/cart-clear")
    public String clearCart(Model model){
        Customer current_user = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("infoSetting", true);
        model.addAttribute("infoMessage", "Ваша корзина успешно очищена");
        customerService.removeDishes(current_user);
        return "cart";
    }

    @PostMapping("/cart")
    public String orderCart(Model model, @ModelAttribute("comment") String comment){
        Customer current_user = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        customerService.makeOrder(current_user, comment);
        System.out.println("1111111111111111111111111: " + comment);
        model.addAttribute("infoSetting", true);
        model.addAttribute("infoMessage", "Ваш заказ готовится");
        return "cart";
    }
}
