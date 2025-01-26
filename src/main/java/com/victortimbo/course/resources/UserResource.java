package com.victortimbo.course.resources;

import com.victortimbo.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> getUser() {
        User user = new User(1L, "maria", "maria@gmail.com", "12345", "789456123");
        return ResponseEntity.ok().body(user);
    }
}
