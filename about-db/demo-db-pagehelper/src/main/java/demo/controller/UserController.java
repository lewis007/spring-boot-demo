package demo.controller;

import com.github.pagehelper.PageInfo;
import demo.pagehelper.User;
import demo.pagehelper.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/db")
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
        n.setName(name + "-pagehelper");
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

    @PostMapping(path = "/addUsers")
    public @ResponseBody
    String addNewUsers(@RequestParam Integer num) {
        num = (num <= 0) ? 10 : num;

        List<User> users = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            User u = new User();
            u.setName("lewis-ph-" + i);
            u.setEmail("lewis-ph-" + i + "@tomato.cn");
            users.add(u);
        }

        userService.addUsers(users);
        return "Saved More (" + num + ")";
    }

    @GetMapping(path = "/findByPage")
    public @ResponseBody
    Iterable<User> getAllByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo<User> pageInfo = userService.findAllByPage(pageNum, pageSize);
        return pageInfo.getList();
    }

}
