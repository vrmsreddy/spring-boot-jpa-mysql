package com.ms.spring.boot.jpa.controller;

import com.ms.spring.boot.jpa.model.User;
import com.ms.spring.boot.jpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/all")
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<User> getUser(@PathVariable("name") final String name) {
        return usersRepository.findByName(name);

    }

    @GetMapping("/id/{id}")
    public User getId(@PathVariable("id") final String id) {
        return usersRepository.findById(id).orElse(null);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id, @PathVariable("name")
                         final String name) {
        User user = getId(id);
        user.setName(name);

        return usersRepository.save(user);
    }

    @PutMapping("/create")
    public String addUser(@RequestBody User user){
        usersRepository.save(user);
        return "SUCCESS";
    }
}
