package com.example.busafcs.service.Impl;

import java.util.ArrayList;
import java.util.List;

/*import org.apache.tomcat.websocket.AuthenticationException;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.busafcs.bean.AfcsApiRequest;
import com.example.busafcs.bean.AfcsApiResponse;
import com.example.busafcs.bean.ChangePasswordRequest;
import com.example.busafcs.bean.LoginRequest;
import com.example.busafcs.bean.MobileVerificationRequest;
import com.example.busafcs.config.JWTTokengenerator;
import com.example.busafcs.dao.UserEntityDAO;
import com.example.busafcs.entities.DriverConductorEntity;
import com.example.busafcs.entities.UserEntity;
import com.example.busafcs.service.LoginService;
import com.example.busafcs.util.AFCSConstants;
import com.example.busafcs.util.AuthenticationUtil;

@Service("loginService")
@ComponentScan("com.example.busafcs")
public class LoginServiceImpl implements LoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	AuthenticationUtil authenticationUtil;

	
	@Autowired
	UserEntityDAO userEntityDAO;
	
	@Autowired
	private JWTTokengenerator jwtTokengenerator;


	@Autowired
	public LoginServiceImpl(AuthenticationUtil authenticationUtil) {
		// this.database = database;
		this.authenticationUtil = authenticationUtil;
	}


	@Override
	public AfcsApiResponse login(LoginRequest loginRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		UserEntity userEntity=null;
		//String userName = loginRequest.getUserId();
		String userPassword = loginRequest.getPassword();
		String mobile = loginRequest.getMobile();
		List<UserEntity> loginResponseList = new ArrayList<UserEntity>();
		
		userEntity = userEntityDAO.findByMobile(mobile);
		

		String secureUserPassword = null;
		boolean authenticated = false;
		/*
		 * try { secureUserPassword = authenticationUtil.
		 * generateSecurePassword(userPassword, userEntity.getSalt()); } catch
		 * (InvalidKeySpecException ex) {
		 * //log.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null,
		 * ex); try { throw new AuthenticationException(ex.getLocalizedMessage()); }
		 * catch (AuthenticationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 * 
		 * boolean authenticated = false; if (secureUserPassword != null &&
		 * secureUserPassword.equalsIgnoreCase(userEntity.getUserPassword())) { if
		 * (userName != null && userName.equalsIgnoreCase(userEntity.getUserName())) {
		 * authenticated = true; } }
		 */

		if (userEntity!=null) {
			if ("Customer".equalsIgnoreCase(userEntity.getUserRole())) {
				if ((userPassword != null && userPassword.equalsIgnoreCase(userEntity.getUserPassword()))
						&&(mobile != null && mobile.equalsIgnoreCase(userEntity.getMobile())) ){
					if ("Verified".equalsIgnoreCase(userEntity.getMobileVerificationStatus()))
						{
						authenticated = true;
						/*String token = generateNewToken();
						loginRequest.setToken(token);
						userEntity.setToken(token);
						userEntity = updateUser(userEntity);
						loginRequest.setStatus("Mobile Verified");
						loginRequest.setPwd(null);
						loginRequest.setId(String.valueOf(userEntity.getId()));
						loginRequest.setFirstName(userEntity.getFirstName());
						loginRequest.setLastName(userEntity.getLastName());
						loginRequest.setEmailId(userEntity.getEmailId());
						loginRequest.setMobile(userEntity.getMobile());
						*/
						
						//loginResponseList.add(loginRequest);
						loginResponseList.add(userEntity);
						afcsApiResponse.setPayloadObj(loginResponseList);
						afcsApiResponse.setResMessage("Login Succesfull");
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
						String authToken=jwtTokengenerator.getJWTToken(userEntity.getMobile(),"USER");
						afcsApiResponse.setAuthtoken(authToken);
						// loginRequest.setStations(stationMap);
					}else {
						loginRequest.setStatus("Failed");
						loginRequest.setPassword(null);
						afcsApiResponse.setPayloadObj(loginResponseList);
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
						afcsApiResponse.setResMessage("Mobile not verified");
					}
				} else {
					loginRequest.setStatus("Failed");
					loginRequest.setPassword(null);;
					afcsApiResponse.setPayloadObj(loginResponseList);
					afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
					afcsApiResponse.setResMessage("Invalid Credentials");

				}
			}  
		}else {
			loginRequest.setStatus("Failed");
			loginRequest.setPassword(null);
			afcsApiResponse.setPayloadObj(loginResponseList);
			afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
			afcsApiResponse.setResMessage("User not Exist");
		}
		if (!authenticated) {
			try {
				throw new Exception("Authentication failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//BeanUtils.copyProperties(userEntity, userProfile);
		return afcsApiResponse;
	}
	
	
	@Override
	public AfcsApiResponse driverCondlogin(LoginRequest loginRequest) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		DriverConductorEntity driverConductorEntity=null;
		//String userName = loginRequest.getUserId();
		String mobile = loginRequest.getMobile();
		String employeeId = loginRequest.getEmployeeId();
		String mpin=loginRequest.getMpin();
		String userPassword = loginRequest.getPassword();

		
		List<DriverConductorEntity> loginResponseList = new ArrayList<DriverConductorEntity>();
		
		if(null!=employeeId) {
			driverConductorEntity = userEntityDAO.findByEmpId(employeeId);
		}else {
		driverConductorEntity = userEntityDAO.findByDrivCondMobile(mobile);
		}

		String secureUserPassword = null;
		boolean authenticated = false;
		/*
		 * try { secureUserPassword = authenticationUtil.
		 * generateSecurePassword(userPassword, userEntity.getSalt()); } catch
		 * (InvalidKeySpecException ex) {
		 * //log.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null,
		 * ex); try { throw new AuthenticationException(ex.getLocalizedMessage()); }
		 * catch (AuthenticationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 * 
		 * boolean authenticated = false; if (secureUserPassword != null &&
		 * secureUserPassword.equalsIgnoreCase(userEntity.getUserPassword())) { if
		 * (userName != null && userName.equalsIgnoreCase(userEntity.getUserName())) {
		 * authenticated = true; } }
		 */

		if (driverConductorEntity!=null) {
			if ("Driver".equalsIgnoreCase(driverConductorEntity.getRole())|| "Conductor".equalsIgnoreCase(driverConductorEntity.getRole())) {
				if ((userPassword != null && userPassword.equalsIgnoreCase(driverConductorEntity.getPassword()))
						&&(mobile != null && mobile.equalsIgnoreCase(driverConductorEntity.getMobile())) ){
					if ("Permanent".equalsIgnoreCase(driverConductorEntity.getStatus()))
						{
						authenticated = true;
						
						//loginResponseList.add(loginRequest);
						loginResponseList.add(driverConductorEntity);
						afcsApiResponse.setPayloadObj(loginResponseList);
						afcsApiResponse.setResMessage("Login Succesfull");
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
						String authToken=jwtTokengenerator.getJWTToken(driverConductorEntity.getMobile(),"USER");
						afcsApiResponse.setAuthtoken(authToken);
						// loginRequest.setStations(stationMap);
					}else {
						loginRequest.setStatus("Failed");
						loginRequest.setPassword(null);
						afcsApiResponse.setPayloadObj(loginResponseList);
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
						afcsApiResponse.setResMessage("Mobile not verified");
					}
				} else {
					loginRequest.setStatus("Failed");
					loginRequest.setPassword(null);;
					afcsApiResponse.setPayloadObj(loginResponseList);
					afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
					afcsApiResponse.setResMessage("Invalid Credentials");

				}
			}  
		}else {
			loginRequest.setStatus("Failed");
			loginRequest.setPassword(null);
			afcsApiResponse.setPayloadObj(loginResponseList);
			afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
			afcsApiResponse.setResMessage("User not Exist");
		}
		if (!authenticated) {
			try {
				throw new Exception("Authentication failed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//BeanUtils.copyProperties(userEntity, userProfile);
		return afcsApiResponse;
	
	}
	
	@Override
	public AfcsApiResponse verifyMobile(AfcsApiRequest afcsApiRequest,MobileVerificationRequest mobileVerificationRequest) {
		
		UserEntity userEntity=null;
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			userEntity = userEntityDAO.getUserProfile(mobileVerificationRequest.getUserId());
			
			if (userEntity.getMobileOtp().equalsIgnoreCase(mobileVerificationRequest.getOtp())) {
				userEntity.setMobileVerificationStatus("Verified");;
				userEntity = updateUser(userEntity);
				afcsApiResponse.setResMessage("Mobile Verification Successful");
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
			}else {
				afcsApiResponse.setResMessage("WRONG OTP ");
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			afcsApiResponse.setResMessage("Invalid Auth Key");
			afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
			return afcsApiResponse;
			
		}
		
		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse changePassword(ChangePasswordRequest changePasswordRequest) {
		AfcsApiResponse afcsApiResponse=new AfcsApiResponse();
		UserEntity userEntity= getUserProfile(changePasswordRequest.getUserId());
		if(!"Y".equalsIgnoreCase(changePasswordRequest.getFpFlag())) {
			if(userEntity != null && userEntity.getUserPassword().equals(changePasswordRequest.getOldPassword())) {
				userEntity.setUserPassword(changePasswordRequest.getNewPassword());
				userEntity = updateUser(userEntity);
				if(userEntity.getId()!=null) {
					afcsApiResponse.setResMessage("Password Changed Succesfully");
					afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
				}
				
			}else {
				afcsApiResponse.setResMessage("Old Password not correct");
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
			}
		}else {
			userEntity.setUserPassword(changePasswordRequest.getNewPassword());
			userEntity = updateUser(userEntity);
			if(userEntity.getId()!=null) {
				afcsApiResponse.setResMessage("Password Changed Succesfully");
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
			}
		}
		
		
		return afcsApiResponse;
	}
	
	public UserEntity updateUser(UserEntity userEntity) {
		try{
			userEntity = userEntityDAO.updateUser(userEntity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return userEntity;
	}
	
	public UserEntity getUserProfile(String userName) {
		UserEntity userEntity = null;
		try {
			userEntity = userEntityDAO.getUserProfile(userName);
		} catch (Exception e) {
		}
		return userEntity;
	}


	

}
