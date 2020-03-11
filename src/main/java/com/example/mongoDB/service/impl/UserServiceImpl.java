package com.example.mongoDB.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.example.mongoDB.entity.UserEntity;
import com.example.mongoDB.entity.UserDataEntity;
=======
import com.example.mongoDB.entity.User;
import com.example.mongoDB.entity.UserData;
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
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
<<<<<<< HEAD
	public List<UserEntity> doFind() {
=======
	public List<User> doFind() {
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
		logger.info("doFind() start!!!");

		return userRepository.findAll();
	}

	@Override
<<<<<<< HEAD
	public void doSave(UserEntity user, UserDataEntity userData) {
=======
	public void doSave(User user, UserData userData) {
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64
		logger.info("save() start!!!");

		userDataRepository.save(userData);
		userRepository.save(user);
	}

}
