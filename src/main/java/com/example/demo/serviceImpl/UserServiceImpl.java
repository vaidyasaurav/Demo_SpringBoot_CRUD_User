package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Override
	public List<User> allUsers(){
		return userRepository.findAll();
	}
	
	public User updateUser(User user,int id) {
		User userDB = userRepository.findById(id).get();
		
		if (Objects.nonNull(user.getName())
	            && !"".equalsIgnoreCase(
	                user.getName())) {
	            userDB.setName(
	                user.getName());
	        }
	 
	        if (Objects.nonNull(
	                user.getEmail())
	            && !"".equalsIgnoreCase(
	                user.getEmail())) {
	            userDB.setEmail(
	                user.getEmail());
	        }
		
		return userRepository.save(userDB);
	}
	
	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

}
