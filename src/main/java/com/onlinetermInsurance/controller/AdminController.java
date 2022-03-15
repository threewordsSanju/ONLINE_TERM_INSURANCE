package com.onlinetermInsurance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetermInsurance.entity.Policy;
import com.onlinetermInsurance.service.PolicyServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v2")
public class AdminController {
	
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	PolicyServiceImpl policyService;
	
	//-----------------------Create New Policy for
	@GetMapping("/addPolicy")
	@PostMapping("/policy")
	@ApiOperation(value="Create new policy (ADD)")
	public Policy saveUser( @RequestBody Policy policy1 ) {
		logger.info("Create Policy");
		return  policyService.savePolicy(policy1);
	}
	
	

}
