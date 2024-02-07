package com.cosimo.test;

import com.cosimo.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email, @RequestParam String surname) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setSurname(surname);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/all/{id}")
    public @ResponseBody String delete(@PathVariable String id) {

        Long userId = Long.parseLong(id);
        userRepository.deleteById(userId);
        return "User deleted";
    }

}
