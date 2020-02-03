package com.userservice.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.dto.UserDto;
import com.userservice.model.User;
import com.userservice.services.UserServices;

@RestController
@RequestMapping("/userService")
public class UserResources {

	private Log log = LogFactory.getLog(UserResources.class);

	@Autowired
	private UserServices userServices;

	
	@GetMapping(value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto getUser(@PathVariable int id) throws Exception {
		UserDto userDto = userServices.getUser(id);
		log.info("get user method()" + userDto);
		return userDto;
	}

	@PostMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto saveUser(@RequestBody User user) {
		log.info("save user into db" + user);
		UserDto userDto = userServices.saveUser(user);

		return userDto;

	}

	@PutMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto updateUser(@RequestBody User user) {
		log.info("update user into db" + user);
		UserDto userDto = userServices.updateUser(user);
		return userDto;
	}


	@DeleteMapping(value ="/deleteUser/{id}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteUser(@PathVariable int id) {
		boolean falg=userServices.deleteUser(id);
		if(falg) {
			log.info("delete user data into db"+id);
			return "your data is deleted sucessfully";
		}else {
			log.error("record is not found"+id);
			return "record is not found";		
		}


	}


}
