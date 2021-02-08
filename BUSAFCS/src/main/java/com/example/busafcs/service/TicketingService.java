package com.example.busafcs.service;

import com.example.busafcs.bean.AfcsApiResponse;
import com.example.busafcs.bean.CustomerRegistrationRequest;
import com.example.busafcs.bean.FareRequest;
import com.example.busafcs.bean.IssueValueQRRequest;
import com.example.busafcs.bean.MasterDataRequest;
import com.example.busafcs.bean.MyTicketRequest;
import com.example.busafcs.bean.MyTripsRequest;
import com.example.busafcs.bean.PassFareRequest;
import com.example.busafcs.bean.PassQRRequest;
import com.example.busafcs.bean.PassSerialNumRequest;
import com.example.busafcs.bean.QRBalanceRequest;
import com.example.busafcs.bean.SingleJourneyRequest;
import com.example.busafcs.bean.StopMasterRequest;
import com.example.busafcs.bean.TicketDataRequest;
import com.example.busafcs.bean.UploadQRCodeRequest;
import com.example.busafcs.bean.UploadTransactionRequest;

public interface TicketingService {

	public AfcsApiResponse singleJourneyFare(SingleJourneyRequest singleJourneyRequest);
	
	public AfcsApiResponse submitTicket(SingleJourneyRequest singleJourneyRequest);
	
	public AfcsApiResponse custReg(CustomerRegistrationRequest customerRegistrationRequest);
	
	public AfcsApiResponse issueValueQR(IssueValueQRRequest issueValueQRRequest);
	
	public AfcsApiResponse getStopMaster(StopMasterRequest stopMasterRequest);
	
	public AfcsApiResponse getPassDetails(PassFareRequest passFareRequest);
	
	public AfcsApiResponse getPassSerialNumber(PassSerialNumRequest passSerialNumRequest);
	
	public AfcsApiResponse getPassQR(PassQRRequest passQRRequest);
	
	public AfcsApiResponse getMyValidTicket (MyTicketRequest myTicketRequest);
	
	public AfcsApiResponse getMyFare(FareRequest fareRequest);
	
	public AfcsApiResponse getMaster(MasterDataRequest masterDataRequest);
	
	public AfcsApiResponse uploadQRTicket(UploadQRCodeRequest uploadQRCodeRequest);
	
	public AfcsApiResponse uploadTxnData(UploadTransactionRequest uploadTransactionRequest);
	
	public AfcsApiResponse getTicketsData(TicketDataRequest ticketDataRequest);
	
	public AfcsApiResponse getMyTrips(MyTripsRequest myTripsRequest);
	
	public AfcsApiResponse getQRValance(QRBalanceRequest qrBalanceRequest);
	
	

		
}
