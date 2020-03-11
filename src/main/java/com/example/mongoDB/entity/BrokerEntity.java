package com.example.mongoDB.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "BROKER")
public class BrokerEntity {
	
	@Field(value = "BROKERID")
	private String BrokerId;

	@Field(value = "BROKERNAME")
	private String BrokerName;

	@Id
	@Field(value = "BRANCHID")
	private String BranchId;

	@Field(value = "BRANCHNAME")
	private String BranchName;

	public String getBrokerId() {
		return BrokerId;
	}

	public void setBrokerId(String brokerId) {
		BrokerId = brokerId;
	}

	public String getBrokerName() {
		return BrokerName;
	}

	public void setBrokerName(String brokerName) {
		BrokerName = brokerName;
	}

	public String getBranchId() {
		return BranchId;
	}

	public void setBranchId(String branchId) {
		BranchId = branchId;
	}

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
}
