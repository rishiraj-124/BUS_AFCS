package com.example.busafcs.dao;

import java.util.List;

import com.example.busafcs.entities.BusRoutes;
import com.example.busafcs.entities.BusStops;
import com.example.busafcs.entities.Depot;
import com.example.busafcs.entities.DiscountEntity;
import com.example.busafcs.entities.FareEntity;
import com.example.busafcs.entities.FareRules;
import com.example.busafcs.entities.PassBookingEntity;
import com.example.busafcs.entities.PassEntryExitDetail;
import com.example.busafcs.entities.PassMasterEntity;
import com.example.busafcs.entities.SingleJourneyEntitiy;
import com.example.busafcs.entities.TransactionUploadUser;
import com.example.busafcs.entities.ValueQRTicketEntity;
import com.example.busafcs.entities.ValueTicketEntryExitDetail;

public interface JourneyTicketDAO {

	public SingleJourneyEntitiy saveJourney(SingleJourneyEntitiy singleJourneyEntitiy);
	
	public SingleJourneyEntitiy updateJourney(SingleJourneyEntitiy singleJourneyEntitiy);
	
	public List<SingleJourneyEntitiy> findJourney(String userId);
	
	public SingleJourneyEntitiy getJourney(String tktNum);
	
	public ValueQRTicketEntity saveValueQR(ValueQRTicketEntity valueQRTicketEntity);
	
	public ValueQRTicketEntity getValueTicketQR(String tktSerialNum);
	
	public List<BusStops> getStops(String routeNum);
	
	public List<PassMasterEntity> findAllPassMaster();
	
	public PassBookingEntity savePassBooking(PassBookingEntity passBookingEntity);
	
	public PassEntryExitDetail savePassEntryExit(PassEntryExitDetail passEntryExitDetail);
	
	public ValueTicketEntryExitDetail saveValueTktEntryExit(ValueTicketEntryExitDetail valueTicketEntryExitDetail);
	
	public PassBookingEntity updatePass(PassBookingEntity passBookingEntity);
	
	public PassEntryExitDetail updatePassEntryExit(PassEntryExitDetail passEntryExitDetail);
	
	public ValueTicketEntryExitDetail updateValueTktEntryExit(ValueTicketEntryExitDetail valueTicketEntryExitDetail);
	
	public PassMasterEntity findPass(String passName);
	
	public List<PassEntryExitDetail> findPassEntryExit(String Id);
	
	public List<ValueTicketEntryExitDetail> findValueTktEntryExit(String Id);
	
	public PassBookingEntity getPassbySerialNum(String passSerialNum);
	
	public FareEntity getFare(String srcStpId , String destStpId);
	
	public List<BusStops> getAllStops();
	
	public List<DiscountEntity> getAllDiscounts();
	
	public List<FareEntity> getAllFareRules();
	
	public List<FareRules> getAllFareRulesByDistance();
	
	public SingleJourneyEntitiy getSingleJourney(String qrCode);
	
	public TransactionUploadUser saveTransactions(TransactionUploadUser transactionUploadUser);
	
	public List<BusRoutes> findByDepotNum(String depotNum);
	
	public List<SingleJourneyEntitiy> findJourneybySrcDest(List<Integer> srcStpList , List<Integer> destStpList);
	
	public List<PassBookingEntity> findPassBookingbySrcDest(List<Integer> srcStpList , List<Integer> destStpList);
	
	public List<PassBookingEntity> findPassByUser(String user);
}
