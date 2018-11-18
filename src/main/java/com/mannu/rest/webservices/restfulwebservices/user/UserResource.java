package com.mannu.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	
	//GET /users
	//retrieve all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	//retrieve user with id(using @PathVariable from url)
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id){
		return userDaoService.findOne(id);
	}
	
	//Create new user
	//CREATED --  status
	//input -  details of user (from request body using @RequestBody)
	//output -- created and return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User savedUser=userDaoService.save(user);
		
		//created
		// /user{id}  savedUser.getId()
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("{id}").
		buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
