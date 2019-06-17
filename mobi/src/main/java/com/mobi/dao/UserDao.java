package com.mobi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobi.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

}
