package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserTypeController {
	// This means to get the beans called userRepository and userTypeRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@PostMapping("/usertypes")
	@ResponseBody
	void addUserType(@RequestBody UserType userType) {
		userTypeRepository.save(userType);
	}
	
	@GetMapping("/usertypes")
	public @ResponseBody List<UserType> getAllUserTypes() {
		// This returns a JSON or XML with the user types
		return (List<UserType>) userTypeRepository.findAll();
	}
	
	@GetMapping("usertypes/{id}")
	public @ResponseBody Optional<UserType> getUserTypeById(@PathVariable int id) {
		return userTypeRepository.findById(id);
	}
	
	@PutMapping("usertypes/{id}")
	public @ResponseBody UserType updateUserType(@RequestBody final UserType updatedUserType) {
		return userTypeRepository.save(updatedUserType);
	}
	
	@DeleteMapping("usertypes/{id}")
	public @ResponseBody HttpStatus deleteUserType(@PathVariable final int id) {
		userTypeRepository.deleteById(id);
		return HttpStatus.OK;
	}
}