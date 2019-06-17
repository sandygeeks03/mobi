package com.mobi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobi.model.Room;

@Repository
public interface RoomDao extends CrudRepository<Room, Integer> {


}
