package com.example.mongoDB.service;

import java.util.List;

import com.example.mongoDB.entity.User;
import com.example.mongoDB.entity.UserData;

public interface IUserService {

	public List<User> doFind();

	public void doSave(User user, UserData userData);

}
