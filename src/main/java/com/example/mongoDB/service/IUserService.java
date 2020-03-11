package com.example.mongoDB.service;

import java.util.List;

<<<<<<< HEAD
import com.example.mongoDB.entity.UserEntity;
import com.example.mongoDB.entity.UserDataEntity;

public interface IUserService {

	public List<UserEntity> doFind();

	public void doSave(UserEntity user, UserDataEntity userData);
=======
import com.example.mongoDB.entity.User;
import com.example.mongoDB.entity.UserData;

public interface IUserService {

	public List<User> doFind();

	public void doSave(User user, UserData userData);
>>>>>>> 3ae5862dadade7f5f6d67f854bfbaf2ac6e65f64

}
