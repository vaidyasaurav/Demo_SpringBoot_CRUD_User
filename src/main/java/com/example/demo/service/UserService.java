package com.example.demo.service;

import java.util.List;

import com.example.demo.models.User;

public interface UserService {
	User addUser(User user);
	List<User> allUsers();
	User updateUser(User user,int id);
	void deleteUserById(int id);
}
