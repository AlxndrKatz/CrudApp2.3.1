package su.soviet.crudApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import su.soviet.crudApp.model.User;
import su.soviet.crudApp.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/new-user")
    public String createUserForm(User user) {
        return "new-user";
    }

    @PostMapping("/new-user")
    public String addUser(User user) {// new user
        service.createUser(user);
        return "redirect:/users";//?????
    }

    @GetMapping("/users")
    public String getUsers(Model model) {// все юзеры
        //model.addAttribute("users", service.getUsers());
        model.addAttribute("users", service.getUsers());
        return "users";// путь к хтмл-файлу
    }

    @GetMapping("/update-user/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update-user")
    public String updateUser(User user) { // апдейт
        service.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) { // удалить
        service.deleteUser(id);
        return "redirect:/users";
    }
}
