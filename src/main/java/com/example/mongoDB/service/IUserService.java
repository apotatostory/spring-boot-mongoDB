package com.example.mongoDB.service;

import java.util.List;

import com.example.mongoDB.entity.UserEntity;
import com.example.mongoDB.entity.UserDataEntity;

public interface IUserService {

	public List<UserEntity> doFind();

	public void doSave(UserEntity user, UserDataEntity userData);

}
