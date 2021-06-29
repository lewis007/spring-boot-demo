package demo.controller;

import demo.mybatis.User;
import demo.mybatis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name + "-mybatis");
        n.setEmail(email);
        userService.addUser(n);
        return "Saved";
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    String updateUser(@RequestParam Integer id, @RequestParam String name, @RequestParam String email) {
        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setEmail(email);
        userService.updateUser(u);
        return "Updated";
    }

}
