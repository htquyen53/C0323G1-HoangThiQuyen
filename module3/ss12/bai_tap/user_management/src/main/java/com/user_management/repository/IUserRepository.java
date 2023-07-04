package com.user_management.repository;

import com.user_management.model.User;

import java.util.List;

public interface IUserRepository {
    public void insertUser(User user);
    public User selectUser(int id);
    public List<User> selectAllUsers();
    public boolean deleteUser(int id);
    public boolean updateUser(User user);
    public List<User> searchByCountry(String country);
    public List<User> sortByName();
}
