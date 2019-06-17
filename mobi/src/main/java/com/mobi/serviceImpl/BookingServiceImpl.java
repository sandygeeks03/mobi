package com.mobi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobi.dao.BookingDao;
import com.mobi.dao.UserDao;
import com.mobi.model.Booking;
import com.mobi.model.Room;
import com.mobi.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDao bookDao;

	@Override
	public List<Booking> getAllById(int userid) {
		// TODO Auto-generated method stub
		return bookDao.getAllById(userid);
	}
	
	

}
