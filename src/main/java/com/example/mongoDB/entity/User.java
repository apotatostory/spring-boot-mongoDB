package com.example.mongoDB.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "USER")
public class User {

	@Id
	private long id;
	@Field(value = "FIRST_NAME")
	private String firstName;
	@Field(value = "LAST_NAME")
	private String lastName;
	@Field(value = "USER_TYPE") // 使用者權限 0最大
	private String userType;
	@Field(value = "MEMO")
	private String memo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return new StringBuilder(this.firstName).append(" ").append(this.lastName).append(", userType: ")
				.append(this.userType).toString();
	}

}
