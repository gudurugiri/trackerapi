/**
 * 
 */
package com.tracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.dao.UserRepository;
import com.tracker.model.UserInfo;

/**
 * @author Bujair
 *
 */
@RestController
@RequestMapping("/tracker/1.0/api")
public class UserController {

	private static final String SUCCESS = "SUCCESS";

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired(required = false)
	UserRepository userRepository;

	@GetMapping("/user")
	/**
	 * Getting all the Users
	 * 
	 * @return
	 */
	public List<UserInfo> getUser() {
		logger.debug("GET USERS");
		return userRepository.findAll();
	}

	/**
	 * Getting User data based on ID
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/user/{id}")
	public UserInfo getUser(@PathVariable("id") String id) {
		return userRepository.findById(getLongFromString(id)).orElse(null);
	}

	private long getLongFromString(String id) {
		try {
			return Long.parseLong(id);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Deleting user
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/user/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		userRepository.deleteById(getLongFromString(id));
		return SUCCESS;
	}

	/**
	 * Creating or Updating the User
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/user")
	public UserInfo createNote(@Valid @RequestBody UserInfo user) {
		return userRepository.save(user);
	}

}
