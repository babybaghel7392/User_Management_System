package com.user.test.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.test.entity.OurUser;
import com.user.test.exception.UserException;
import com.user.test.repository.UserRepo;

@RestController
@CrossOrigin("http://localhost:3000")
public class Usercontroller {
	
	@Autowired
	private UserRepo repo;
	
	@PostMapping("/user")
	OurUser newUser(@RequestBody OurUser newUser) {
		return repo.save(newUser);
	}
	
	@GetMapping("/getAlluser")
	List<OurUser> getalluser()
	{
		return repo.findAll();
	}
	
	@GetMapping("/user/{id}")
	OurUser getUserById(@PathVariable Long id)
	{ 
		return repo.findById(id)
		.orElseThrow(()-> new UserException(id));
	}
	
	@PutMapping("/user/{id}")
	OurUser updateUser(@RequestBody OurUser newuser,@PathVariable Long id)
	{
		return repo.findById(id)
				.map(user->
				{
					user.setName(newuser.getName());
					user.setEmail(newuser.getEmail());
					user.setAddress(newuser.getAddress());
					return repo.save(user);
				}).orElseThrow(()->new UserException(id));
	}
	
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Long id)
	{
		if(!repo.existsById(id))
		{
			throw new UserException(id);
		}
		repo.deleteById(id);
		return " user with id :"+ id+ "has been deleted ";
	}
}
