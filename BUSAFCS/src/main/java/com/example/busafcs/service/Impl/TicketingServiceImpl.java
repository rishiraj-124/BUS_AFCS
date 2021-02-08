package com.example.busafcs.service.Impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.busafcs.bean.AfcsApiResponse;
import com.example.busafcs.bean.CustomerRegistrationRequest;
import com.example.busafcs.bean.FareRequest;
import com.example.busafcs.bean.IssueValueQRRequest;
import com.example.busafcs.bean.MasterDataRequest;
import com.example.busafcs.bean.MyTicketRequest;
import com.example.busafcs.bean.MyTripsRequest;
import com.example.busafcs.bean.MyTripsResponse;
import com.example.busafcs.bean.PassFareRequest;
import com.example.busafcs.bean.PassQRRequest;
import com.example.busafcs.bean.PassSerialNumRequest;
import com.example.busafcs.bean.Passenger;
import com.example.busafcs.bean.QRBalanceRequest;
import com.example.busafcs.bean.SingleJourneyRequest;
import com.example.busafcs.bean.StopMasterRequest;
import com.example.busafcs.bean.SubmitTicketRequest;
import com.example.busafcs.bean.TicketDataRequest;
import com.example.busafcs.bean.TicketDataResponse;
import com.example.busafcs.bean.TicketTxnData;
import com.example.busafcs.bean.UploadQRCodeRequest;
import com.example.busafcs.bean.UploadTransactionRequest;
import com.example.busafcs.dao.JourneyTicketDAO;
import com.example.busafcs.dao.UserEntityDAO;
import com.example.busafcs.entities.BusRoutes;
import com.example.busafcs.entities.BusStops;
import com.example.busafcs.entities.Depot;
import com.example.busafcs.entities.DiscountEntity;
import com.example.busafcs.entities.FareEntity;
import com.example.busafcs.entities.FareRules;
import com.example.busafcs.entities.PassBookingEntity;
import com.example.busafcs.entities.PassEntryExitDetail;
import com.example.busafcs.entities.PassMasterEntity;
import com.example.busafcs.entities.PassengerEntity;
import com.example.busafcs.entities.SingleJourneyEntitiy;
import com.example.busafcs.entities.TicketTxnDataEntity;
import com.example.busafcs.entities.TransactionUploadUser;
import com.example.busafcs.entities.UserEntity;
import com.example.busafcs.entities.ValueQRTicketEntity;
import com.example.busafcs.entities.ValueTicketEntryExitDetail;
import com.example.busafcs.service.TicketingService;
import com.example.busafcs.util.AFCSConstants;
import com.example.busafcs.util.AFCSUtil;
import com.example.busafcs.util.ExceptionUtils;

@Service("ticketingService")
@ComponentScan("com.example.afcs")
public class TicketingServiceImpl implements TicketingService {

	private static final Logger log = LoggerFactory.getLogger(TicketingServiceImpl.class);

	@Autowired
	UserEntityDAO userEntityDAO;

	@Autowired
	JourneyTicketDAO journeyTicketDAO;

	@Override
	public AfcsApiResponse submitTicket(SingleJourneyRequest singleJourneyRequest) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {

			log.debug("********submitTicket method starts*********");
			List<SingleJourneyRequest> singleJourneyResponseList = null;

			SingleJourneyEntitiy singleJourneyEntitiy = new SingleJourneyEntitiy();
			singleJourneyEntitiy.setUserId(singleJourneyRequest.getUserId());
			// String tktbkngdt = singleJourneyRequest.getTktBookingdt();
			// Date tktbkngdt = Date.valueOf(singleJourneyRequest.getTktBookingdt());

			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);

			singleJourneyEntitiy.setTktBookingDtTime(new java.sql.Timestamp(date.getTime()));
			singleJourneyEntitiy.setSrcStpId(singleJourneyRequest.getSrcStpId());
			singleJourneyEntitiy.setDestStpId(singleJourneyRequest.getDestStpId());
			singleJourneyEntitiy.setTktNo(Long.valueOf(AFCSUtil.getRandomNum(18)));
			singleJourneyEntitiy.setCustIpAddress(singleJourneyRequest.getCustIpAddress());
			singleJourneyEntitiy.setCustImei(singleJourneyRequest.getCustImei());
			singleJourneyEntitiy.setTktType(singleJourneyRequest.getTktType());
			// singleJourneyEntitiy.setPayMode(singleJourneyRequest.getPayMode());
			// singleJourneyEntitiy.setPaidAmt(singleJourneyRequest.getPaidAmt());
			// singleJourneyEntitiy.setPmtId(singleJourneyRequest.getPmtId());
			singleJourneyEntitiy.setStatus("ACTIVE");
			PassengerEntity passengerEntity;
			List<PassengerEntity> passengerEntities = new ArrayList<PassengerEntity>();
			List<Passenger> psgList = singleJourneyRequest.getPsgList();
			for (Passenger passenger : psgList) {
				passengerEntity = new PassengerEntity(passenger.getPssType(), passenger.getNoOfTkt(),
						passenger.getTktAmount(), passenger.getDiscount(), passenger.getAmtPaid(),
						passenger.getTotalAmt(), singleJourneyEntitiy);
				passengerEntities.add(passengerEntity);
			}
			singleJourneyEntitiy.setPassengers(passengerEntities);
			// singleJourneyEntitiy.setQrTicketHash(AFCSUtil.getAlphaNumericString(60));
			singleJourneyEntitiy = journeyTicketDAO.saveJourney(singleJourneyEntitiy);
			if (singleJourneyEntitiy.getId() != null) {
				List<SubmitTicketRequest> submitTicketRequestList = new ArrayList<SubmitTicketRequest>();
				SubmitTicketRequest submitTicketRequest = new SubmitTicketRequest();
				submitTicketRequest.setSrcStpId(singleJourneyEntitiy.getSrcStpId());
				submitTicketRequest.setDestStpId(singleJourneyEntitiy.getDestStpId());
				submitTicketRequest.setTktSrNo(String.valueOf(singleJourneyEntitiy.getTktNo()));
				submitTicketRequest.setCustIpAddress(singleJourneyEntitiy.getCustIpAddress());
				submitTicketRequest.setCustImei(singleJourneyEntitiy.getCustImei());
				submitTicketRequest.setTktType(singleJourneyEntitiy.getTktType());
				submitTicketRequest.setPsgList(psgList);
				submitTicketRequest.setTktId(String.valueOf(singleJourneyEntitiy.getId()));
				submitTicketRequest.setTktRequestDateTime(singleJourneyEntitiy.getTktBookingDtTime().toString());

				/*
				 * Calendar cal = Calendar.getInstance(); String sTime =
				 * cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(
				 * Calendar.SECOND);
				 * 
				 * submitTicketRequest.setTktRequestTime(sTime);
				 */
				submitTicketRequest.setUserId(singleJourneyRequest.getUserId());

				submitTicketRequestList.add(submitTicketRequest);
				afcsApiResponse.setPayloadObj(submitTicketRequestList);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
				afcsApiResponse.setResMessage("Ticket Serial Number Generated");
			}

		} catch (Exception e) {
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					"com.example.afcs");
			log.debug("Exception occured: " + this.getClass().getSimpleName() + "method name: "
					+ Thread.currentThread().getStackTrace()[1].getMethodName() + "error message: " + e + "class name: "
					+ exceptionData[0] + "file name: " + exceptionData[1] + "log method name: " + exceptionData[2]
					+ "line number: " + exceptionData[3]);
		}

		return afcsApiResponse;

	}

	@Override
	public AfcsApiResponse singleJourneyFare(SingleJourneyRequest singleJourneyRequest) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {

			log.debug("********singleJourneyFare method starts*********");
			List<SingleJourneyRequest> singleJourneyResponseList = null;

			SingleJourneyEntitiy singleJourneyEntitiy = null;
			// new SingleJourneyEntitiy();

			singleJourneyEntitiy = journeyTicketDAO.getJourney(String.valueOf(singleJourneyRequest.getTktNo()));
			singleJourneyEntitiy.setUserId(singleJourneyRequest.getUserId());
			// String tktbkngdt = singleJourneyRequest.getTktBookingdt();

			java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(singleJourneyRequest.getTktBookingDtTime());
			// Date tktbkngdt = Date.valueOf(singleJourneyRequest.getTktBookingdt());
			// java.sql.Timestamp timestamp = new java.sql.Timestamp(tktbkngdt.getTime());
			singleJourneyEntitiy.setTktBookingDtTime(ts2);

			/*
			 * Ticket validity for 2 hours
			 * 
			 */
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(ts2.getTime());
			cal.add(Calendar.HOUR, 2);
			ts2 = new Timestamp(cal.getTime().getTime());
			System.out.println(ts2);

			singleJourneyEntitiy.setValidUpto(ts2);
			singleJourneyEntitiy.setSrcStpId(singleJourneyRequest.getSrcStpId());
			singleJourneyEntitiy.setDestStpId(singleJourneyRequest.getDestStpId());
			singleJourneyEntitiy.setTktNo(singleJourneyRequest.getTktNo());
			singleJourneyEntitiy.setCustIpAddress(singleJourneyRequest.getCustIpAddress());
			singleJourneyEntitiy.setCustImei(singleJourneyRequest.getCustImei());
			singleJourneyEntitiy.setTktType(singleJourneyRequest.getTktType());
			singleJourneyEntitiy.setPayMode(singleJourneyRequest.getPayMode());
			singleJourneyEntitiy.setPaidAmt(singleJourneyRequest.getPaidAmt());
			singleJourneyEntitiy.setPmtId(singleJourneyRequest.getPmtId());
			singleJourneyEntitiy.setStatus("ACTIVE");
			PassengerEntity passengerEntity;
			List<PassengerEntity> passengerEntities = new ArrayList<PassengerEntity>();
			/*
			 * List<Passenger> psgList = singleJourneyRequest.getPsgList(); for (Passenger
			 * passenger : psgList) { passengerEntity = new
			 * PassengerEntity(passenger.getPssType(), passenger.getNoOfTkt(),
			 * passenger.getTktAmount(), passenger.getDiscount(), passenger.getAmtPaid(),
			 * passenger.getTotalAmt(),singleJourneyEntitiy);
			 * passengerEntities.add(passengerEntity); }
			 * singleJourneyEntitiy.setPassengers(passengerEntities);
			 */
			singleJourneyEntitiy.setQrTicketHash(AFCSUtil.getAlphaNumericString(60));

			singleJourneyEntitiy = journeyTicketDAO.updateJourney(singleJourneyEntitiy);
			if (singleJourneyEntitiy.getId() != null) {
				singleJourneyResponseList = new ArrayList<SingleJourneyRequest>();
				singleJourneyRequest.setTkt_status("Success");
				singleJourneyRequest.setTkt_validity("2hrs");
				singleJourneyRequest.setQrTicketHash(singleJourneyEntitiy.getQrTicketHash());
				singleJourneyRequest.setTktBookingDtTime(singleJourneyEntitiy.getTktBookingDtTime().toString());
				singleJourneyRequest.setTktValidTillTime(singleJourneyEntitiy.getValidUpto().toString());
				singleJourneyResponseList.add(singleJourneyRequest);
				afcsApiResponse.setPayloadObj(singleJourneyResponseList);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
				afcsApiResponse.setResMessage("Success");
			}

		} catch (Exception e) {
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					"com.example.afcs");
			log.debug("Exception occured: " + this.getClass().getSimpleName() + "method name: "
					+ Thread.currentThread().getStackTrace()[1].getMethodName() + "error message: " + e + "class name: "
					+ exceptionData[0] + "file name: " + exceptionData[1] + "log method name: " + exceptionData[2]
					+ "line number: " + exceptionData[3]);
		}

		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse custReg(CustomerRegistrationRequest custRegReq) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		UserEntity userEntity = null;
		List<CustomerRegistrationRequest> customerRegistrationResponseList = null;
		try {
			log.debug("********custReg method starts*********");
			userEntity = userEntityDAO.getUserProfile(custRegReq.getEmail());

			if (userEntity != null) {
				customerRegistrationResponseList = new ArrayList<CustomerRegistrationRequest>();
				afcsApiResponse.setPayloadObj(customerRegistrationResponseList);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				afcsApiResponse.setResMessage("Email_Id already Exist");
				return afcsApiResponse;
			} else {
				userEntity = userEntityDAO.findByMobile(custRegReq.getMobile());
				if (userEntity != null) {
					customerRegistrationResponseList = new ArrayList<CustomerRegistrationRequest>();
					afcsApiResponse.setPayloadObj(customerRegistrationResponseList);
					afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
					afcsApiResponse.setResMessage("Mobile already Exist");
					return afcsApiResponse;
				}
			}

			if (null != custRegReq && null == userEntity) {
				userEntity = new UserEntity();
				userEntity.setFirstName(custRegReq.getFirstName());
				userEntity.setLastName(custRegReq.getLastName());
				userEntity.setFullName(custRegReq.getFirstName() + " " + custRegReq.getLastName());
				userEntity.setAddress1(custRegReq.getAddress1());
				userEntity.setAddress2(custRegReq.getAddress2());
				userEntity.setCity(custRegReq.getCity());
				userEntity.setState(custRegReq.getState());
				userEntity.setPincode(custRegReq.getPincode());
				userEntity.setCountry(custRegReq.getCountry());
				userEntity.setEmailId(custRegReq.getEmail());
				userEntity.setMobile(custRegReq.getMobile());
				userEntity.setUserPassword(custRegReq.getPassword());
				userEntity.setImei(custRegReq.getImei());
				userEntity.setIpAddress(custRegReq.getIpAddress());
				userEntity.setUserRole("Customer");
				userEntity.setMobileOtp(AFCSUtil.getRandomNum(6));
				// userEntity.setToken(generateNewToken());
				userEntity = userEntityDAO.saveUser(userEntity);
				if (userEntity.getId() != null) {
					customerRegistrationResponseList = new ArrayList<CustomerRegistrationRequest>();
					custRegReq.setTokenId(userEntity.getToken());
					custRegReq.setMobileOtp(userEntity.getMobileOtp());
					customerRegistrationResponseList.add(custRegReq);
					afcsApiResponse.setPayloadObj(customerRegistrationResponseList);
					afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
					afcsApiResponse.setResMessage("Successfully Registered and verification Link sent ");

				}
			}

		} catch (Exception e) {
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					"com.example.afcs");
			log.debug("Exception occured: " + this.getClass().getSimpleName() + "method name: "
					+ Thread.currentThread().getStackTrace()[1].getMethodName() + "error message: " + e + "class name: "
					+ exceptionData[0] + "file name: " + exceptionData[1] + "log method name: " + exceptionData[2]
					+ "line number: " + exceptionData[3]);
		}
		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse issueValueQR(IssueValueQRRequest issueValueQRRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		List<IssueValueQRRequest> issueValueQRResponseList = null;
		try {
			if (issueValueQRRequest != null) {
				ValueQRTicketEntity valueQRTicketEntity = new ValueQRTicketEntity();
				valueQRTicketEntity.setAmount(issueValueQRRequest.getAmount());
				valueQRTicketEntity.setPaymentMode(issueValueQRRequest.getPaymentMode());
				valueQRTicketEntity.setImei(issueValueQRRequest.getImei());
				valueQRTicketEntity.setFullTicketNo(AFCSUtil.getRandomNum(20));
				valueQRTicketEntity.setQrTicketHash(AFCSUtil.getAlphaNumericString(60));
				// need to call third party api for payment gateway status
				valueQRTicketEntity.setPaymentStatus("Success");
				java.util.Date date= new java.util.Date();
				long time = date.getTime();
				Timestamp ts = new Timestamp(time);
			    valueQRTicketEntity.setIssueDateTime(ts);
			    valueQRTicketEntity.setTicketStatus("ACTIVE");
			    valueQRTicketEntity.setRemainingValue(issueValueQRRequest.getAmount());
			    
			    
				valueQRTicketEntity = journeyTicketDAO.saveValueQR(valueQRTicketEntity);
				if (valueQRTicketEntity.getId() != null) {
					issueValueQRResponseList = new ArrayList<IssueValueQRRequest>();
					issueValueQRRequest.setTicketId(String.valueOf(valueQRTicketEntity.getId()));
					issueValueQRRequest.setFullTicketNo(valueQRTicketEntity.getFullTicketNo());
					issueValueQRRequest.setPaymentStatus(valueQRTicketEntity.getPaymentStatus());
					issueValueQRRequest.setTicketStatus("Success");
					issueValueQRRequest.setTicketValidity("");
					issueValueQRRequest.setIssueDateTime(valueQRTicketEntity.getIssueDateTime().toString());
					issueValueQRRequest.setQrTicketHash(valueQRTicketEntity.getQrTicketHash());
					issueValueQRResponseList.add(issueValueQRRequest);
					afcsApiResponse.setPayloadObj(issueValueQRResponseList);
					afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
					afcsApiResponse.setResMessage("Value QR Code generated");

				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse getStopMaster(StopMasterRequest stopMasterRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		List<BusStops> busStopsList = null;

		if ("allStopMaster".equalsIgnoreCase(stopMasterRequest.getMasterData())) {
			busStopsList = journeyTicketDAO.getAllStops();
		}
		afcsApiResponse.setPayloadObj(busStopsList);

		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse getMaster(MasterDataRequest masterDataRequest) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		List<MasterDataRequest> masterDataList = new ArrayList<MasterDataRequest>();
		List<DiscountEntity> discountList = new ArrayList<DiscountEntity>();
		List<FareEntity> flatfareRuleList = new ArrayList<FareEntity>();
		List<FareRules> byDistancefareRuleList = new ArrayList<FareRules>();

		List<BusRoutes> busRouteList = journeyTicketDAO.findByDepotNum(masterDataRequest.getDepot());
		masterDataRequest.setBusType("AC Bus");
		masterDataRequest.setManufacturer("TATA");

		List<PassMasterEntity> passMasterEntities = journeyTicketDAO.findAllPassMaster();
		discountList = journeyTicketDAO.getAllDiscounts();
		flatfareRuleList = journeyTicketDAO.getAllFareRules();
		byDistancefareRuleList = journeyTicketDAO.getAllFareRulesByDistance();

		masterDataRequest.setBusRouteList(busRouteList);

		masterDataRequest.setDiscountList(discountList);
		masterDataRequest.setFareRuleList(flatfareRuleList);
		masterDataRequest.setByDistancefareRuleList(byDistancefareRuleList);

		masterDataRequest.setPassMasterList(passMasterEntities);
		masterDataList.add(masterDataRequest);

		afcsApiResponse.setPayloadObj(masterDataList);
		afcsApiResponse.setResMessage("Driver Conductor Master Data");
		afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);

		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse getPassDetails(PassFareRequest passFareRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();

		List<PassMasterEntity> passMasterEntities = journeyTicketDAO.findAllPassMaster();

		for (PassMasterEntity passMasterEntity : passMasterEntities) {
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String sdate = date.format(formatter);
			passMasterEntity.setDt_Issue(sdate);
			passMasterEntity.setValidFrom(passFareRequest.getSrcStpId());
			passMasterEntity.setValidTo(passFareRequest.getDestStpId());
			passMasterEntity.setPassDetails(passMasterEntity.getTripAllowed() + " Trips Pass");
			passMasterEntity.setPassType(passFareRequest.getPassType());
			passMasterEntity.setPassName(passFareRequest.getPassType());
		}

		afcsApiResponse.setPayloadObj(passMasterEntities);
		afcsApiResponse.setResMessage("Trip Pass Details");
		afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);

		return afcsApiResponse;
	}

	public AfcsApiResponse getPassSerialNumber(PassSerialNumRequest passSerialNumRequest) {
		AfcsApiResponse afcsApiResponse = null;
		try {
			afcsApiResponse = new AfcsApiResponse();

			List<PassSerialNumRequest> passSerialNumRequestList = new ArrayList<PassSerialNumRequest>();

			PassBookingEntity passBookingEntity = new PassBookingEntity();

			passBookingEntity.setCreatedBy(passSerialNumRequest.getUserId());
			passBookingEntity.setDeviceId(passSerialNumRequest.getDeviceId());
			passBookingEntity.setDeviceIp(passSerialNumRequest.getDeviceIp());
			passBookingEntity.setPassType(passSerialNumRequest.getPassType());
			passBookingEntity.setPassDetails(passSerialNumRequest.getPassDetails());

			// LocalDate date = LocalDate.now();
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			// String sdate = date.format(formatter);
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);

			passBookingEntity.setDtIssue(date);

			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, 30);
			passBookingEntity.setValidUpto(new Date(c.getTimeInMillis()));

			String passtype = passSerialNumRequest.getPassType();

			PassMasterEntity passMasterEntity = null;
			try {
				passMasterEntity = journeyTicketDAO.findPass(passtype);
			} catch (Exception e) {

				e.printStackTrace();
			}
			passBookingEntity.setMaxTripAllowed(Integer.parseInt(passMasterEntity.getTripAllowed()));
			passBookingEntity.setRemainingTrip(Integer.parseInt(passMasterEntity.getTripAllowed()));
			passBookingEntity.setPassId(String.valueOf(passMasterEntity.getPassId()));
			passBookingEntity.setPassSerialNum(AFCSUtil.getRandomNum(8));

			java.util.Date date2 = new java.util.Date();
			Timestamp ts = new Timestamp(date2.getTime());

			passBookingEntity.setPassRequestDateTime(ts);
			passBookingEntity.setDuration(passMasterEntity.getPassPeriod());
			passBookingEntity.setDocType(passMasterEntity.getDoc_Type());
			passBookingEntity.setDocRequired(passMasterEntity.getDoc_Reqd());
			passBookingEntity.setDocAttached(null);
			passBookingEntity.setSrcStopId(Integer.parseInt(passSerialNumRequest.getSrcStpId()));
			passBookingEntity.setDestStopId(Integer.parseInt(passSerialNumRequest.getDestStpId()));
			passBookingEntity.setTotAmnt(new BigDecimal(passSerialNumRequest.getTotalAmt()));
			passBookingEntity.setDiscAmnt(new BigDecimal(passSerialNumRequest.getDiscAmt()));
			passBookingEntity.setAmntToPay(new BigDecimal(passSerialNumRequest.getAmtToPay()));

			try {
				passBookingEntity = journeyTicketDAO.savePassBooking(passBookingEntity);
			} catch (Exception e) {

				e.printStackTrace();
			}

			// passSerialNumRequest.setPassRequestTime(sTime);

			if (passBookingEntity.getId() != null) {
				passSerialNumRequest.setDtIssue(passBookingEntity.getDtIssue().toString());
				passSerialNumRequest.setValidUpto(passBookingEntity.getValidUpto().toString());
				passSerialNumRequest.setPassId(passBookingEntity.getPassId());
				passSerialNumRequest.setPassSerialNum(passBookingEntity.getPassSerialNum());
				Timestamp pts = passBookingEntity.getPassRequestDateTime();
				passSerialNumRequest.setPassRequestDate(pts.toString());
				passSerialNumRequest.setDuration(passBookingEntity.getDuration());
				passSerialNumRequestList.add(passSerialNumRequest);
			}
			afcsApiResponse.setPayloadObj(passSerialNumRequestList);
			afcsApiResponse.setResMessage("Pass Ticket Serial Num generated");
			afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return afcsApiResponse;

	}

	@Override
	public AfcsApiResponse getPassQR(PassQRRequest passQRRequest) {

		AfcsApiResponse afcsApiResponse = null;
		try {
			afcsApiResponse = new AfcsApiResponse();

			List<PassQRRequest> passQRRequestList = new ArrayList<PassQRRequest>();

			PassBookingEntity passBookingEntity = null;

			passBookingEntity = journeyTicketDAO.getPassbySerialNum(passQRRequest.getPassSerialNum());

			passBookingEntity.setPassqrCode(AFCSUtil.getAlphaNumericString(60));
			passBookingEntity.setPmntId(Integer.parseInt(passQRRequest.getPmtId()));
			passBookingEntity.setTrsctId(Integer.parseInt(passQRRequest.getTrsctId()));
			passBookingEntity.setAmntToPay(new BigDecimal(passQRRequest.getPaidAmt()));
			passBookingEntity.setStatus("ACTIVE");

			passBookingEntity = journeyTicketDAO.updatePass(passBookingEntity);

			if (passBookingEntity.getId() != null) {
				passQRRequest.setUserId(passBookingEntity.getCreatedBy());
				passQRRequest.setDeviceId(passBookingEntity.getDeviceId());
				passQRRequest.setDeviceIp(passBookingEntity.getDeviceIp());
				passQRRequest.setPassType(passBookingEntity.getPassType());
				passQRRequest.setPassDetails(passBookingEntity.getPassDetails());
				passQRRequest.setDtIssue(passBookingEntity.getDtIssue());
				passQRRequest.setPassRequestDateTime(passBookingEntity.getPassRequestDateTime().toString());
				passQRRequest.setValidUpto(passBookingEntity.getValidUpto().toString());
				passQRRequest.setPassId(passBookingEntity.getPassId());
				passQRRequest.setPassSerialNum(passBookingEntity.getPassSerialNum());
				passQRRequest.setPassQRCode(passBookingEntity.getPassqrCode());
				passQRRequest.setDuration(passBookingEntity.getDuration());
				passQRRequest.setDocType(passBookingEntity.getDocType());
				passQRRequest.setDocRequired(passBookingEntity.getDocRequired());
				passQRRequest.setDocAttached(null);
				passQRRequest.setSrcStpId(String.valueOf(passBookingEntity.getSrcStopId()));
				passQRRequest.setDestStpId(String.valueOf(passBookingEntity.getDestStopId()));
				passQRRequest.setPmtId(String.valueOf(passBookingEntity.getPmntId()));
				passQRRequest.setTrsctId(String.valueOf(passBookingEntity.getTrsctId()));
				passQRRequest.setPaidAmt(passBookingEntity.getAmntToPay().toString());
				passQRRequestList.add(passQRRequest);

				afcsApiResponse.setPayloadObj(passQRRequestList);
				afcsApiResponse.setResMessage("Pass QRCode generated");
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return afcsApiResponse;

	}

	@Override
	public AfcsApiResponse getMyValidTicket(MyTicketRequest myTicketRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();

		List<MyTicketRequest> myTicketsList = new ArrayList<MyTicketRequest>();
		String userEmail = myTicketRequest.getCustomerId();
		MyTicketRequest myTicket = null;
		if ("sjt".equalsIgnoreCase(myTicketRequest.getTicketType())) {
			List<SingleJourneyEntitiy> sjList = journeyTicketDAO.findJourney(userEmail);
			for (SingleJourneyEntitiy singleJourneyEntitiy : sjList) {

				if ("ACTIVE".equalsIgnoreCase(singleJourneyEntitiy.getStatus())) {
					myTicket = new MyTicketRequest();

					java.util.Date udate = singleJourneyEntitiy.getTktBookingDtTime();
					myTicket.setTktBookingdt(udate);
					// myTicket.setTktValiddt(tktValiddt);
					myTicket.setSrcStpId(String.valueOf(singleJourneyEntitiy.getSrcStpId()));
					myTicket.setDestStpId(String.valueOf(singleJourneyEntitiy.getDestStpId()));
					myTicket.setTktNo(String.valueOf(singleJourneyEntitiy.getTktNo()));
					myTicket.setCustIpAddress(singleJourneyEntitiy.getCustIpAddress());
					myTicket.setCustImei(singleJourneyEntitiy.getCustImei());
					myTicket.setTicketType(singleJourneyEntitiy.getTktType());

					// myTicket.setPsgList(singleJourneyEntitiy.getPassengers());

					myTicket.setPayMode(singleJourneyEntitiy.getPayMode());
					myTicket.setPaidAmnt(singleJourneyEntitiy.getPaidAmt());
					myTicket.setPmtId(singleJourneyEntitiy.getPmtId());
					myTicket.setQrTicketHash(singleJourneyEntitiy.getQrTicketHash());
					myTicket.setTktStatus("Success");
					myTicket.setTktValidity("Valid");
					myTicket.setTktId(String.valueOf(singleJourneyEntitiy.getId()));
					myTicket.setPaymentStatus("Success");
					myTicket.setUserId(singleJourneyEntitiy.getUserId());
					myTicketsList.add(myTicket);
				}

			}
		}

		afcsApiResponse.setPayloadObj(myTicketsList);
		afcsApiResponse.setResMessage("My Valid Tickets");
		afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse getMyFare(FareRequest fareRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		List<FareRequest> fareRequestList = new ArrayList<FareRequest>();

		FareEntity fareEntity = journeyTicketDAO.getFare(fareRequest.getSrcStpId(), fareRequest.getDestStpId());
		BigDecimal netAmnt;
		BigDecimal fareAmnt;
		if (fareEntity != null) {
			BigDecimal amnt = BigDecimal.valueOf(fareEntity.getFareAmnt());
			fareAmnt = amnt.multiply(new BigDecimal(Integer.parseInt(fareRequest.getNoOfPax())));

			netAmnt = fareAmnt.subtract(new BigDecimal(fareEntity.getDiscAmnt()));

			fareRequest.setDiscount(String.valueOf(fareEntity.getDiscAmnt()));
			fareRequest.setFareAmount(fareAmnt.toString());
			fareRequest.setNetAmnt(netAmnt.toString());
			fareRequestList.add(fareRequest);
		}

		afcsApiResponse.setPayloadObj(fareRequestList);
		afcsApiResponse.setResMessage("Success");
		afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
		return afcsApiResponse;

	}

	@Override
	public AfcsApiResponse uploadQRTicket(UploadQRCodeRequest uploadQRCodeRequest) {

		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		SingleJourneyEntitiy singleJourneyEntity = null;
		PassBookingEntity passBookingEntity = null;
		ValueQRTicketEntity valueQRTicketEntity = null;

		

			try {
				if (("sjt".equalsIgnoreCase(uploadQRCodeRequest.getTktType()))
						|| ("rjt".equalsIgnoreCase(uploadQRCodeRequest.getTktType()))) {
					singleJourneyEntity = journeyTicketDAO.getJourney(uploadQRCodeRequest.getTktSrNUm());
					if (singleJourneyEntity != null
							&& singleJourneyEntity.getQrTicketHash().equalsIgnoreCase(uploadQRCodeRequest.getQrCode())
							&& "ACTIVE".equalsIgnoreCase(singleJourneyEntity.getStatus())) {
						if (singleJourneyEntity.getEntry() == null) {
							singleJourneyEntity.setEntry("Yes");
							singleJourneyEntity.setQrStatus("Entry Locked");
							java.util.Date date = new java.util.Date();
							Timestamp entryts = new Timestamp(date.getTime());
							singleJourneyEntity.setTktEntryDtTime(entryts);
							
							journeyTicketDAO.updateJourney(singleJourneyEntity);
							afcsApiResponse.setResMessage("Scanned ticket updated on server successfully");
							afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
						} else if ("Yes".equalsIgnoreCase(singleJourneyEntity.getEntry())
								&& singleJourneyEntity.getExit() == null) {
							singleJourneyEntity.setExit("Yes");
							singleJourneyEntity.setQrStatus("Consumed");
							java.util.Date date = new java.util.Date();
							Timestamp exitts = new Timestamp(date.getTime());
							singleJourneyEntity.setTktExitDtTime(exitts);
							singleJourneyEntity.setStatus("INACTIVE");
							
							journeyTicketDAO.updateJourney(singleJourneyEntity);
							afcsApiResponse.setResMessage("Scanned ticket updated on server successfully");
							afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);

						} else {
							afcsApiResponse.setResMessage("Invalid Entry, Please contact Customer Care");
							afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);

						}

					} else {
						// afcsApiResponse.setPayloadObj(new Object());
						afcsApiResponse.setResMessage("Invalid Ticket, Please check with Customer Care ");
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);

					}

				} else if ("pass".equalsIgnoreCase(uploadQRCodeRequest.getTktType())) {

					passBookingEntity = journeyTicketDAO.getPassbySerialNum(uploadQRCodeRequest.getTktSrNUm());
					List<PassEntryExitDetail> passEntryExitDetailList = new ArrayList<PassEntryExitDetail>();
					PassEntryExitDetail entryExitDetail ;
					if (passBookingEntity != null
							&& passBookingEntity.getPassqrCode().equalsIgnoreCase(uploadQRCodeRequest.getQrCode())
							&& "ACTIVE".equalsIgnoreCase(passBookingEntity.getStatus())
							&& !(passBookingEntity.getRemainingTrip() < 1)) {
						if (uploadQRCodeRequest.getScanfor() == 1) {
							if (passBookingEntity.getEntryCount() != null) {
								int i = Integer.parseInt(passBookingEntity.getEntryCount());
								i = ++i;
								passBookingEntity.setEntryCount(String.valueOf(i));
								java.util.Date date = new java.util.Date();
								Timestamp pEntryts = new Timestamp(date.getTime());
								entryExitDetail = new PassEntryExitDetail(pEntryts, null, passBookingEntity.getEntryCount(), String.valueOf(passBookingEntity.getId()));
								java.util.Date date2 = new java.util.Date();
								Timestamp pEntryts2 = new Timestamp(date2.getTime());
								//entryExitDetail = new PassEntryExitDetail(pEntryts2, null, passBookingEntity.getEntryCount(), passBookingEntity);
								
								journeyTicketDAO.savePassEntryExit(entryExitDetail);
							} else {
								passBookingEntity.setEntryCount(String.valueOf(1));
								java.util.Date date = new java.util.Date();
								Timestamp pEntryts = new Timestamp(date.getTime());
								entryExitDetail = new PassEntryExitDetail(pEntryts, null, passBookingEntity.getEntryCount(), String.valueOf(passBookingEntity.getId()));
								journeyTicketDAO.savePassEntryExit(entryExitDetail);
								
							}
						} else if (uploadQRCodeRequest.getScanfor() == 2) {
							if (passBookingEntity.getExitCount() != null) {
								int i = Integer.parseInt(passBookingEntity.getExitCount());
								i = ++i;
								passBookingEntity.setExitCount(String.valueOf(i));
								int j = passBookingEntity.getRemainingTrip();
								passBookingEntity.setRemainingTrip(--j);
								java.util.Date date = new java.util.Date();
								Timestamp pEntryts = new Timestamp(date.getTime());
								passEntryExitDetailList=journeyTicketDAO.findPassEntryExit(String.valueOf(passBookingEntity.getId()));
								//entryExitDetail = new PassEntryExitDetail(pEntryts, null, passBookingEntity.getEntryCount(), passBookingEntity);
								for( PassEntryExitDetail entryExitDetail2:passEntryExitDetailList) {
									if(entryExitDetail2.getTripNum().equalsIgnoreCase(passBookingEntity.getExitCount())) {
										entryExitDetail2.setTripExitDtTime(pEntryts);
										journeyTicketDAO.updatePassEntryExit(entryExitDetail2);
									}
								}
							} else {
								passBookingEntity.setExitCount(String.valueOf(1));
								int i = passBookingEntity.getMaxTripAllowed();
								passBookingEntity.setRemainingTrip(--i);
								java.util.Date date = new java.util.Date();
								Timestamp pEntryts = new Timestamp(date.getTime());
								passEntryExitDetailList=journeyTicketDAO.findPassEntryExit(String.valueOf(passBookingEntity.getId()));
								for( PassEntryExitDetail entryExitDetail2:passEntryExitDetailList) {
									if(entryExitDetail2.getTripNum().equalsIgnoreCase(passBookingEntity.getExitCount())) {
										entryExitDetail2.setTripExitDtTime(pEntryts);
										journeyTicketDAO.updatePassEntryExit(entryExitDetail2);
									}
								}
								
							}
						}
						journeyTicketDAO.updatePass(passBookingEntity);
						afcsApiResponse.setResMessage("Scanned ticket updated on server successfully");
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
					} else {
						// afcsApiResponse.setPayloadObj(new Object());
						afcsApiResponse.setResMessage("Invalid Pass Serial No.");
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
					}

				} else if("ValueTicket".equalsIgnoreCase(uploadQRCodeRequest.getTktType())) {
					
					ValueTicketEntryExitDetail valueTicketEntryExitDetail=null;
					
					List<ValueTicketEntryExitDetail> valueTicketEntryExitDetailList = new ArrayList<ValueTicketEntryExitDetail>(); 
					
					valueQRTicketEntity = journeyTicketDAO.getValueTicketQR(uploadQRCodeRequest.getTktSrNUm());
					if(valueQRTicketEntity != null
							&& valueQRTicketEntity.getQrTicketHash().equalsIgnoreCase(uploadQRCodeRequest.getQrCode())
							&& "ACTIVE".equalsIgnoreCase(valueQRTicketEntity.getTicketStatus())) {
						if(uploadQRCodeRequest.getScanfor() == 1) {
							
							if (valueQRTicketEntity.getEntryCount() != null) {
								int i = Integer.parseInt(valueQRTicketEntity.getEntryCount());
								i = ++i;
								valueQRTicketEntity.setEntryCount(String.valueOf(i));
								java.util.Date date = new java.util.Date();
								Timestamp vEntryts = new Timestamp(date.getTime());
								valueTicketEntryExitDetail = new ValueTicketEntryExitDetail(vEntryts, null, String.valueOf(valueQRTicketEntity.getId()), uploadQRCodeRequest.getStopId(), null, valueQRTicketEntity.getEntryCount());
								journeyTicketDAO.saveValueTktEntryExit(valueTicketEntryExitDetail);
							}else {
								valueQRTicketEntity.setEntryCount(String.valueOf(1));
								java.util.Date date = new java.util.Date();
								Timestamp vEntryts = new Timestamp(date.getTime());
								valueTicketEntryExitDetail = new ValueTicketEntryExitDetail(vEntryts, null, String.valueOf(valueQRTicketEntity.getId()), uploadQRCodeRequest.getStopId(), null, valueQRTicketEntity.getEntryCount());
								journeyTicketDAO.saveValueTktEntryExit(valueTicketEntryExitDetail);
								}
							
								journeyTicketDAO.saveValueQR(valueQRTicketEntity);
								afcsApiResponse.setResMessage("Scanned ticket updated on server successfully");
								afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
							}else if(uploadQRCodeRequest.getScanfor() == 2) {

							if (valueQRTicketEntity.getExitCount() != null) {
								BigDecimal c,d,e = null;
								int i = Integer.parseInt(valueQRTicketEntity.getExitCount());
								i = ++i;
								valueQRTicketEntity.setExitCount(String.valueOf(i));
								valueTicketEntryExitDetailList=journeyTicketDAO.findValueTktEntryExit(String.valueOf(valueQRTicketEntity.getId()));
								for( ValueTicketEntryExitDetail valueTicketEntryExitDetail2:valueTicketEntryExitDetailList) {
									if(valueTicketEntryExitDetail2.getEntryStopId()!=null && valueTicketEntryExitDetail2.getExitStopId()==null) {
									String entryStop = valueTicketEntryExitDetail2.getEntryStopId();
									String exitStop = uploadQRCodeRequest.getStopId();
									FareEntity fareEntity = journeyTicketDAO.getFare(entryStop, exitStop);
									Integer j = fareEntity.getFareAmnt();
									d = new BigDecimal(valueQRTicketEntity.getRemainingValue());
									c = BigDecimal.valueOf(j);
									e = d.subtract(c);
									}
								}
								
								valueQRTicketEntity.setRemainingValue(e.longValue());
								
								
								java.util.Date date = new java.util.Date();
								Timestamp pEntryts = new Timestamp(date.getTime());
								valueTicketEntryExitDetailList=journeyTicketDAO.findValueTktEntryExit(String.valueOf(valueQRTicketEntity.getId()));
								
								for( ValueTicketEntryExitDetail valueTicketEntryExitDetail2:valueTicketEntryExitDetailList) {
									if(valueTicketEntryExitDetail2.getTripNum().equalsIgnoreCase(valueQRTicketEntity.getExitCount())) {
										valueTicketEntryExitDetail2.setExitStopId(uploadQRCodeRequest.getStopId());
										valueTicketEntryExitDetail2.setTripExitDtTime(pEntryts);
										journeyTicketDAO.updateValueTktEntryExit(valueTicketEntryExitDetail2);
									}
								}
								journeyTicketDAO.saveValueQR(valueQRTicketEntity);
								afcsApiResponse.setResMessage("Scanned ticket updated on server successfully");
								afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
							} else {
								BigDecimal c,d,e = null;
								valueQRTicketEntity.setExitCount(String.valueOf(1));
								
								Long i = valueQRTicketEntity.getAmount();
								
								valueTicketEntryExitDetailList=journeyTicketDAO.findValueTktEntryExit(String.valueOf(valueQRTicketEntity.getId()));
								for( ValueTicketEntryExitDetail valueTicketEntryExitDetail2:valueTicketEntryExitDetailList) {
									String entryStop = valueTicketEntryExitDetail2.getEntryStopId();
									String exitStop = uploadQRCodeRequest.getStopId();
									FareEntity fareEntity = journeyTicketDAO.getFare(entryStop, exitStop);
									Integer j = fareEntity.getFareAmnt();
									d = new BigDecimal(i);
									c = BigDecimal.valueOf(j);
									e = d.subtract(c);
									
								}
								
								valueQRTicketEntity.setRemainingValue(e.longValue());
								java.util.Date date = new java.util.Date();
								Timestamp pExitts = new Timestamp(date.getTime());
								valueTicketEntryExitDetailList=journeyTicketDAO.findValueTktEntryExit(String.valueOf(valueQRTicketEntity.getId()));
								for( ValueTicketEntryExitDetail valueTicketEntryExitDetail2:valueTicketEntryExitDetailList) {
									if(valueTicketEntryExitDetail2.getTripNum().equalsIgnoreCase(valueQRTicketEntity.getExitCount())) {
										valueTicketEntryExitDetail2.setTripExitDtTime(pExitts);
										valueTicketEntryExitDetail2.setExitStopId(uploadQRCodeRequest.getStopId());
										journeyTicketDAO.updateValueTktEntryExit(valueTicketEntryExitDetail2);
									}
								}
								journeyTicketDAO.saveValueQR(valueQRTicketEntity);
								afcsApiResponse.setResMessage("Scanned ticket updated on server successfully");
								afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
							}
						
					}		
							
							
					}else {
						afcsApiResponse.setResMessage("Invalid Value Ticket");
						afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
					}	
					
					
				}else {
					afcsApiResponse.setResMessage("Invalid Ticket Type");
					afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
				}
			} catch (Exception e) {
				log.info("Exception occurec in uploadQRTicket - " , e);
				e.printStackTrace();
			}
		
				
	
		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse uploadTxnData(UploadTransactionRequest uploadTransactionRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		try {

			log.debug("********uploadTxnData method starts*********");
			// List<SingleJourneyRequest> singleJourneyResponseList = null;
			TransactionUploadUser transactionUploadUser = new TransactionUploadUser();

			// String tktbkngdt = singleJourneyRequest.getTktBookingdt();
			// Date tktbkngdt = Date.valueOf(singleJourneyRequest.getTktBookingdt());

			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);

			transactionUploadUser.setUserId(uploadTransactionRequest.getUserId());
			transactionUploadUser.setReaderId(uploadTransactionRequest.getReaderId());
			transactionUploadUser.setBusNo(uploadTransactionRequest.getBusNo());
			transactionUploadUser.setTrip(uploadTransactionRequest.getTrip());
			transactionUploadUser.setRoute(uploadTransactionRequest.getRoute());
			transactionUploadUser.setBusServiceType(uploadTransactionRequest.getBusServiceType());

			TicketTxnDataEntity ticketTxnDataEntity;
			List<TicketTxnDataEntity> ticketTxnDataEntities = new ArrayList<TicketTxnDataEntity>();
			List<TicketTxnData> txnDataList = uploadTransactionRequest.getTktTxnList();
			for (TicketTxnData ticketTxnData : txnDataList) {
				ticketTxnDataEntity = new TicketTxnDataEntity(ticketTxnData.getTxnId(),
						ticketTxnData.getTxnStartDateTime(), ticketTxnData.getPayMode(), ticketTxnData.getCustCardId(),
						ticketTxnData.getSrcStop(), ticketTxnData.getDestStop(), ticketTxnData.getTktAmnt(),
						ticketTxnData.getTotAmnt(), ticketTxnData.getTxnAmnt(), transactionUploadUser);
				ticketTxnDataEntities.add(ticketTxnDataEntity);
			}
			transactionUploadUser.setTktTxnList(ticketTxnDataEntities);
			// singleJourneyEntitiy.setQrTicketHash(AFCSUtil.getAlphaNumericString(60));
			transactionUploadUser = journeyTicketDAO.saveTransactions(transactionUploadUser);
			if (transactionUploadUser.getId() != null) {

				// afcsApiResponse.setPayloadObj(submitTicketRequestList);
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
				afcsApiResponse.setResMessage("Transactions uploaded on server successfully");
			}

		} catch (Exception e) {
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(),
					"com.example.afcs");
			log.debug("Exception occured: " + this.getClass().getSimpleName() + "method name: "
					+ Thread.currentThread().getStackTrace()[1].getMethodName() + "error message: " + e + "class name: "
					+ exceptionData[0] + "file name: " + exceptionData[1] + "log method name: " + exceptionData[2]
					+ "line number: " + exceptionData[3]);
		}

		return afcsApiResponse;

	}

	@Override
	public AfcsApiResponse getTicketsData(TicketDataRequest ticketDataRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		List<Integer> stoplist = new ArrayList<Integer>();

		List<BusStops> busStopList = journeyTicketDAO.getStops(ticketDataRequest.getRouteNum());
		for (BusStops stops : busStopList) {
			stoplist.add(stops.getStopId());
		}
		List<TicketDataResponse> tdrList = new ArrayList<TicketDataResponse>();
		TicketDataResponse tdr = null;
		List<SingleJourneyEntitiy> sjtList = journeyTicketDAO.findJourneybySrcDest(stoplist, stoplist);
		List<PassBookingEntity> pbList = journeyTicketDAO.findPassBookingbySrcDest(stoplist, stoplist);

		// journeyTicketDAO

		for (SingleJourneyEntitiy sinEntitiy : sjtList) {
			tdr = new TicketDataResponse();
			tdr.setTktSerialNum(String.valueOf(sinEntitiy.getTktNo()));
			tdr.setQrCode(sinEntitiy.getQrTicketHash());
			tdr.setQrType("Tkt");
			tdr.setTicketType(sinEntitiy.getTktType());
			tdr.setSrcStpCode(String.valueOf(sinEntitiy.getSrcStpId()));
			tdr.setDestStpCode(String.valueOf(sinEntitiy.getDestStpId()));
			tdr.setTktAmnt(sinEntitiy.getPaidAmt());

			tdr.setQrStatus(sinEntitiy.getQrStatus());
			tdr.setTktStatus(sinEntitiy.getStatus());

			if (sinEntitiy.getValidUpto() != null) {
				tdr.setQrValidUpto(sinEntitiy.getValidUpto().toString());
			} else {
				tdr.setQrValidUpto(null);
			}
			tdrList.add(tdr);
		}
		for (PassBookingEntity passBookingEntity : pbList) {
			tdr = new TicketDataResponse();
			tdr.setTktSerialNum(passBookingEntity.getPassSerialNum());
			tdr.setQrCode(passBookingEntity.getPassqrCode());
			tdr.setQrType("Pass");
			tdr.setTicketType(passBookingEntity.getPassType());
			tdr.setSrcStpCode(String.valueOf(passBookingEntity.getSrcStopId()));
			tdr.setDestStpCode(String.valueOf(passBookingEntity.getDestStopId()));
			tdr.setTktAmnt(String.valueOf(passBookingEntity.getAmntToPay()));

			if (passBookingEntity.getRemainingTrip() != null) {
				tdr.setRemainingtrips(String.valueOf(passBookingEntity.getRemainingTrip()));
			} else {
				tdr.setRemainingtrips(null);
			}
			if (passBookingEntity.getRemainingTrip() != null) {
				if (!(passBookingEntity.getRemainingTrip() < 1)) {
					tdr.setQrStatus("Valid");
				} else {
					tdr.setQrStatus("Invalid");
				}
			} else {
				tdr.setQrStatus("Valid");
			}
			tdr.setTktStatus(passBookingEntity.getStatus());
			if (passBookingEntity.getValidUpto() != null) {
				tdr.setQrValidUpto(passBookingEntity.getValidUpto().toString());
			} else {
				tdr.setQrValidUpto(null);
			}
			tdrList.add(tdr);

		}
		afcsApiResponse.setPayloadObj(tdrList);
		afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
		afcsApiResponse.setResMessage("Tickets Status Data");

		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse getMyTrips(MyTripsRequest myTripsRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		UserEntity userEntity = null;
		List<SingleJourneyEntitiy> singleJourneyList = null;
		List<PassBookingEntity> passbookingList=null;
		List<PassEntryExitDetail> passEntryExitDetails = null;
		
		userEntity = userEntityDAO.findByMobile(myTripsRequest.getMobileNum());
		singleJourneyList = journeyTicketDAO.findJourney(userEntity.getEmailId());
		passbookingList	=journeyTicketDAO.findPassByUser(userEntity.getEmailId());
		List<MyTripsResponse> myTripsResponses = new ArrayList<MyTripsResponse>();

		MyTripsResponse myTripsResponse = null;

		if ("0".equalsIgnoreCase(myTripsRequest.getTripType())) {
			for (SingleJourneyEntitiy singleJourneyEntitiy : singleJourneyList) {
				myTripsResponse = new MyTripsResponse();
				myTripsResponse.setId(String.valueOf(singleJourneyEntitiy.getId()));
				myTripsResponse.setTicketNum(String.valueOf(singleJourneyEntitiy.getTktNo()));
				if(singleJourneyEntitiy.getTktEntryDtTime()!=null) {
					myTripsResponse.setTripStartDtTime(singleJourneyEntitiy.getTktEntryDtTime().toString());
				}else {
					myTripsResponse.setTripStartDtTime(null);
				}
				if(singleJourneyEntitiy.getTktExitDtTime()!=null) {
					
					myTripsResponse.setTripEndDtTime(singleJourneyEntitiy.getTktExitDtTime().toString());
				}else {
					myTripsResponse.setTripEndDtTime(null);
				}
				
				myTripsResponse.setSrcStpCode(String.valueOf(singleJourneyEntitiy.getSrcStpId()));
				myTripsResponse.setDestStpCode(String.valueOf(singleJourneyEntitiy.getDestStpId()));
				myTripsResponse.setTripStatus(singleJourneyEntitiy.getStatus());
				myTripsResponses.add(myTripsResponse);

			}
			for(PassBookingEntity passBookingEntity :passbookingList) {
				myTripsResponse = new MyTripsResponse();
				myTripsResponse.setId(String.valueOf(passBookingEntity.getId()));
				myTripsResponse.setTicketNum(passBookingEntity.getPassSerialNum());
				myTripsResponse.setSrcStpCode(String.valueOf(passBookingEntity.getSrcStopId()));
				myTripsResponse.setDestStpCode(String.valueOf(passBookingEntity.getDestStopId()));
				passEntryExitDetails = journeyTicketDAO.findPassEntryExit(String.valueOf(passBookingEntity.getId()));
				if(passEntryExitDetails!=null && !passEntryExitDetails.isEmpty()) {
					myTripsResponse.setPassEntryExitList(passEntryExitDetails);
				}	
				myTripsResponse.setTripStatus(passBookingEntity.getStatus());
				myTripsResponses.add(myTripsResponse);
			}
			
		}else if("1".equalsIgnoreCase(myTripsRequest.getTripType())) {
			for (SingleJourneyEntitiy singleJourneyEntitiy : singleJourneyList) {
				if ((singleJourneyEntitiy.getEntry()==null && singleJourneyEntitiy.getExit()==null)
					&& "ACTIVE".equalsIgnoreCase(singleJourneyEntitiy.getStatus()) ) {
					myTripsResponse = new MyTripsResponse();
					myTripsResponse.setId(String.valueOf(singleJourneyEntitiy.getId()));
					myTripsResponse.setTicketNum(String.valueOf(singleJourneyEntitiy.getTktNo()));
					if (singleJourneyEntitiy.getTktEntryDtTime() != null) {
						myTripsResponse.setTripStartDtTime(singleJourneyEntitiy.getTktEntryDtTime().toString());
					} else {
						myTripsResponse.setTripStartDtTime(null);
					}
					if (singleJourneyEntitiy.getTktExitDtTime() != null) {

						myTripsResponse.setTripEndDtTime(singleJourneyEntitiy.getTktExitDtTime().toString());
					} else {
						myTripsResponse.setTripEndDtTime(null);
					}
					myTripsResponse.setSrcStpCode(String.valueOf(singleJourneyEntitiy.getSrcStpId()));
					myTripsResponse.setDestStpCode(String.valueOf(singleJourneyEntitiy.getDestStpId()));
					myTripsResponse.setTripStatus(singleJourneyEntitiy.getStatus());
					myTripsResponses.add(myTripsResponse);
				}

			}
			for(PassBookingEntity passBookingEntity :passbookingList) {
				if (passBookingEntity.getMaxTripAllowed()==passBookingEntity.getRemainingTrip()) {
					myTripsResponse = new MyTripsResponse();
					myTripsResponse.setId(String.valueOf(passBookingEntity.getId()));
					myTripsResponse.setTicketNum(passBookingEntity.getPassSerialNum());
					myTripsResponse.setSrcStpCode(String.valueOf(passBookingEntity.getSrcStopId()));
					myTripsResponse.setDestStpCode(String.valueOf(passBookingEntity.getDestStopId()));
					passEntryExitDetails = journeyTicketDAO
							.findPassEntryExit(String.valueOf(passBookingEntity.getId()));
					if (passEntryExitDetails != null && !passEntryExitDetails.isEmpty()) {
						myTripsResponse.setPassEntryExitList(passEntryExitDetails);
					}
					myTripsResponse.setTripStatus(passBookingEntity.getStatus());
					myTripsResponses.add(myTripsResponse);
				}
			}

		}else if("2".equalsIgnoreCase(myTripsRequest.getTripType())) {

			for (SingleJourneyEntitiy singleJourneyEntitiy : singleJourneyList) {
				if ((singleJourneyEntitiy.getEntry()!=null && singleJourneyEntitiy.getExit()!=null)
					&& "INACTIVE".equalsIgnoreCase(singleJourneyEntitiy.getStatus()) ) {
					myTripsResponse = new MyTripsResponse();
					myTripsResponse.setId(String.valueOf(singleJourneyEntitiy.getId()));
					myTripsResponse.setTicketNum(String.valueOf(singleJourneyEntitiy.getTktNo()));
					if (singleJourneyEntitiy.getTktEntryDtTime() != null) {
						myTripsResponse.setTripStartDtTime(singleJourneyEntitiy.getTktEntryDtTime().toString());
					} else {
						myTripsResponse.setTripStartDtTime(null);
					}
					if (singleJourneyEntitiy.getTktExitDtTime() != null) {

						myTripsResponse.setTripEndDtTime(singleJourneyEntitiy.getTktExitDtTime().toString());
					} else {
						myTripsResponse.setTripEndDtTime(null);
					}
					myTripsResponse.setSrcStpCode(String.valueOf(singleJourneyEntitiy.getSrcStpId()));
					myTripsResponse.setDestStpCode(String.valueOf(singleJourneyEntitiy.getDestStpId()));
					myTripsResponse.setTripStatus(singleJourneyEntitiy.getStatus());
					myTripsResponses.add(myTripsResponse);
				}

			}
			for(PassBookingEntity passBookingEntity :passbookingList) {
				if (!(passBookingEntity.getMaxTripAllowed()==passBookingEntity.getRemainingTrip())) {
					myTripsResponse = new MyTripsResponse();
					myTripsResponse.setId(String.valueOf(passBookingEntity.getId()));
					myTripsResponse.setTicketNum(passBookingEntity.getPassSerialNum());
					myTripsResponse.setSrcStpCode(String.valueOf(passBookingEntity.getSrcStopId()));
					myTripsResponse.setDestStpCode(String.valueOf(passBookingEntity.getDestStopId()));
					passEntryExitDetails = journeyTicketDAO
							.findPassEntryExit(String.valueOf(passBookingEntity.getId()));
					if (passEntryExitDetails != null && !passEntryExitDetails.isEmpty()) {
						myTripsResponse.setPassEntryExitList(passEntryExitDetails);
					}
					myTripsResponse.setTripStatus(passBookingEntity.getStatus());
					myTripsResponses.add(myTripsResponse);
				}
			}

		
		}
		
				afcsApiResponse.setPayloadObj(myTripsResponses);
				afcsApiResponse.setResMessage("Success");
				afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
		
		
		return afcsApiResponse;
	}

	@Override
	public AfcsApiResponse getQRValance(QRBalanceRequest qrBalanceRequest) {
		AfcsApiResponse afcsApiResponse = new AfcsApiResponse();
		ValueQRTicketEntity valueQRTicketEntity = journeyTicketDAO.getValueTicketQR(qrBalanceRequest.getTktSerialNum());
		if(valueQRTicketEntity != null
				&& valueQRTicketEntity.getQrTicketHash().equalsIgnoreCase(qrBalanceRequest.getQrHashCode())
				&& "ACTIVE".equalsIgnoreCase(valueQRTicketEntity.getTicketStatus())) {
			
			qrBalanceRequest.setQrBalance(String.valueOf(valueQRTicketEntity.getRemainingValue()));
			qrBalanceRequest.setQrStatus(valueQRTicketEntity.getTicketStatus());
			
		}else {
			afcsApiResponse.setResMessage("Invalid Ticket");
			afcsApiResponse.setResSatus(AFCSConstants.REQUEST_FAILED);
		}
		
		afcsApiResponse.setPayloadObj(qrBalanceRequest);
		afcsApiResponse.setResMessage("Your current balance is "+ valueQRTicketEntity.getRemainingValue());
		afcsApiResponse.setResSatus(AFCSConstants.REQUEST_PROCESSED_SUCCESSFULLY);
		
		return afcsApiResponse;
	}

}
