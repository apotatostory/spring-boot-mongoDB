package com.example.mongoDB.service;

import java.util.List;
import java.util.Map;

import com.example.mongoDB.entity.BrokerEntity;
import com.example.springbootfeignclient.vo.BrokerVo;

public interface IBrokerService {
	public Map<String, List<BrokerVo>> getBroker();

	public BrokerEntity setBroker(BrokerEntity broker);

	public List<BrokerEntity> setBroker(List<BrokerEntity> brokers);

}
