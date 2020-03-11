package com.example.mongoDB.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoDB.entity.BrokerEntity;
import com.example.mongoDB.entity.MenuEntity;
import com.example.mongoDB.entity.ProductEntity;
import com.example.mongoDB.entity.UserDataEntity;
import com.example.mongoDB.entity.UserEntity;
import com.example.mongoDB.model.MenuModel;
import com.example.mongoDB.model.UserRequest;
import com.example.mongoDB.service.IBrokerService;
import com.example.mongoDB.service.IMenuService;
import com.example.mongoDB.service.IStorageService;
import com.example.mongoDB.service.IUserService;
import com.example.springbootfeignclient.model.BrokerRequest;
import com.example.springbootfeignclient.model.BrokerResponse;
import com.example.springbootfeignclient.model.MenuRequest;
import com.example.springbootfeignclient.model.OrderRequest;
import com.example.springbootfeignclient.model.OrderResponse;
import com.example.springbootfeignclient.vo.OrderVo;

@RestController
@EnableAutoConfiguration
public class MongoDBController {
	Logger logger = Logger.getLogger(MongoDBController.class.getName());

	@Autowired
	@Qualifier("userService")
	IUserService userService;

	@Autowired
	@Qualifier("menuService")
	IMenuService menuService;

	@Autowired
	@Qualifier("storageService")
	IStorageService storageService;

	@Autowired
	@Qualifier("brokerService")
	IBrokerService brokerService;

	@Value("${server.port}")
	// 可以取得port號
	String port;

	/**
	 * 查詢User全部資料
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/user/find", method = RequestMethod.GET)
	public ResponseEntity<?> find() throws Exception {
		logger.info("##### find start!!! #####");

		List<UserEntity> result = new ArrayList<>();

		try {
			result = userService.doFind();
		} catch (Exception e) {
			System.out.println("===== find Exception!!! =====");
			e.printStackTrace();
		}

		logger.info("##### find end!!! #####");
		return ResponseEntity.ok(result);
	}

	/**
	 * 儲存User資料
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/user/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody(required = false) UserRequest request) throws Exception {
		logger.info("##### save start!!! #####");

		UserEntity user = new UserEntity();
		UserDataEntity userData = new UserDataEntity();
		Long id = Calendar.getInstance().getTimeInMillis();

		user.setId(id);
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setUserType(request.getUserType());
		user.setMemo(request.getMemo());

		userData.setId(id);
		userData.setUserId(request.getUserId());
		userData.setPwd(request.getPwd());

		try {
			userService.doSave(user, userData);
		} catch (Exception e) {
			System.out.println("===== save Exception!!! =====");
			e.printStackTrace();
		}
		logger.info("##### save end!!! #####");
		return ResponseEntity.ok(true);
	}

	/**
	 * 查詢Menu
	 * 
	 * @return
	 */
	@RequestMapping(path = "/getMenu", method = RequestMethod.GET)
	public ResponseEntity<?> getMenu() {
		logger.info("##### getMenu start!!! #####");

		Map<String, List<MenuEntity>> menuMap = menuService.getMenu();

		List<MenuModel> result = menuMap.values().stream().map(x -> {
			MenuModel model = new MenuModel();
			model.setCateName(x.get(0).getName());
			model.setMenuList(x);
			return model;
		}).collect(Collectors.toList());
		logger.info("##### getMenu end!!! #####");
		return ResponseEntity.ok(result);
	}

	@RequestMapping(path = "/menu/set", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> setMenu(@RequestBody MenuRequest request) {
		logger.info("##### setMenu start!!! #####");

		MenuEntity menu = new MenuEntity();

		BeanUtils.copyProperties(request, menu);

		menuService.setMenu(menu);

		logger.info("##### setMenu end!!! #####");
		return ResponseEntity.ok(true);
	}

	/**
	 * 點餐
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/orderProduct", method = RequestMethod.POST)
	public ResponseEntity<?> doOrder(@RequestBody OrderRequest request) {
		logger.info("##### doOrder start!!! #####");
		OrderResponse response = new OrderResponse();

		response.setProducts(request.getProducts());

		logger.info("##### doOrder end!!! #####");
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct() {

		logger.info("##### getProduct start!!! #####");
		OrderResponse response = new OrderResponse();

		response.setProducts(storageService.getProduct());

		logger.info("##### getProduct end!!! #####");
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/setProduct", method = RequestMethod.POST)
	public ResponseEntity<?> setProduct(@RequestBody OrderRequest request) {

		logger.info("##### setProduct start!!! #####");
		OrderResponse response = new OrderResponse();
		OrderVo model = request.getProduct();
		ProductEntity product = new ProductEntity();
		Date nowDate = Calendar.getInstance().getTime();

		BeanUtils.copyProperties(model, product);

		product.setCreationDate(nowDate); // 初始日期

		storageService.setProduct(product);

		response.setProduct(model);

		logger.info("##### setProduct end!!! #####");
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/getBroker", method = RequestMethod.GET)
	public ResponseEntity<?> getBroker() {

		logger.info("##### getBroker start!!! #####");
		BrokerResponse response = new BrokerResponse();

		response.setBrokerMap(brokerService.getBroker());

		logger.info("##### getBroker end!!! #####");
		return ResponseEntity.ok(response);
	}

	@RequestMapping(value = "/setBroker", method = RequestMethod.POST)
	public ResponseEntity<?> setBroker(@RequestBody BrokerRequest request) {

		logger.info("##### setBroker start!!! #####");

		BrokerResponse response = new BrokerResponse();
		List<BrokerEntity> entitys = new ArrayList<>();

		if (request.getBorker() != null) {
			BrokerEntity entity = new BrokerEntity();

			BeanUtils.copyProperties(request.getBorker(), entity);

			entitys.add(entity);
		}

		if (request.getBrokers() != null) {
			entitys = request.getBrokers().parallelStream().map(vo -> {
				BrokerEntity entity = new BrokerEntity();

				BeanUtils.copyProperties(vo, entity);

				return entity;
			}).collect(Collectors.toList());

		}
		brokerService.setBroker(entitys);

		logger.info("##### setBroker end!!! #####");

		return ResponseEntity.ok(response);
	}

}