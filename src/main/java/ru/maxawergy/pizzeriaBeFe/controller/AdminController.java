package ru.maxawergy.pizzeriaBeFe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.maxawergy.pizzeriaBeFe.entity.Dish;
import ru.maxawergy.pizzeriaBeFe.entity.Employer;
import ru.maxawergy.pizzeriaBeFe.service.DishService;
import ru.maxawergy.pizzeriaBeFe.service.EmployerService;

import java.io.IOException;
import java.util.Base64;

@Controller
public class AdminController {
    @Autowired
    private DishService dishService;
    @Autowired
    private EmployerService employerService;

    @GetMapping("/admin")
    public String getAdminPanel(Model model){
        return "admin";
    }

    @GetMapping("/admin-dish")
    public String dish(Model model){
        model.addAttribute("addDish", true);
        return "admin";
    }

    @PostMapping("/admin-dish")
    public String getDish(Model model,
                          @ModelAttribute("name") String name,
                          @ModelAttribute("radius") Integer radius,
                          @ModelAttribute("receipt") String receipt,
                          @ModelAttribute("weight") Float weight,
                          @ModelAttribute("cost") Integer cost,
                          @RequestParam("image")MultipartFile file) throws IOException {
        byte[] image = Base64.getEncoder().encode(file.getBytes());
        Dish dish = new Dish(name, cost, radius, weight, receipt, image);
        dishService.saveDish(dish);
        model.addAttribute("errorSetting", "true");
        model.addAttribute("message", "Блюдо сохранено");
        return "admin";
    }

    @GetMapping("/admin-emp")
    public String emp(Model model){
        model.addAttribute("addEmp", true);
        return "admin";
    }

    @PostMapping("/admin-emp")
    public String getEmp(Model model,
                         @ModelAttribute("nameE") String name,
                         @ModelAttribute("login") String login,
                         @ModelAttribute("password") String password,
                         @ModelAttribute("post") String post,
                         @ModelAttribute("salary") Integer salary){
        Employer employer = new Employer(name, post, salary, login, password);
        employerService.saveEmployer(employer);
        model.addAttribute("errorSetting", "true");
        model.addAttribute("message", "Сотрудник сохранен");
        return "admin";
    }

}
