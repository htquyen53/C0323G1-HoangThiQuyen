package com.user_management.service;

import com.user_management.model.User;

import java.util.List;

public interface IUserService {
    List<User> showUsers();
    User searchById(int id);
    void add(User user);
    void edit(int id,User user);
    void remove(int id);
    List<User> searchByCountry (String country);
}
