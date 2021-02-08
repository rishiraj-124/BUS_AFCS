package com.example.busafcs.daoImpl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.busafcs.dao.JourneyTicketDAO;
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
import com.example.busafcs.util.ExceptionUtils;


@Transactional
@Repository
public class JourneyTicketDAOImpl implements JourneyTicketDAO{

private static final Logger log = LoggerFactory.getLogger(JourneyTicketDAOImpl.class);
	
	@PersistenceContext
	protected transient EntityManager entityManager;
	
	
	public SingleJourneyEntitiy saveJourney(SingleJourneyEntitiy singleJourneyEntitiy) {
		
		log.debug("******************** saveJourney() starts executing *****************");
		try{
			entityManager.persist(singleJourneyEntitiy);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.afcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return singleJourneyEntitiy;
		
		
	}
	
	public PassEntryExitDetail savePassEntryExit(PassEntryExitDetail passEntryExitDetail) {
		log.debug("******************** savePassEntryExit() starts executing *****************");
		try{
			entityManager.persist(passEntryExitDetail);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.busafcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return passEntryExitDetail;
	}
	
	@Override
	public SingleJourneyEntitiy updateJourney(SingleJourneyEntitiy singleJourneyEntitiy) {

		log.debug("******************** updateJourney() starts executing *****************");
		try{
			entityManager.merge(singleJourneyEntitiy);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.busafcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return singleJourneyEntitiy;
	}
	
	public PassEntryExitDetail updatePassEntryExit(PassEntryExitDetail passEntryExitDetail) {
		log.debug("******************** updatePassEntryExit() starts executing *****************");
		try{
			entityManager.merge(passEntryExitDetail);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.busafcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return passEntryExitDetail;
	}
	
	
	
	public PassBookingEntity updatePass(PassBookingEntity passBookingEntity) {
		log.debug("******************** updatePass() starts executing *****************");
		try{
			entityManager.merge(passBookingEntity);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.busafcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return passBookingEntity;
	}

	
	
	@Override
	public ValueQRTicketEntity saveValueQR(ValueQRTicketEntity valueQRTicketEntity) {
		log.debug("******************** saveValueQR() starts executing *****************");
		try{
			entityManager.persist(valueQRTicketEntity);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.afcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return valueQRTicketEntity;
	}


	@Override
	public List<BusStops> getStops(String routeNum) {

		List<BusStops> busStopsList=null;
		try {
			TypedQuery<BusStops> query = entityManager.createNamedQuery("BusStops.findByRouteNum",	BusStops.class);
			query.setParameter("routeNum", routeNum);
			busStopsList = query.getResultList();
		} catch (RuntimeException ex) {
			return busStopsList;
		}

		return busStopsList;
	}

	@Override
	public List<PassEntryExitDetail> findPassEntryExit(String Id) {

		List<PassEntryExitDetail> passEntryExitDetail=null;
		try {
			TypedQuery<PassEntryExitDetail> query = entityManager.createNamedQuery("PassEntryExitDetail.findByPassId",	PassEntryExitDetail.class);
			query.setParameter("passbId", Id);
			passEntryExitDetail = query.getResultList();
		} catch (RuntimeException ex) {
			return passEntryExitDetail;
		}

		return passEntryExitDetail;
	}
	
	
	@Override
	public List<BusRoutes> findByDepotNum(String depotNum) {
		List<BusRoutes> busRouteList=null;
		try {
			TypedQuery<BusRoutes> query = entityManager.createNamedQuery("BusRoutes.findByDepotNum",	BusRoutes.class);
			query.setParameter("depotNum", depotNum);
			busRouteList = query.getResultList();
		} catch (RuntimeException ex) {
			return busRouteList;
		}

		return busRouteList;
	}
	
	public List<BusStops> getAllStops()
	{
		return entityManager.createQuery("SELECT s FROM BusStops s", BusStops.class).getResultList();
	}
	
	public List<DiscountEntity> getAllDiscounts()
	{
		return entityManager.createQuery("SELECT d FROM DiscountEntity d", DiscountEntity.class).getResultList();
	}
	
	public List<FareEntity> getAllFareRules()
	{
		return entityManager.createQuery("SELECT f FROM FareEntity f", FareEntity.class).getResultList();
	}
	
	public List<FareRules> getAllFareRulesByDistance(){
		return entityManager.createQuery("SELECT f FROM FareRules f", FareRules.class).getResultList();
	}
	
	@Override
	public PassMasterEntity findPass(String passName) {

		PassMasterEntity passMasterEntity=null;
		try {
			TypedQuery<PassMasterEntity> query = entityManager.createNamedQuery("PassMasterEntity.findByPassName",	PassMasterEntity.class);
			query.setParameter("passName", passName);
			passMasterEntity = query.getSingleResult();
		} catch (RuntimeException ex) {
			return passMasterEntity;
		}

		return passMasterEntity;
	}


	@Override
	public SingleJourneyEntitiy getJourney(String tktNum) {
		SingleJourneyEntitiy singleJourneyEntitiy=null;
		try {
			TypedQuery<SingleJourneyEntitiy> query = entityManager.createNamedQuery("SingleJourneyEntitiy.findByTicketSrNum",	SingleJourneyEntitiy.class);
			query.setParameter("tktNo", Long.valueOf(tktNum));
			singleJourneyEntitiy = query.getSingleResult();
		} catch (RuntimeException ex) {
			return singleJourneyEntitiy;
		}

		return singleJourneyEntitiy;
	}
	
	public PassBookingEntity getPassbySerialNum(String passSerialNum) {
		PassBookingEntity passBookingEntity=null;
		try {
			TypedQuery<PassBookingEntity> query = entityManager.createNamedQuery("PassBookingEntity.findByPassSerialNum",	PassBookingEntity.class);
			query.setParameter("passSerialNum", passSerialNum);
			passBookingEntity = query.getSingleResult();
		} catch (RuntimeException ex) {
			return passBookingEntity;
		}

		return passBookingEntity;
	
	}
	
	public ValueQRTicketEntity getValueTicketQR(String tktSerialNum) {
		ValueQRTicketEntity valueQRTicketEntity=null;
		try {
			TypedQuery<ValueQRTicketEntity> query = entityManager.createNamedQuery("ValueQRTicketEntity.findByValueTktSerialNum",	ValueQRTicketEntity.class);
			query.setParameter("fullTicketNo", tktSerialNum);
			valueQRTicketEntity = query.getSingleResult();
		} catch (RuntimeException ex) {
			return valueQRTicketEntity;
		}

		return valueQRTicketEntity;

	}
	
	@Override
	public List<PassBookingEntity> findPassByUser(String user) {

		List<PassBookingEntity> passBookingEntityList=null;
		try {
			TypedQuery<PassBookingEntity> query = entityManager.createNamedQuery("PassBookingEntity.findByCreatedBy",	PassBookingEntity.class);
			query.setParameter("createdBy", user);
			passBookingEntityList = query.getResultList();
		} catch (RuntimeException ex) {
			return passBookingEntityList;
		}

		return passBookingEntityList;
	}

	public List<PassMasterEntity> findAllPassMaster() {
		return entityManager.createQuery("SELECT p FROM PassMasterEntity p", PassMasterEntity.class).getResultList();
	}

	@Override
	public PassBookingEntity savePassBooking(PassBookingEntity passBookingEntity) {
		log.debug("******************** savePassBooking() starts executing *****************");
		try{
			entityManager.persist(passBookingEntity);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.busafcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return passBookingEntity;

	}

	@Override
	public List<SingleJourneyEntitiy> findJourney(String userId) {
		// SingleJourneyEntitiy.findByUserId
		List<SingleJourneyEntitiy> sjList=null;
		try {
			TypedQuery<SingleJourneyEntitiy> query = entityManager.createNamedQuery("SingleJourneyEntitiy.findByUserId",	SingleJourneyEntitiy.class);
			query.setParameter("userId", userId);
			sjList = query.getResultList();
		} catch (RuntimeException ex) {
			return sjList;
		}

		return sjList;
	}
	
	//SingleJourneyEntitiy.findBySrcDest
	
	
	@Override
	public List<SingleJourneyEntitiy> findJourneybySrcDest(List<Integer> srcStpList , List<Integer> destStpList) {
		// SingleJourneyEntitiy.findByUserId
		List<SingleJourneyEntitiy> sjList=null;
		try {
			TypedQuery<SingleJourneyEntitiy> query = entityManager.createNamedQuery("SingleJourneyEntitiy.findBySrcDest",	SingleJourneyEntitiy.class);
			query.setParameter("srcStpList", srcStpList);
			query.setParameter("destStpList", destStpList);
			sjList = query.getResultList();
		} catch (RuntimeException ex) {
			return sjList;
		}

		return sjList;
	}
	
	public List<PassBookingEntity> findPassBookingbySrcDest(List<Integer> srcStpList, List<Integer> destStpList) {
		// SingleJourneyEntitiy.findByUserId
		List<PassBookingEntity> pbList = null;
		try {
			TypedQuery<PassBookingEntity> query = entityManager
					.createNamedQuery("PassBookingEntity.findBySrcDest", PassBookingEntity.class);
			query.setParameter("srcStpList", srcStpList);
			query.setParameter("destStpList", destStpList);
			pbList = query.getResultList();
		} catch (RuntimeException ex) {
			return pbList;
		}

		return pbList;

	}
	
	@Override
	public FareEntity getFare(String srcStpId, String destStpId) {
		FareEntity fareEntity=null;
		try {
			TypedQuery<FareEntity> query = entityManager.createNamedQuery("FareEntity.findBySrcDestCode",	FareEntity.class);
			query.setParameter("srcStpId", srcStpId);
			query.setParameter("destStpId", destStpId);
			fareEntity = query.getSingleResult();
		} catch (RuntimeException ex) {
			return fareEntity;
		}

		return fareEntity;

	}
	
	@Override
	public SingleJourneyEntitiy getSingleJourney(String qrCode) {
		SingleJourneyEntitiy singleJourneyEntity=null;
		try {
			TypedQuery<SingleJourneyEntitiy> query = entityManager.createNamedQuery("SingleJourneyEntitiy.findByQRCode",	SingleJourneyEntitiy.class);
			query.setParameter("qrTicketHash", qrCode);
			singleJourneyEntity = query.getSingleResult();
		} catch (RuntimeException ex) {
			return singleJourneyEntity;
		}

		return singleJourneyEntity;
	}
	
	
	public TransactionUploadUser saveTransactions(TransactionUploadUser transactionUploadUser){
		log.debug("******************** saveTransactions() starts executing *****************");
		try{
			entityManager.persist(transactionUploadUser);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.busafcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return transactionUploadUser;
	
	}

	@Override
	public ValueTicketEntryExitDetail saveValueTktEntryExit(ValueTicketEntryExitDetail valueTicketEntryExitDetail) {

		log.debug("******************** saveValueTktEntryExit() starts executing *****************");
		try{
			entityManager.persist(valueTicketEntryExitDetail);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.busafcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return valueTicketEntryExitDetail;
	
	}

	@Override
	public List<ValueTicketEntryExitDetail> findValueTktEntryExit(String Id) {


		List<ValueTicketEntryExitDetail> valueTicketEntryExitDetails=null;
		try {
			TypedQuery<ValueTicketEntryExitDetail> query = entityManager.createNamedQuery("ValueTicketEntryExitDetail.findByValueId",	ValueTicketEntryExitDetail.class);
			query.setParameter("valueTktId", Id);
			valueTicketEntryExitDetails = query.getResultList();
		} catch (RuntimeException ex) {
			return valueTicketEntryExitDetails;
		}

		return valueTicketEntryExitDetails;

	}

	@Override
	public ValueTicketEntryExitDetail updateValueTktEntryExit(ValueTicketEntryExitDetail valueTicketEntryExitDetail) {

		log.debug("******************** updateValueTktEntryExit() starts executing *****************");
		try{
			entityManager.merge(valueTicketEntryExitDetail);
			entityManager.flush(); 
			
		
		}
		catch(Exception e){
			String[] exceptionData = ExceptionUtils.getExceptionGeneratedClassDetails(e.getStackTrace(), "com.example.busafcs");
			log.debug("Exception occured: "+this.getClass().getSimpleName()+"method name: "+Thread.currentThread().getStackTrace()[1].getMethodName()+"error message: "+e+"class name: "+exceptionData[0]+ "file name: "+exceptionData[1]+ "log method name: "+exceptionData[2]+"line number: "+exceptionData[3]);
			throw e;
		}
		return valueTicketEntryExitDetail;
	}

	
}
