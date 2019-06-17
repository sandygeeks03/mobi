package com.mobi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobi.model.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, Integer>, BookingCustomDao{

	

}
