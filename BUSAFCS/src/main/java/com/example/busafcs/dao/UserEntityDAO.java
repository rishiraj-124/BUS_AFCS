package com.example.busafcs.dao;

import org.springframework.stereotype.Component;

import com.example.busafcs.entities.DriverConductorEntity;
import com.example.busafcs.entities.UserEntity;


public interface UserEntityDAO {

	 
	    public UserEntity getUserProfile(String userName);
	    
	    public UserEntity saveUser(UserEntity userEntity);
	    
	    public UserEntity updateUser(UserEntity userEntity);
	    
	    public UserEntity findByMobile(String mobile);
	    
	    public UserEntity getUserByToken(String token);
	    
	    public DriverConductorEntity findByEmpId(String empId);
	    
	    public DriverConductorEntity findByDrivCondMobile(String mobile);
}
