package com.zibble.entity;

import javax.persistence.*;


@Entity
@Table(name = "userdetailsud")
public class UserDetailsUD {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idud")
	private int idUD;

	@Column(name = "mobilenumberud")
	private String mobileNumberUD;


	
	public UserDetailsUD() {
	}

	public UserDetailsUD(String mobileNumberUD) {
		this.mobileNumberUD = mobileNumberUD;
	}

	public int getIdUD() {
		return idUD;
	}

	public void setIdUD(int idUD) {
		this.idUD = idUD;
	}

	public String getMobileNumberUD() {
		return mobileNumberUD;
	}

	public void setMobileNumberUD(String mobileNumberUD) {
		this.mobileNumberUD = mobileNumberUD;
	}

	@Override
	public String toString() {
		return "UserDetailsUD [idUD=" + idUD + ", mobileNumberUD=" + mobileNumberUD + "]";
	}

	
	
	}
