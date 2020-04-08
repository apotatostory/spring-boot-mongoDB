package com.example.mongoDB.service;

import java.util.List;

import com.example.mongoDB.entity.BrokerEntity;
import com.example.springbootfeignclient.vo.BrokerVo;

public interface IBrokerService {
	public List<BrokerVo> getBroker();

	public BrokerEntity setBroker(BrokerEntity broker);

	public List<BrokerEntity> setBroker(List<BrokerEntity> brokers);

}
