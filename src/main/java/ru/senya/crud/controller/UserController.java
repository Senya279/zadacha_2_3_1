package ru.senya.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.senya.crud.model.User;
import ru.senya.crud.service.UserService;

@Controller
public class UserController {

private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String listUserMetod(Model model){
        model.addAttribute("users", userService.listUsers());
        return "index";
}

    @GetMapping(value = "/users/edit")
    public String idUserMetod(@RequestParam(value = "id")int id,Model model) {
        model.addAttribute("user",userService.findUserByID(id));
        return "edit";
    }

    @GetMapping(value = "/users/new")
    public String saveUserMetod(Model model) {
       model.addAttribute("user",new User());
       return "new";
    }

    @PostMapping (value = "/users/save")
    public String saveUserPos(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping (value = "/users/update")
    public String updateUserPos(@ModelAttribute("user")User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping (value = "/users/delete")
    public String deleteUserPos(@RequestParam("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
