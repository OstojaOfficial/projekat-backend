package com.ostoja.projekat;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private Map<Integer, String> users = new HashMap<>();

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id) {
        return users.getOrDefault(id, "User not found");
    }

    @PostMapping
    public String createUser(@RequestBody Map<String, String> user) {
        int id = users.size() + 1;
        users.put(id, user.get("name"));
        return "User created with ID: " + id;
    }
}
