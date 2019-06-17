package com.mobi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobi.dao.RoomDao;
import com.mobi.model.Room;
import com.mobi.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;
	
	@Override
	public void save(Room room) {
		roomDao.save(room);
		
	}

	@Override
	public Room getroom(int roomid) {
		return roomDao.findOne(roomid);
	}

}
