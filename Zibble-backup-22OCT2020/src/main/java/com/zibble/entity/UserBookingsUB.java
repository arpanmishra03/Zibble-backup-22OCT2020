package com.zibble.entity;

import javax.persistence.*;


@Entity
@Table(name = "userbookingsub")
public class UserBookingsUB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idub")
	private int idUB;

	@Column(name = "mobilenumberud")
	private String mobileNumberUD;

	
	@Column(name = "idsv")
	private String IdSV;
	
	@Column(name = "idsc")
	private String IdSC;
	
	@Column(name = "idst")
	private String IdST;
	
	@Column(name = "statusub")
	private String StatusUB;
	
	@Column(name = "bookingamountub")
	private String BookingAmountUB;

	@Column(name = "serviceamountUB")
	private String ServiceAmountUB;
	
	@Column(name = "vendorcommentsub")
	private String VendorCommentsUB;
	
	@Column(name = "ubmodifiedtime")
	private String UBModifiedTime;
	
	
	
	public UserBookingsUB() {
	}

	

	public UserBookingsUB(int idUB, String mobileNumberUD, String idSV, String idSC, String idST, String statusUB,
			String bookingAmountUB, String serviceAmountUB, String vendorCommentsUB, String uBModifiedTime) {
		super();
		this.idUB = idUB;
		this.mobileNumberUD = mobileNumberUD;
		this.IdSV = idSV;
		this.IdSC = idSC;
		this.IdST = idST;
		this.StatusUB = statusUB;
		this.BookingAmountUB = bookingAmountUB;
		this.ServiceAmountUB = serviceAmountUB;
		this.VendorCommentsUB = vendorCommentsUB;
		this.UBModifiedTime = uBModifiedTime;
	}



	public int getIdUB() {
		return idUB;
	}



	public void setIdUB(int idUB) {
		this.idUB = idUB;
	}



	public String getMobileNumberUD() {
		return mobileNumberUD;
	}



	public void setMobileNumberUD(String mobileNumberUD) {
		this.mobileNumberUD = mobileNumberUD;
	}



	public String getIdSV() {
		return IdSV;
	}



	public void setIdSV(String idSV) {
		IdSV = idSV;
	}



	public String getIdSC() {
		return IdSC;
	}


	public void setIdSC(String idSC) {
		IdSC = idSC;
	}



	public String getIdST() {
		return IdST;
	}



	public void setIdST(String idST) {
		IdST = idST;
	}



	public String getStatusUB() {
		return StatusUB;
	}



	public void setStatusUB(String statusUB) {
		StatusUB = statusUB;
	}



	public String getBookingAmountUB() {
		return BookingAmountUB;
	}



	public void setBookingAmountUB(String bookingAmountUB) {
		BookingAmountUB = bookingAmountUB;
	}



	public String getServiceAmountUB() {
		return ServiceAmountUB;
	}



	public void setServiceAmountUB(String serviceAmountUB) {
		ServiceAmountUB = serviceAmountUB;
	}



	public String getVendorCommentsUB() {
		return VendorCommentsUB;
	}



	public void setVendorCommentsUB(String vendorCommentsUB) {
		VendorCommentsUB = vendorCommentsUB;
	}



	public String getUBModifiedTime() {
		return UBModifiedTime;
	}



	public void setUBModifiedTime(String uBModifiedTime) {
		UBModifiedTime = uBModifiedTime;
	}



	@Override
	public String toString() {
		return "UserBookingsUB [idUB=" + idUB + ", mobileNumberUD=" + mobileNumberUD + ", IdSV=" + IdSV + ", IdSC="
				+ IdSC + ", IdST=" + IdST + ", StatusUB=" + StatusUB + ", BookingAmountUB=" + BookingAmountUB
				+ ", ServiceAmountUB=" + ServiceAmountUB + ", VendorCommentsUB=" + VendorCommentsUB
				+ ", UBModifiedTime=" + UBModifiedTime + "]";
	}

	
	
	
	
	}
