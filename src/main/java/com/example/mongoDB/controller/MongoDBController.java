package com.example.mongoDB.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongoDB.entity.BrokerEntity;
import com.example.mongoDB.entity.MenuEntity;
import com.example.mongoDB.entity.ProductEntity;
import com.example.mongoDB.entity.StockDetailEntity;
import com.example.mongoDB.entity.UserDataEntity;
import com.example.mongoDB.entity.UserEntity;
import com.example.mongoDB.model.MenuModel;
import com.example.mongoDB.model.UserRequest;
import com.example.mongoDB.service.IBrokerService;
import com.example.mongoDB.service.IMenuService;
import com.example.mongoDB.service.IStockDetailService;
import com.example.mongoDB.service.IStorageService;
import com.example.mongoDB.service.IUserService;
import com.example.springbootfeignclient.model.BaseRs;
import com.example.springbootfeignclient.model.BrokerRequest;
import com.example.springbootfeignclient.model.BrokerResponse;
import com.example.springbootfeignclient.model.MenuRequest;
import com.example.springbootfeignclient.model.OrderRequest;
import com.example.springbootfeignclient.model.OrderResponse;
import com.example.springbootfeignclient.utils.BigDecimalUtils;
import com.example.springbootfeignclient.vo.OrderVo;
import com.example.springbootfeignclient.vo.StockVo;

@RestController
@EnableAutoConfiguration
public class MongoDBController {
	Logger logger = Logger.getLogger(MongoDBController.class.getName());

	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	@Autowired
	@Qualifier("menuService")
	private IMenuService menuService;

	@Autowired
	@Qualifier("storageService")
	private IStorageService storageService;

	@Autowired
	@Qualifier("brokerService")
	private IBrokerService brokerService;

	@Autowired
	@Qualifier("stockDetailService")
	private IStockDetailService stockDetailService;

	@Value("${server.port}")
	// 可以取得port號
	private String port;

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

		response.setBrokers(brokerService.getBroker());

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

	/**
	 * 讀指定網址並記錄內容
	 * 
	 * @param url 要抓取的網址
	 * @return
	 */
	@RequestMapping(value = "/setStockDetail", method = RequestMethod.GET)
	public ResponseEntity<?> setStockDetail(@RequestParam("url") String url,
			@RequestParam(name = "branchId", required = false) String branchId) {

		logger.info("##### setStockDetail start!!! #####");
		long start = Calendar.getInstance().getTimeInMillis();
		List<StockDetailEntity> entities = new ArrayList<>();
		StockDetailEntity entity = null;
		String result = "";

		try {
//			TODO: 可以爬js的網頁，但還沒成功....
//			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_3);
//			webClient.setJavaScriptEnabled(true);
//			webClient.setCssEnabled(false);
//			webClient.setThrowExceptionOnScriptError(false);
//			webClient.setThrowExceptionOnFailingStatusCode(false);
//			webClient.setAjaxController(new NicelyResynchronizingAjaxController());// 设置Ajax异步
//			HtmlPage htmlPage = webClient.getPage(url);
//			Document doc = Jsoup.parse(htmlPage.asXml(), url);

			Document doc = Jsoup.connect(url).get();
			Elements eles = doc.body().getElementsByAttribute("nowrap");
			int size = eles.size();

			logger.info(String.valueOf(size));

			if (size % 4 == 0) {
				for (int i = 0; i < size; i += 4) {
					String stock = eles.get(i).getElementsByTag("script").html().toString().replace("\\r", "")
							.replace("\\n", "").replace("\\t", "");

					if (StringUtils.isNotBlank(stock) || stock.indexOf("GenLink2stk('AS") >= 0) {
						entity = new StockDetailEntity();

						entity.setBranchId(branchId);
						entity.setStockId(stock.substring(22, 26));
						entity.setStockName(stock.substring(29, stock.indexOf("');")));
						entity.setBuy(BigDecimalUtils.moneyStrToBigDeciaml(eles.get(i + 1).text()));
						entity.setSell(BigDecimalUtils.moneyStrToBigDeciaml(eles.get(i + 2).text()));
						entity.setBal(BigDecimalUtils.moneyStrToBigDeciaml(eles.get(i + 3).text()));

						entities.add(entity);
					}
				}
			}

			stockDetailService.setStock(entities);
			result = entities.toString();

		} catch (IOException e) {
			logger.warning(url);
			e.printStackTrace();
		}

		logger.info("===========end=========" + String.valueOf(Calendar.getInstance().getTimeInMillis() - start));
		logger.info("##### setStockDetail end!!! #####");
		return ResponseEntity.ok(result);
	}

	/**
	 * 讀指定網址並記錄內容
	 * 
	 * @param url 要抓取的網址
	 * @return
	 */
	@RequestMapping(value = "/setStockDetail2", method = RequestMethod.POST)
	public ResponseEntity<?> setStockDetail(@RequestBody StockVo stockvo) {

		logger.info("##### setStockDetail start!!! #####");
		long start = Calendar.getInstance().getTimeInMillis();
		List<StockDetailEntity> entities = new ArrayList<>();
		StockDetailEntity entity = null;
		Document doc = Jsoup.parse(stockvo.getBody());
		Elements eles = doc.body().getElementsByAttribute("nowrap");		
		int size = eles.size();

		logger.info(String.valueOf(size));

		if (size % 4 == 0) {
			for (int i = 0; i < size; i += 4) {
				String stock = eles.get(i).getElementsByTag("script").html().toString().replace("\r", "")
						.replace("\n", "").replace("\t", "");

				if (StringUtils.isNotBlank(stock) || stock.indexOf("GenLink2stk('AS") >= 0) {
					entity = new StockDetailEntity();

					entity.setBranchId(stockvo.getBranchId());
					entity.setStockId(stock.substring(19, 23));
					entity.setStockName(stock.substring(26, stock.indexOf("')")));
					entity.setBuy(BigDecimalUtils.moneyStrToBigDeciaml(eles.get(i + 1).text()));
					entity.setSell(BigDecimalUtils.moneyStrToBigDeciaml(eles.get(i + 2).text()));
					entity.setBal(BigDecimalUtils.moneyStrToBigDeciaml(eles.get(i + 3).text()));
					entity.setDate(stockvo.getDate());

					entities.add(entity);
				}
			}
		}

		stockDetailService.setStock(entities);

		logger.info(entities.size() + "===========end========="
				+ String.valueOf(Calendar.getInstance().getTimeInMillis() - start));
		logger.info("##### setStockDetail end!!! #####");
		return ResponseEntity.ok(new BaseRs("0000"));
	}

	@RequestMapping(value = "/getStockDetail", method = RequestMethod.GET)
	public ResponseEntity<?> getStockDetail() {
		logger.info("##### getStockDetail start!!! #####");

		List<StockDetailEntity> stocks = stockDetailService.getStock();
				
		logger.info("stocks.size: " + String.valueOf(stocks.size()));
				
		logger.info("##### getStockDetail end!!! #####");
		return ResponseEntity.ok(stocks.parallelStream().collect(Collectors.groupingBy(StockDetailEntity::getDate)).keySet());
	}

}