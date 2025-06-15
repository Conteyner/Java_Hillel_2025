package com.lsn.lesson43.service;

import com.lsn.lesson43.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Limbo {
    private final List<User> users = List.of(
            new User(1L,"Nick","96-754-1466","singletoneEvangelist@gmail.com"),
            new User(2L,"Tomas","14-256-5124","idk@gmail.com")
    );

    public List<User> getUsers() {
        return users;
    }
}
