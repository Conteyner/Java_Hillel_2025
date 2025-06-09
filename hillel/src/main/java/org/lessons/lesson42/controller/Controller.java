package org.lessons.lesson42.controller;

import org.lessons.lesson42.entity.Post;
import org.lessons.lesson42.entity.User;
import org.lessons.lesson42.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser (@RequestBody User user){
        return ResponseEntity.ok(service.createUser(user, user.getPost()));
    }

    @GetMapping("/users/name/{name}")
    public ResponseEntity<User> getByName (@PathVariable String name){
        return service.getUserByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/users/domain")
    public List<User> getByDomain (@RequestBody String domain){
        return service.getUserByEmail(domain);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getPosts (@PathVariable Long id){
        return service.getPostByUserId(id);
    }

}
