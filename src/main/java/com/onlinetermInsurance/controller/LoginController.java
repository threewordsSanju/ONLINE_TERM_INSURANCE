package com.onlinetermInsurance.controller;

import java.util.List;

import javax.xml.bind.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinetermInsurance.entity.Login;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.service.LoginServiceImpl;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class LoginController {
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//--------------------------------------------------------------------------------->AUTOWIRED BEAN CLASS<-----------------------------------------------------------------------------------------------------------\\
	@Autowired
	private LoginServiceImpl loginServiceImpl;

	//--------------------------------------------------------------------------------->ADDING USERCREDITINALS METHOD<--------------------------------------------------------------------------------------------\\
	@ApiOperation(value="Adding User.....")
	@PostMapping("/addusercd")
	public ResponseEntity<Login> addCredentials(@RequestBody Login l) throws ValidationException, ResourceNotFoundException {
		Login adduser = loginServiceImpl.addUserCredentials(l);
		logger.info("Adding the user.....");
		return new ResponseEntity<Login> (adduser, HttpStatus.OK);
	}
	
	
	//---------------------------------------------------------------------------------> UPDATE USERCREDITINALS METHOD<--------------------------------------------------------------------------------------------\\
	@PutMapping("/updateLogin/{username}/{password}")
	public ResponseEntity<String> updateusercd(@RequestBody Login l) throws ResourceNotFoundException {
		String s = loginServiceImpl.updateUserCredentials(l.getUserName(), l.getPassword(),l.getEmail());
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	
    //---------------------------------------------------------------------------------> UPDATE USERCREDITINALS METHOD<--------------------------------------------------------------------------------------------\\
	@ApiOperation(value="Deleting the user.....")
	@DeleteMapping("/deleteusercd")
	public ResponseEntity<String> deleteUserCd(@RequestBody Login l) throws ValidationException, ResourceNotFoundException {
		String s = loginServiceImpl.deleteUserCredentials(l.getUserName(), l.getPassword());
		logger.info("Deleting the user.....");
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
    //---------------------------------------------------------------------------------->GETALLUSERCREDITINALS<------------------------------------------------------------------------------------------------------\\
	@GetMapping("/getAll")
	@ApiOperation(value="Get all Login details")
	public List<Login> getAll() {
		logger.info("Get all Login");
		return  loginServiceImpl.getAllUserCredentials();
	}

	  //---------------------------------------------------------------------------------->GET ALL LOGIN CREDITINALS USERNAME AND PASSWORD<--------------------------------------------------------------------------------------------------------------------\\
	@GetMapping("/login/{username}/{password}")
	@ApiOperation(value="Get Login by username and password")
	public ResponseEntity<Login> getLoginByUserName(@PathVariable(value = "username") String username,@PathVariable(value = "password") String password) throws ResourceNotFoundException {
		logger.info("Login by username and password");
		Login login=loginServiceImpl.getLoginByUserName(username, password);
		return  ResponseEntity.ok(login);
	}	 
}