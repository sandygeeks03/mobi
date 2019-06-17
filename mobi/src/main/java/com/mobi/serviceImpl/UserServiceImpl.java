package com.mobi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobi.dao.UserDao;
import com.mobi.model.User;
import com.mobi.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAll() {
		return (List<User>) userDao.findAll();
	}

}
