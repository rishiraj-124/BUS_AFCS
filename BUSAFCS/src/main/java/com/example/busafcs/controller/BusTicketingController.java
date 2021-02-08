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

import com.example.busafcs.bean.PassQRRequest;
import com.example.busafcs.bean.AfcsApiRequest;
import com.example.busafcs.bean.AfcsApiResponse;
import com.example.busafcs.bean.ChangePasswordRequest;
import com.example.busafcs.bean.CustomerRegistrationRequest;
import com.example.busafcs.bean.FareRequest;
import com.example.busafcs.bean.ForgetPasswordRequest;
import com.example.busafcs.bean.IssueValueQRRequest;
import com.example.busafcs.bean.LoginRequest;
import com.example.busafcs.bean.MasterDataRequest;
import com.example.busafcs.bean.MobileVerificationRequest;
import com.example.busafcs.bean.MyTicketRequest;
import com.example.busafcs.bean.MyTripsRequest;
import com.example.busafcs.bean.PassFareRequest;
import com.example.busafcs.bean.PassSerialNumRequest;
import com.example.busafcs.bean.QRBalanceRequest;
import com.example.busafcs.bean.SingleJourneyRequest;
import com.example.busafcs.bean.StopMasterRequest;
import com.example.busafcs.bean.TicketDataRequest;
import com.example.busafcs.bean.UploadQRCodeRequest;
import com.example.busafcs.bean.UploadTransactionRequest;
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
@RequestMapping("/busticketing")
@ComponentScan({"com.example.busafcs.bean","com.example.busafcs.service"})
public class BusTicketingController {
	
	private static final Logger log = LoggerFactory.getLogger(BusTicketingController.class);
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	TicketingService ticketingService;
	
	@Autowired
	UserEntityDAO userEntityDAO;
	
	 
	@Autowired
	private JWTTokengenerator jwtTokengenerator;
	
	@PostMapping(path="/submitTicketInfo",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse submitTicketInfo(@RequestBody AfcsApiRequest afcsApiRequest , HttpServletRequest request) {
		
		
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			String errormsg="";
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			Object payloadObj = afcsApiRequest.getPayloadObj();
			SingleJourneyRequest singleJourneyRequest = AFCSUtil.jsonStringToObject(payloadObj,
					SingleJourneyRequest.class);
		
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(singleJourneyRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setResMessage(errorMessage);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				//singleJourneyRequest.setErrorMsg(errorMessage);
				log.info(this.getClass().getSimpleName(),
						AFCSConstants.LOGGING_RESPONSE + AFCSConstants.LOGGING_METHOD_NAME
								+ Thread.currentThread().getStackTrace()[1].getMethodName()
								+ AFCSConstants.LOGGING_REQUEST_FROM + request.getRemoteAddr()
								+ AFCSConstants.LOGGING_USER_ADDRESS
								+ request.getHeader(AFCSConstants.USER_IP_ADDRESS)
								+ AFCSConstants.LOGGING_ERROR + errorMessage);

				return afcsApiResponse;

			} else {

				if (errormsg.equals("")) {
					afcsApiResponse = ticketingService.submitTicket(singleJourneyRequest);
				}

			}
			log.info("SubmitTicketInfo--->> " + singleJourneyRequest.toString());
			
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
	
	
	@PostMapping(path="/qrSJTicket",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse singleJourney(@RequestBody AfcsApiRequest afcsApiRequest , HttpServletRequest request) {
		
		
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			String errormsg="";
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			Object payloadObj = afcsApiRequest.getPayloadObj();
			SingleJourneyRequest singleJourneyRequest = AFCSUtil.jsonStringToObject(payloadObj,
					SingleJourneyRequest.class);
		
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(singleJourneyRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setResMessage(errorMessage);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				//singleJourneyRequest.setErrorMsg(errorMessage);
				log.info(this.getClass().getSimpleName(),
						AFCSConstants.LOGGING_RESPONSE + AFCSConstants.LOGGING_METHOD_NAME
								+ Thread.currentThread().getStackTrace()[1].getMethodName()
								+ AFCSConstants.LOGGING_REQUEST_FROM + request.getRemoteAddr()
								+ AFCSConstants.LOGGING_USER_ADDRESS
								+ request.getHeader(AFCSConstants.USER_IP_ADDRESS)
								+ AFCSConstants.LOGGING_ERROR + errorMessage);

				return afcsApiResponse;

			} else {
				if (errormsg.equals("")) {
					afcsApiResponse = ticketingService.singleJourneyFare(singleJourneyRequest);
				}

			}
			log.info("SingleJourney--->> " + singleJourneyRequest.toString());
			
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

	}*/

	@PostMapping(path="/issueValueQR",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse issueValueQR(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			IssueValueQRRequest issueValueQRRequest = AFCSUtil.jsonStringToObject(payloadObj,
					IssueValueQRRequest.class);

			
			String errormsg="";
			//String token = request.getHeader("tokenId");
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(issueValueQRRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				issueValueQRRequest.setErrorMsg(errorMessage);
				afcsApiResponse.setPayloadObj(issueValueQRRequest);
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
				/*
				 * if(changePasswordRequest!=null) { String userId =
				 * changePasswordRequest.getUserId(); UserEntity userEntity=
				 * loginService.getUserProfile(userId);
				 * if(!userEntity.getToken().equalsIgnoreCase(token)) {
				 * errormsg+="Invalid Auth Key"; changePasswordRequest.setErrorMsg(errormsg);
				 * afcsApiResponse.setPayloadObj(changePasswordRequest);
				 * afcsApiResponse.setResMessage(errormsg);
				 * afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED); return
				 * afcsApiResponse; }
				 * 
				 * 
				 * }
				 */
				
				if(errormsg.equals("")){
					afcsApiResponse = ticketingService.issueValueQR(issueValueQRRequest);
				}else{
					issueValueQRRequest.setErrorMsg(errormsg);
				}

			}
			log.info("AfcsApiResponse--->> " + issueValueQRRequest.toString());
			
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
	*/
	
	/*
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
					
					
					//if(!userEntity.getToken().equalsIgnoreCase(token)) {
					//	errormsg+="Invalid Auth Key";
					//	afcsApiResponse.setPayloadObj(forgetPasswordRequest);
					//	afcsApiResponse.setResMessage(errormsg);
					//	afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
					//	return afcsApiResponse;
					//}else {
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
	
	*/
	
	
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
	
	@PostMapping(path="/passFare",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse passFare(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			PassFareRequest passFareRequest =  AFCSUtil.jsonStringToObject(payloadObj,
					PassFareRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(passFareRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(passFareRequest);
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

				if (passFareRequest != null) {
					
						afcsApiResponse = ticketingService.getPassDetails(passFareRequest);
					
				}				

			}
			log.info("AfcsApiResponse--->> " + passFareRequest.toString());
			
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
	
	@PostMapping(path="/passSerialNum",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse passSerialNum(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			PassSerialNumRequest passSerialNumRequest =  AFCSUtil.jsonStringToObject(payloadObj,
					PassSerialNumRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(passSerialNumRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(passSerialNumRequest);
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

				
						afcsApiResponse = ticketingService.getPassSerialNumber(passSerialNumRequest);
				
			}				

			
			log.info("AfcsApiResponse--->> " + passSerialNumRequest.toString());
			
		}catch(Exception e) {

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
	
	@PostMapping(path="/passQR",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse passQR(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			PassQRRequest passQRRequest =  AFCSUtil.jsonStringToObject(payloadObj,
					PassQRRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(passQRRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(passQRRequest);
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

				
						afcsApiResponse = ticketingService.getPassQR(passQRRequest);
				
			}				

			
			log.info("AfcsApiResponse--->> " + passQRRequest.toString());
			
		}catch(Exception e) {

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
	
	@PostMapping(path="/myProfile",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse myProfile(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
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
				String errormsg="";
				String token = afcsApiRequest.getTokenId();

				if (customerRegistrationRequest != null) {
					UserEntity userEntity = loginService.getUserProfile(customerRegistrationRequest.getEmail());
						userEntity.setFirstName(customerRegistrationRequest.getFirstName());
						userEntity.setLastName(customerRegistrationRequest.getLastName());
						userEntity.setEmailId(customerRegistrationRequest.getEmail());
						userEntity.setAddress1(customerRegistrationRequest.getAddress1());
						userEntity.setAddress2(customerRegistrationRequest.getAddress2());
						userEntity.setCity(customerRegistrationRequest.getCity());
						userEntity.setState(customerRegistrationRequest.getState());
						userEntity.setPincode(customerRegistrationRequest.getPincode());
						userEntity.setImei(customerRegistrationRequest.getImei());
						userEntity.setIpAddress(customerRegistrationRequest.getIpAddress());
						userEntity.setMobile(customerRegistrationRequest.getMobile());
						userEntity = loginService.updateUser(userEntity);
						if(userEntity.getId()!=null) {
							afcsApiResponse.setPayloadObj(null);
							afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
							afcsApiResponse.setResMessage("User updated Successfully");
						}
					
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
	
	@PostMapping(path="/myTicket",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse myTicket(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			MyTicketRequest myTicketRequest =  AFCSUtil.jsonStringToObject(payloadObj,
					MyTicketRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(myTicketRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(myTicketRequest);
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

				if (myTicketRequest != null) {
					/*UserEntity userEntity = ticketingService.getUserByToken(token);
					if (userEntity==null || !userEntity.getToken().equalsIgnoreCase(token)) {
						errormsg += "Invalid Auth Key";
						afcsApiResponse.setResMessage(errormsg);
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
						return afcsApiResponse;
					}else {*/
						afcsApiResponse = ticketingService.getMyValidTicket(myTicketRequest);
					
				}				

			}
			log.info("AfcsApiResponse--->> " + myTicketRequest.toString());
			
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
	
	@PostMapping(path="/getFare",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse getFare(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			FareRequest fareRequest =  AFCSUtil.jsonStringToObject(payloadObj, FareRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(fareRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(fareRequest);
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

				if (fareRequest != null) {
					/*UserEntity userEntity = ticketingService.getUserByToken(token);
					if (userEntity==null || !userEntity.getToken().equalsIgnoreCase(token)) {
						errormsg += "Invalid Auth Key";
						afcsApiResponse.setResMessage(errormsg);
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
						return afcsApiResponse;
					}else {*/
						afcsApiResponse = ticketingService.getMyFare(fareRequest);
					
				}				

			}
			log.info("AfcsApiResponse--->> " + fareRequest.toString());
			
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
	
	@PostMapping(path="/getMaster",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse getMaster(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			MasterDataRequest masterDataRequest = AFCSUtil.jsonStringToObject(payloadObj,
					MasterDataRequest.class);

			
			String errormsg="";
			//String token = request.getHeader("tokenId");
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(masterDataRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				masterDataRequest.setErrorMsg(errorMessage);
				afcsApiResponse.setPayloadObj(masterDataRequest);
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
					afcsApiResponse = ticketingService.getMaster(masterDataRequest);
				}else{
					masterDataRequest.setErrorMsg(errormsg);
				}

			}
			log.info("AfcsApiResponse--->> " + masterDataRequest.toString());
			
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
	
	@PostMapping(path="/uploadScannedQR",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse uploadScannedQR(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			UploadQRCodeRequest uploadQRCodeRequest =  AFCSUtil.jsonStringToObject(payloadObj, UploadQRCodeRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(uploadQRCodeRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(uploadQRCodeRequest);
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

				if (uploadQRCodeRequest != null) {
					
						afcsApiResponse = ticketingService.uploadQRTicket(uploadQRCodeRequest);
					
				}				

			}
			log.info("AfcsApiResponse--->> " + uploadQRCodeRequest.toString());
			
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

	
	@PostMapping(path="/uploadTransactions",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse uploadTransactions(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			UploadTransactionRequest uploadTransactionRequest =  AFCSUtil.jsonStringToObject(payloadObj, UploadTransactionRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(uploadTransactionRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(uploadTransactionRequest);
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

				if (uploadTransactionRequest != null) {
					
						afcsApiResponse = ticketingService.uploadTxnData(uploadTransactionRequest);
					
				}				

			}
			log.info("AfcsApiResponse--->> " + uploadTransactionRequest.toString());
			
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
	
	@PostMapping(path="/ticketDataValidation",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse ticketDataValidation(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			TicketDataRequest ticketDataRequest =  AFCSUtil.jsonStringToObject(payloadObj, TicketDataRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(ticketDataRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(ticketDataRequest);
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

				if (ticketDataRequest != null) {
					
						afcsApiResponse = ticketingService.getTicketsData(ticketDataRequest);
					
				}				

			}
			log.info("AfcsApiResponse--->> " + ticketDataRequest.toString());
			
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
	
	@PostMapping(path="/myTrips",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse myTrips(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			MyTripsRequest myTripsRequest =  AFCSUtil.jsonStringToObject(payloadObj, MyTripsRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(myTripsRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(myTripsRequest);
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

				if (myTripsRequest != null) {
					
						afcsApiResponse = ticketingService.getMyTrips(myTripsRequest);
					
				}				

			}
			log.info("AfcsApiResponse--->> " + myTripsRequest.toString());
			
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
	
	
	@PostMapping(path="/qrBalance",consumes="application/json",produces="application/json")
	@ResponseBody
	public AfcsApiResponse qrBalance(@RequestBody AfcsApiRequest afcsApiRequest, HttpServletRequest request) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {
			log.info("AfcsApiRequest--->> " + afcsApiRequest.toString());
			//String channelId = request.getHeader("channelId");
			
			Object payloadObj = afcsApiRequest.getPayloadObj();

			QRBalanceRequest qrBalanceRequest =  AFCSUtil.jsonStringToObject(payloadObj, QRBalanceRequest.class);

			
			String errormsg="";
			
			
			System.out.println();
			//System.out.println(applicationPropertyReader.getEncodingList()+"----------------------"+applicationPropertyReader.getHostList());
			Set<ConstraintViolation<ValidationBean>> validationError = KeyEncryptionUtils.validateBean(qrBalanceRequest);

			if (validationError != null && !validationError.isEmpty()) {

				String errorMessage = getErrorMessage(validationError);
				afcsApiResponse.setPayloadObj(qrBalanceRequest);
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

				if (qrBalanceRequest != null) {
					
						afcsApiResponse = ticketingService.getQRValance(qrBalanceRequest);
					
				}				

			}
			log.info("AfcsApiResponse--->> " + qrBalanceRequest.toString());
			
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
