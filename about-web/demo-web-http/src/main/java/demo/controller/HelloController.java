package demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/web")
@RestController
public class HelloController {

    private String message = "Hello, %s!";

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "World") String name) {
        return String.format(message, name);
    }

    @GetMapping("/create")
    public Map<String, Object> createGet(@RequestParam String name, @RequestParam Integer age) {
        return newInstance(name, age);
    }

    @PostMapping("/create")
    public Map<String, Object> createPost(@RequestParam String name, @RequestParam Integer age) {
        return newInstance(name, age);
    }

    private Map<String, Object> newInstance(String name, Integer age) {
        Map<String, Object> map = new HashMap<>();

        map.put("id", UUID.randomUUID());
        map.put("name", name);
        map.put("age", age);

        return map;
    }

}
