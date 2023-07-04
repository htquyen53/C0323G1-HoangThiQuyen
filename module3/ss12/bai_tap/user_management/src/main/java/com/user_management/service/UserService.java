package com.user_management.service;

import com.user_management.model.User;
import com.user_management.repository.IUserRepository;
import com.user_management.repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private static IUserRepository userRepository = new UserRepository();

    @Override
    public List<User> showUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public User searchById(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public void add(User user) {
        userRepository.insertUser(user);
    }

    @Override
    public void edit(int id, User user) {
        userRepository.updateUser(user);
    }

    @Override
    public void remove(int id) {
        userRepository.deleteUser(id);
    }

    @Override
    public List<User> searchByCountry(String country) {
        return userRepository.searchByCountry(country);
    }
}
