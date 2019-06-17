package com.mobi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mobi.model.Booking;

public interface BookingCustomDao {

	List<Booking> getAllById(int userid);
}
