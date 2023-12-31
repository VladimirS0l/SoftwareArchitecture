package ru.java.lesson7.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.java.lesson7.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    List<User> users = new ArrayList<>();

    {
        users.add(new User(1, "Ivan", "Ivanov", 24321.10));
        users.add(new User(2, "Petr", "Petrov", 321321.21));
        users.add(new User(3, "Valiliy", "Vasilev", 13213.11));
        users.add(new User(4, "Sergey", "Sergeev", 2321.53));
    }

    @GetMapping("/test")
    public String indexLayout() {
        return "index";
    }


    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
