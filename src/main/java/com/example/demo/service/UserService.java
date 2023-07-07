package com.example.demo.service;



import com.example.demo.model.User;

import java.util.List;


public interface UserService {
    void add(User user);

    List<User> listUser();

    User show(int id);

    void delete(User user);

    void update(User user, int id);
}
