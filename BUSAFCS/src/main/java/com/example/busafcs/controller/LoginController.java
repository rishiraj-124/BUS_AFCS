package com.example.busafcs.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.busafcs.bean.AfcsApiRequest;
import com.example.busafcs.bean.AfcsApiResponse;
import com.example.busafcs.bean.ChangePasswordRequest;
import com.example.busafcs.bean.CustomerRegistrationRequest;
import com.example.busafcs.bean.ForgetPasswordRequest;
import com.example.busafcs.bean.LoginRequest;
import com.example.busafcs.bean.MobileVerificationRequest;
import com.example.busafcs.bean.StopMasterRequest;
import com.example.busafcs.bean.ValidationBean;
import com.example.busafcs.config.JWTTokengenerator;
import com.example.busafcs.dao.UserEntityDAO;
import com.example.busafcs.entities.UserEntity;
import com.example.busafcs.service.LoginService;
import com.example.busafcs.service.TicketingService;
import com.example.busafcs.util.AFCSConstants;
import com.example.busafcs.util.AFCSUtil;
import com.example.busafcs.util.ExceptionUtils;
import com.example.busafcs.util.KeyEncryptionUtils;


@Controller
@RequestMapping("/api/auth")
@ComponentScan({"com.example.busafcs.bean","com.example.busafcs.service"})
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class); 
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	TicketingService ticketingService;
	
	@Autowired
	UserEntityDAO userEntityDAO;
	
	@Autowired
	private JWTTokengenerator jwtTokengenerator;
	
	@PostMapping(path="/login",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse login(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			
			Object payloadObj = afcsApiRequest.getPayloadObj();
			LoginRequest loginRequest = AFCSUtil.jsonStringToObject(payloadObj,
					LoginRequest.class);
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(loginRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				//loginRequest.setErrorMsg(errorMessage);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				afcsApiResponse.setResMessage(errorMessage);
				log.info(this.getClass().getSimpleName(),
						AFCSConstants.LOGGING_RESPONSE + AFCSConstants.LOGGING_METHOD_NAME
								+ Thread.currentThread().getStackTrace()[1].getMethodName()
								+ AFCSConstants.LOGGING_REQUEST_FROM + request.getRemoteAddr()
								+ AFCSConstants.LOGGING_USER_ADDRESS
								+ request.getHeader(AFCSConstants.USER_IP_ADDRESS)
								+ AFCSConstants.LOGGING_ERROR + errorMessage);

				return afcsApiResponse;

			} else {
				String errormsg="";
				if(errormsg.equals("")){
					afcsApiResponse = loginService.login(loginRequest);
				
				}else{
					loginRequest.setErrorMsg(errormsg);
				}
				

			}
			log.info("loginResponse--->> " + loginRequest.toString());
			
		} catch (Exception e) {

			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					AFCSConstants.PACKAGE_FOR_EXCEPTION);

			log.info(this.getClass().getSimpleName(), AFCSConstants.LOGGING_METHOD_NAME
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ AFCSConstants.LOGGING_ERROR_MESSAGE + e + AFCSConstants.LOGGGING_CLASS_NAME
					+ exceptionData[0] + AFCSConstants.LOGGING_FILE_NAME + exceptionData[1]
					+ AFCSConstants.LOGGING_METHOD_NAME + exceptionData[2]
					+ AFCSConstants.LOGGING_LINE_NUMBER + exceptionData[3]);
		}
		return afcsApiResponse;

	}
	
	
	@PostMapping(path="/driverCondlogin",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse driverCondlogin(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			
			Object payloadObj = afcsApiRequest.getPayloadObj();
			LoginRequest loginRequest = AFCSUtil.jsonStringToObject(payloadObj,
					LoginRequest.class);
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(loginRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				//loginRequest.setErrorMsg(errorMessage);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				afcsApiResponse.setResMessage(errorMessage);
				log.info(this.getClass().getSimpleName(),
						AFCSConstants.LOGGING_RESPONSE + AFCSConstants.LOGGING_METHOD_NAME
								+ Thread.currentThread().getStackTrace()[1].getMethodName()
								+ AFCSConstants.LOGGING_REQUEST_FROM + request.getRemoteAddr()
								+ AFCSConstants.LOGGING_USER_ADDRESS
								+ request.getHeader(AFCSConstants.USER_IP_ADDRESS)
								+ AFCSConstants.LOGGING_ERROR + errorMessage);

				return afcsApiResponse;

			} else {
				String errormsg="";
				if(errormsg.equals("")){
					afcsApiResponse = loginService.driverCondlogin(loginRequest);
				
				}else{
					loginRequest.setErrorMsg(errormsg);
				}
				

			}
			log.info("loginResponse--->> " + loginRequest.toString());
			
		} catch (Exception e) {

			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					AFCSConstants.PACKAGE_FOR_EXCEPTION);

			log.info(this.getClass().getSimpleName(), AFCSConstants.LOGGING_METHOD_NAME
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ AFCSConstants.LOGGING_ERROR_MESSAGE + e + AFCSConstants.LOGGGING_CLASS_NAME
					+ exceptionData[0] + AFCSConstants.LOGGING_FILE_NAME + exceptionData[1]
					+ AFCSConstants.LOGGING_METHOD_NAME + exceptionData[2]
					+ AFCSConstants.LOGGING_LINE_NUMBER + exceptionData[3]);
		}
		return afcsApiResponse;

	}
	
	@PostMapping(path="/custReg",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse custReg(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = null;
		try {
			log.info("afcsApiRequest--->> " + afcsApiRequest.toString());
			String channelId = request.getHeader("channelId");

			Object payloadObj = afcsApiRequest.getPayloadObj();

			CustomerRegistrationRequest customerRegistrationRequest = AFCSUtil.jsonStringToObject(payloadObj,
					CustomerRegistrationRequest.class);

			System.out.println();
			// System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils
					.validateBean(customerRegistrationRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setResSatus(300);
				afcsApiResponse.setResMessage(errorMessage);
				// customerRegistrationRequest.setErrorMsg(errorMessage);
				log.info(this.getClass().getSimpleName(),
						AFCSConstants.LOGGING_RESPONSE + AFCSConstants.LOGGING_METHOD_NAME
								+ Thread.currentThread().getStackTrace()[1].getMethodName()
								+ AFCSConstants.LOGGING_REQUEST_FROM + request.getRemoteAddr()
								+ AFCSConstants.LOGGING_USER_ADDRESS + request.getHeader(AFCSConstants.USER_IP_ADDRESS)
								+ AFCSConstants.LOGGING_ERROR + errorMessage);

				return afcsApiResponse;

			} else {
				String errormsg = "";
				if (errormsg.equals("")) {
					afcsApiResponse = ticketingService.custReg(customerRegistrationRequest);
				} else {

				}

			}
			log.info("customerRegistrationResponse--->> " + afcsApiResponse.toString());

		} catch (Exception e) {

			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					AFCSConstants.PACKAGE_FOR_EXCEPTION);

			log.info(this.getClass().getSimpleName(),
					AFCSConstants.LOGGING_METHOD_NAME + Thread.currentThread().getStackTrace()[1].getMethodName()
							+ AFCSConstants.LOGGING_ERROR_MESSAGE + e + AFCSConstants.LOGGGING_CLASS_NAME
							+ exceptionData[0] + AFCSConstants.LOGGING_FILE_NAME + exceptionData[1]
							+ AFCSConstants.LOGGING_METHOD_NAME + exceptionData[2] + AFCSConstants.LOGGING_LINE_NUMBER
							+ exceptionData[3]);
		}
		return afcsApiResponse;

	}
	
	
	@PostMapping(path="/mobileVerification",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse mobileVerification(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			MobileVerificationRequest mobileVerificationRequest =  AFCSUtil.jsonStringToObject(payloadObj,
					MobileVerificationRequest.class);

			
			String errormsg="";
			//String token = request.getHeader("tokenId");
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(mobileVerificationRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				mobileVerificationRequest.setErrorMsg(errorMessage);
				afcsApiResponse.setPayloadObj(mobileVerificationRequest);
				afcsApiResponse.setResMessage(errorMessage);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				log.info(this.getClass().getSimpleName(),
						AFCSConstants.LOGGING_RESPONSE + AFCSConstants.LOGGING_METHOD_NAME
								+ Thread.currentThread().getStackTrace()[1].getMethodName()
								+ AFCSConstants.LOGGING_REQUEST_FROM + request.getRemoteAddr()
								+ AFCSConstants.LOGGING_USER_ADDRESS
								+ request.getHeader(AFCSConstants.USER_IP_ADDRESS)
								+ AFCSConstants.LOGGING_ERROR + errorMessage);

				return afcsApiResponse;

			} else {
				String token = afcsApiRequest.getTokenId();

				if (mobileVerificationRequest != null) {
					afcsApiResponse= loginService.verifyMobile(afcsApiRequest ,mobileVerificationRequest);
				}				

			}
			log.info("AfcsApiResponse--->> " + mobileVerificationRequest.toString());
			
		} catch (Exception e) {

			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					AFCSConstants.PACKAGE_FOR_EXCEPTION);

			log.info(this.getClass().getSimpleName(), AFCSConstants.LOGGING_METHOD_NAME
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ AFCSConstants.LOGGING_ERROR_MESSAGE + e + AFCSConstants.LOGGGING_CLASS_NAME
					+ exceptionData[0] + AFCSConstants.LOGGING_FILE_NAME + exceptionData[1]
					+ AFCSConstants.LOGGING_METHOD_NAME + exceptionData[2]
					+ AFCSConstants.LOGGING_LINE_NUMBER + exceptionData[3]);
		}
		return afcsApiResponse;

	}
	
	@PostMapping(path="/changePwd",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse changePwd(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			ChangePasswordRequest changePasswordRequest = AFCSUtil.jsonStringToObject(payloadObj,
					ChangePasswordRequest.class);

			
			String errormsg="";
			//String token = request.getHeader("tokenId");
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(changePasswordRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				changePasswordRequest.setErrorMsg(errorMessage);
				afcsApiResponse.setPayloadObj(changePasswordRequest);
				afcsApiResponse.setResMessage(errorMessage);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				log.info(this.getClass().getSimpleName(),
						AFCSConstants.LOGGING_RESPONSE + AFCSConstants.LOGGING_METHOD_NAME
								+ Thread.currentThread().getStackTrace()[1].getMethodName()
								+ AFCSConstants.LOGGING_REQUEST_FROM + request.getRemoteAddr()
								+ AFCSConstants.LOGGING_USER_ADDRESS
								+ request.getHeader(AFCSConstants.USER_IP_ADDRESS)
								+ AFCSConstants.LOGGING_ERROR + errorMessage);

				return afcsApiResponse;

			} else {
				String token=afcsApiRequest.getTokenId();
				if(changePasswordRequest!=null) {
					String userId = changePasswordRequest.getUserId();
					UserEntity userEntity= loginService.getUserProfile(userId);
					if(!userEntity.getToken().equalsIgnoreCase(token)) {
						errormsg+="Invalid Auth Key";
						changePasswordRequest.setErrorMsg(errormsg);
						afcsApiResponse.setPayloadObj(changePasswordRequest);
						afcsApiResponse.setResMessage(errormsg);
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
						return afcsApiResponse;
					}
					
					
				}
				
				if(errormsg.equals("")){
					afcsApiResponse = loginService.changePassword(changePasswordRequest);
				}else{
					changePasswordRequest.setErrorMsg(errormsg);
				}

			}
			log.info("AfcsApiResponse--->> " + changePasswordRequest.toString());
			
		} catch (Exception e) {

			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					AFCSConstants.PACKAGE_FOR_EXCEPTION);

			log.info(this.getClass().getSimpleName(), AFCSConstants.LOGGING_METHOD_NAME
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ AFCSConstants.LOGGING_ERROR_MESSAGE + e + AFCSConstants.LOGGGING_CLASS_NAME
					+ exceptionData[0] + AFCSConstants.LOGGING_FILE_NAME + exceptionData[1]
					+ AFCSConstants.LOGGING_METHOD_NAME + exceptionData[2]
					+ AFCSConstants.LOGGING_LINE_NUMBER + exceptionData[3]);
		}
		return afcsApiResponse;

	}
	
	@PostMapping(path="/forgotPwd",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse forgotPwd(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			ForgetPasswordRequest forgetPasswordRequest = AFCSUtil.jsonStringToObject(payloadObj,
					ForgetPasswordRequest.class);

			
			String errormsg="";
			//String token = request.getHeader("tokenId");
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(forgetPasswordRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				
				afcsApiResponse.setPayloadObj(forgetPasswordRequest);
				afcsApiResponse.setResMessage(errorMessage);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				log.info(this.getClass().getSimpleName(),
						AFCSConstants.LOGGING_RESPONSE + AFCSConstants.LOGGING_METHOD_NAME
								+ Thread.currentThread().getStackTrace()[1].getMethodName()
								+ AFCSConstants.LOGGING_REQUEST_FROM + request.getRemoteAddr()
								+ AFCSConstants.LOGGING_USER_ADDRESS
								+ request.getHeader(AFCSConstants.USER_IP_ADDRESS)
								+ AFCSConstants.LOGGING_ERROR + errorMessage);

				return afcsApiResponse;

			} else {
				//String token=afcsApiRequest.getTokenId();
				String token="";
				if(forgetPasswordRequest!=null) {
					String userId = forgetPasswordRequest.getUserId();
					String mobile = forgetPasswordRequest.getMobile();
					UserEntity userEntity=null;
					if(userId!=null) {
						userEntity = loginService.getUserProfile(userId); // User name must be unique in our system
					}else {
						userEntity = userEntityDAO.findByMobile(mobile);
						}
					
					
					/*if(!userEntity.getToken().equalsIgnoreCase(token)) {
						errormsg+="Invalid Auth Key";
						afcsApiResponse.setPayloadObj(forgetPasswordRequest);
						afcsApiResponse.setResMessage(errormsg);
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
						return afcsApiResponse;
					}else {*/
						//need to send OTP SMS on mobile for verification.
						userEntity.setMobileOtp(AFCSUtil.getRandomNum(6));
						userEntity.setMobileVerificationStatus(null);
						token = AFCSUtil.generateNewToken();
						userEntity.setToken(token);
						userEntity = loginService.updateUser(userEntity);
						
						List<UserEntity> responseList = new ArrayList<UserEntity>();
						UserEntity userEntity2= new UserEntity();
						userEntity2.setMobileOtp(userEntity.getMobileOtp());
						userEntity2.setEmailId(userEntity.getEmailId());
						userEntity2.setToken(userEntity.getToken());
						
						responseList.add(userEntity2);
						afcsApiResponse.setPayloadObj(responseList);
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
						afcsApiResponse.setResMessage("OTP sent to your mobile no.");
						
				}
				
			

			}
			log.info("AfcsApiResponse--->> " + forgetPasswordRequest.toString());
			
		} catch (Exception e) {

			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					AFCSConstants.PACKAGE_FOR_EXCEPTION);

			log.info(this.getClass().getSimpleName(), AFCSConstants.LOGGING_METHOD_NAME
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ AFCSConstants.LOGGING_ERROR_MESSAGE + e + AFCSConstants.LOGGGING_CLASS_NAME
					+ exceptionData[0] + AFCSConstants.LOGGING_FILE_NAME + exceptionData[1]
					+ AFCSConstants.LOGGING_METHOD_NAME + exceptionData[2]
					+ AFCSConstants.LOGGING_LINE_NUMBER + exceptionData[3]);
		}
		return afcsApiResponse;

	} 

	
	/*
	@PostMapping(path="/stopMaster",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse stopMaster(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			StopMasterRequest stopMasterRequest = AFCSUtil.jsonStringToObject(payloadObj,
					StopMasterRequest.class);

			
			String errormsg="";
			//String token = request.getHeader("tokenId");
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(stopMasterRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				stopMasterRequest.setErrorMsg(errorMessage);
				afcsApiResponse.setPayloadObj(stopMasterRequest);
				afcsApiResponse.setResMessage(errorMessage);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				log.info(this.getClass().getSimpleName(),
						AFCSConstants.LOGGING_RESPONSE + AFCSConstants.LOGGING_METHOD_NAME
								+ Thread.currentThread().getStackTrace()[1].getMethodName()
								+ AFCSConstants.LOGGING_REQUEST_FROM + request.getRemoteAddr()
								+ AFCSConstants.LOGGING_USER_ADDRESS
								+ request.getHeader(AFCSConstants.USER_IP_ADDRESS)
								+ AFCSConstants.LOGGING_ERROR + errorMessage);

				return afcsApiResponse;

			} else {
				if(errormsg.equals("")){
					afcsApiResponse = ticketingService.getStopMaster(stopMasterRequest);
				}else{
					stopMasterRequest.setErrorMsg(errormsg);
				}

			}
			log.info("AfcsApiResponse--->> " + stopMasterRequest.toString());
			
		} catch (Exception e) {

			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					AFCSConstants.PACKAGE_FOR_EXCEPTION);

			log.info(this.getClass().getSimpleName(), AFCSConstants.LOGGING_METHOD_NAME
					+ Thread.currentThread().getStackTrace()[1].getMethodName()
					+ AFCSConstants.LOGGING_ERROR_MESSAGE + e + AFCSConstants.LOGGGING_CLASS_NAME
					+ exceptionData[0] + AFCSConstants.LOGGING_FILE_NAME + exceptionData[1]
					+ AFCSConstants.LOGGING_METHOD_NAME + exceptionData[2]
					+ AFCSConstants.LOGGING_LINE_NUMBER + exceptionData[3]);
		}
		return afcsApiResponse;

	}
	*/
	private String getErrorMessage(Set<ConstraintViolation<ValidationBean>> validationError) 
	{
		 Iterator<ConstraintViolation<ValidationBean>>  itr =  validationError.iterator();
		 StringBuilder builder = new StringBuilder();
		 
		 int counter = 1;
		 while(itr.hasNext())
		 {
			 builder.append(counter+". "+itr.next().getMessage()+" ");
			 
			 counter++;
		 }
		 
		return builder.toString();
	}

}
