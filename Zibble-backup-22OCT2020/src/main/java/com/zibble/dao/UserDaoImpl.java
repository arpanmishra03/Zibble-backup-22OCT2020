package com.zibble.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zibble.entity.UserDetailsUD;


@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public UserDetailsUD findByMobileNumberUD(String mobileNumberUD) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using username
		Query<UserDetailsUD> theQuery = currentSession.createQuery("from UserDetailsUD where mobileNumberUD=:mNumber", UserDetailsUD.class);
		theQuery.setParameter("mNumber", mobileNumberUD);
	
		//List<UserDetailsUD> list=theQuery.list();  
		//int size = list.size();
		//System.out.println(size); 
		
		UserDetailsUD theUser = null;
		try {
			//theUser = theQuery.list().get(0); //getting user via list
			theUser = theQuery.getSingleResult(); // this will work only when there is one entry in db
		} catch (Exception e) {
			//System.out.println("Exception");
			theUser = null;
		}
	
		return theUser;
	}

	@Override
	public void save(UserDetailsUD theUser) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
	}

}
