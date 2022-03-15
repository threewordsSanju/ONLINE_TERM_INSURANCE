package com.onlinetermInsurance.service;
import java.sql.Date;
import java.time.LocalDate;

import javax.xml.bind.ValidationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.onlinetermInsurance.entity.Login;
import com.onlinetermInsurance.entity.User;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.repository.LoginDao;

@SpringBootTest
public class TestLoginServiceImpl {

	@Autowired
	LoginServiceImpl loginServiceImpl;

    @MockBean
	UserServiceImpl userServiceImpl;

	@MockBean
	LoginDao loginRepository;
	
//----------------------------------------------------------------------------------------->ADD USERS<------------------------------------------------------------------------------------------\\
	@Test
	void addUser() throws ResourceNotFoundException, ValidationException{
		User newUser = new User();
		newUser.setFname("fname");
		newUser.setLname("lname");
		newUser.setPhoneNo(9876512345l);
		newUser.setAadhar("987676545432l");
		Date date = Date.valueOf("2020-11-18");
		newUser.setDob(date);
		System.out.println(userServiceImpl.saveUser(newUser));
	}

	//----------------------------------------------------------------------------------------->ADD USERS CREDITINALS<------------------------------------------------------------------------------------------\\	
	@Test
	void addUserCredentials() throws ResourceNotFoundException, ValidationException {
		Login Login = new Login();
		Login.setUserName("fname");
		Login.setPassword("Password@123");
		Login.setUserType("admin");
	loginServiceImpl.addUserCredentials(Login);
	}

	//----------------------------------------------------------------------------------------->UPDATE USERS CREDITINALS<------------------------------------------------------------------------------------------\\	
	@Test
	@Transactional
	void updateUserCredentials() {
		Login Login = new Login();
		Login.setUserName("FirstName");
		Login.setPassword("NewPassword@1234");
	}

	//-------------------------------------------------------------------------------------->GET ALL USER<-----------------------------------------------------------------------------------------------\\
	@Test
	void getAllUser() {
		userServiceImpl.getAllUsers();
	}
	
	//-------------------------------------------------------------------------------------->GETALLUSERCREDITINALS<-----------------------------------------------------------------------------------------------\\
	@Test
	void getAllUserCredentials() {
	System.out.println(	loginServiceImpl.getAllUserCredentials());
	}

	//-------------------------------------------------------------------------------------->DELETEUSERCREDITINALS<-----------------------------------------------------------------------------------------------\\
	@Test
	void deteleUserCredential() {
		Login login = new Login();
		login.setUserName("FirstName");
		login.setPassword("NewPassword@1234");
	}
}
