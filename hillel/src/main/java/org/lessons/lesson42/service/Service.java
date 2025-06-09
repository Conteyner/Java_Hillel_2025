package org.lessons.lesson42.service;

import org.lessons.lesson42.entity.Post;
import org.lessons.lesson42.entity.User;
import org.lessons.lesson42.repository.PostRepository;
import org.lessons.lesson42.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    private final UserRepository userRepo;
    private final PostRepository postRepo;

    public Service(UserRepository userRepo, PostRepository postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @Transactional
    public User createUser(User user, List<Post> posts){
        user.setPost(posts);
        posts.forEach(p -> p.setUser(user));
        User saved = userRepo.save(user);

        if(saved.getName().contains("bad")) {
            throw new RuntimeException("Lox");
        }
        return saved;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserByName(String name) {
        return userRepo.findByName(name).stream().findFirst();
    }

    @Transactional(readOnly = true)
    public List<User> getUserByEmail(String domain) {
        return userRepo.findByEmail(domain);
    }

    @Transactional(readOnly = true)
    public List<Post> getPostByUserId(Long userId) {
        return postRepo.findAllByUserId(userId);
    }

}

