package com.example.mongoDB.service;

import java.util.List;

import com.example.mongoDB.entity.UserDataEntity;
import com.example.mongoDB.entity.UserEntity;

public interface IUserService {

	public List<UserEntity> doFind();

	public void doSave(UserEntity user, UserDataEntity userData);

}
