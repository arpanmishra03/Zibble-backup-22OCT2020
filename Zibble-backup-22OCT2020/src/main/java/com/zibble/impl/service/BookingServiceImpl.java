package com.zibble.impl.service;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zibble.entity.UserBookingsUB;

@Repository
@Service
public class BookingServiceImpl implements BookingService {

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(String mobileNumberUD, String service, String serviceType, String serviceCategory) {
		UserBookingsUB user = new UserBookingsUB(); // assign user details to the user object
		
		user.setMobileNumberUD(mobileNumberUD);
		user.setIdSV(service);
		user.setIdST(serviceType);
		user.setIdSC(serviceCategory);
		user.setStatusUB("1");
		user.setBookingAmountUB("99.0");
		user.setVendorCommentsUB("No comments added by vendor");
		user.setServiceAmountUB("0.0");
		
				// get current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);

				
				currentSession.saveOrUpdate(user);
				System.out.println("Booking made successfully");
		
	}

	
}
