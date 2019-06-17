package com.mobi.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobi.dao.BookingCustomDao;
import com.mobi.model.Booking;

@Repository
public class BookingDaoImpl implements BookingCustomDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Booking> getAllById(int userid) {
		
		
		Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      List<Booking> bookings = null;
	      try {
	         tx = session.beginTransaction();
	         bookings = session.createQuery("FROM Booking").list(); 
	         
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		
		return bookings;
	}

}
