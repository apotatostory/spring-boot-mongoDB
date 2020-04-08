package com.example.mongoDB.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongoDB.entity.BrokerEntity;
import com.example.mongoDB.repository.BrokerRepository;
import com.example.mongoDB.service.IBrokerService;
import com.example.springbootfeignclient.vo.BrokerVo;

@Service("brokerService")
public class BrokerServiceImpl implements IBrokerService {

	@Autowired
	BrokerRepository brokerRepository;

	@Override
	public List<BrokerVo> getBroker() {

		return brokerRepository.findAll().stream().map(broker -> {
			BrokerVo vo = new BrokerVo();
			BeanUtils.copyProperties(broker, vo);
			return vo;
		}).collect(Collectors.toList());
	}

	@Override
	public BrokerEntity setBroker(BrokerEntity broker) {

		return brokerRepository.save(broker);
	}

	@Override
	public List<BrokerEntity> setBroker(List<BrokerEntity> brokers) {
		return brokerRepository.saveAll(brokers);
	}

}
