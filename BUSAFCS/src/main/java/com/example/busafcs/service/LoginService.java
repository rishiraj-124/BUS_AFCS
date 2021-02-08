package com.example.busafcs.service;

import com.example.busafcs.bean.AfcsApiRequest;
import com.example.busafcs.bean.AfcsApiResponse;
import com.example.busafcs.bean.ChangePasswordRequest;
import com.example.busafcs.bean.LoginRequest;
import com.example.busafcs.bean.MobileVerificationRequest;
import com.example.busafcs.entities.UserEntity;

public interface LoginService {

	public AfcsApiResponse login(LoginRequest loginRequest);
	
	public AfcsApiResponse driverCondlogin(LoginRequest loginRequest);
	
	public UserEntity getUserProfile(String userName);
	
	public AfcsApiResponse verifyMobile(AfcsApiRequest afcsApiRequest,
			MobileVerificationRequest mobileVerificationRequest);
	
	public AfcsApiResponse changePassword(ChangePasswordRequest ChangePasswordRequest);
	
	public UserEntity updateUser(UserEntity userEntity);

	}
