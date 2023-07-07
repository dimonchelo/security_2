package com.example.demo.service;



import com.example.demo.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {
    void add(User user);

    List<User> listUser();

    User show(int id);

    @Transactional
    User findByName(String name);

    void delete(User user);

    void update(User user, int id);
}
