package com.example.mongoDB.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoDB.entity.UserDataEntity;
import com.example.mongoDB.entity.UserEntity;
import com.example.mongoDB.repository.UserDataRepository;
import com.example.mongoDB.repository.UserRepository;
import com.example.mongoDB.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserDataRepository userDataRepository;

	@Override
	public List<UserEntity> doFind() {

		logger.info("doFind() start!!!");

		return userRepository.findAll();
	}

	@Override
	public void doSave(UserEntity user, UserDataEntity userData) {

		logger.info("save() start!!!");

		userDataRepository.save(userData);
		userRepository.save(user);
	}

}
