package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired 
	private UserService userservice;
	
	@PostMapping("/addUser")
	public User adduser(@RequestBody User user) {
		return userservice.addUser(user);
	}
	@GetMapping("/allUsers")
	public List<User> getAllUsers(){
		return userservice.allUsers();
	}
	
	@PutMapping("/updateUser/{id}") 
    public User
    updateDepartment(@RequestBody User department,
                     @PathVariable("id") int id)
    {
        return userservice.updateUser(
            department, id);
    }
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUserById(@PathVariable("id") int id) {
		userservice.deleteUserById(id);
		return "Deleted Successfully";
	}
}
