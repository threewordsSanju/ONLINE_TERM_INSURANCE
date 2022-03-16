package com.onlinetermInsurance.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinetermInsurance.entity.Policy;
import com.onlinetermInsurance.entity.User;
import com.onlinetermInsurance.exception.ResourceNotFoundException;
import com.onlinetermInsurance.repository.PolicyDaoImpl;
import com.onlinetermInsurance.repository.UserDaoImpl;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {

	public static final Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

	@Autowired
	UserDaoImpl userDaoImpl;

	@Autowired
	private PolicyDaoImpl policyDaoImpl;

	public List<Policy> getAllPolicies() {
		logger.info("Policy Service get all");
		return policyDaoImpl.findAll();
	}

	public Policy findPolicyById(@PathVariable(value = "id") Integer policyid) throws ResourceNotFoundException {

		logger.info("Policy Service get by id");
		Policy policy1 = policyDaoImpl.findByPolicyId(policyid);
		if (policy1 == null) {
			new ResourceNotFoundException("Policy not found for this id :: " + policyid);
		}
		return policy1;
	}

	/*
	 * public List<userPolicy> findByUserIdAndPolicyId(int userId,int policyNo) {
	 * return (List<userPolicy>) userpolicy.findByUserIdAndPolicyId(userId,
	 * policyNo); }
	 */
	public boolean deletePolicyById(Integer policyid) throws ResourceNotFoundException {
		logger.info(" Delete Policy Service by Id");
		Policy policy1 = policyDaoImpl.findById(policyid)
				.orElseThrow(() -> new ResourceNotFoundException("Policy ot found for this id :: " + policyid));
		policyDaoImpl.delete(policy1);
		if (null == policy1) {
			return true;
		}
		return false;
	}

	public Policy savePolicy(Policy policy1) throws ResourceNotFoundException {
	//	String username = policy1.getUserName();
		User user = new User();
		try {
			String username = userDaoImpl.findByFname(policy1.getUserName()).getFname();
			user = userDaoImpl.findByFname(username);
			policy1.setUser(user);
			policyDaoImpl.save(policy1);
			}
		catch (NullPointerException ex) {
			throw new ResourceNotFoundException("user not valid");
		}

		return policy1;

	}

	public Policy updatePolicy(Integer policyid, Policy policies) throws ResourceNotFoundException {
		logger.info("Update Policy Service by Id");
		Policy policy1 = policyDaoImpl.findById(policyid)
				.orElseThrow(() -> new ResourceNotFoundException("Policy ot found for this id :: " + policyid));
		policy1.setId(policies.getId());
		policy1.setDescription(policies.getDescription());
		policy1.setYearsOfPayment(policies.getYearsOfPayment());
		policy1.setAmount(policies.getAmount());
		policy1.setMaturityperiod(policies.getMaturityperiod());
		policy1.setMaturityamount(policies.getMaturityamount());
		final Policy updatedPolicy = policyDaoImpl.save(policy1);
		return updatedPolicy;
	}

	public List<Policy> saveAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
