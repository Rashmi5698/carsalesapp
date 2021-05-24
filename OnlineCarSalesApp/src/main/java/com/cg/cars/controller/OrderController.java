package com.cg.cars.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cars.services.OrderService;
import com.cg.cars.model.OrderDTO;
import com.cg.cars.entities.Order;
import com.cg.cars.exceptions.OrderNotFoundException;

@RestController
@RequestMapping("/api/cars")
public class OrderController {
	static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	/************************************************************************************
	 * Method: addOrder 
	 * Description: It is used to add Order into Orders table
	 * @param Order: Order's reference variable.
	 * @returns Order: It returns Order with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@PostMapping("/add-order")
	public ResponseEntity<Object> insertOrder(@RequestBody Order order) {
		LOGGER.info("add-Order URL is opened");
		LOGGER.info("addOrder() is initiated");
		OrderDTO orderDTO = null;
		ResponseEntity<Object> orderResponse = null;
		orderDTO = orderService.addOrder(order);
		orderResponse = new ResponseEntity<>(orderDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addOrder() has executed");
		return orderResponse;
	}

	/************************************************************************************
	 * Method: getOrderById 
	 * Description: It is used to view Order by id from Orders table
	 * @param Order: Long id
	 * @returns Order: It returns Order with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-order/{id}")
	public ResponseEntity<Object> getOrderById(@PathVariable Long id) throws OrderNotFoundException {
		LOGGER.info("view-Order URL is opened");
		LOGGER.info("viewOrder() is initiated");
		OrderDTO orderDTO = orderService.getOrderById(id);
		LOGGER.info("viewOrder() has executed");
		return new ResponseEntity<>(orderDTO, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: updateOrder 
	 * Description: It is used to update Order into Order table
	 * @param Order: Order's reference variable.
	 * @returns Order: It returns Order with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@PutMapping("/update-order/{id}")
	public ResponseEntity<Object> updateOrderById(@PathVariable Long id, @RequestBody Order orderRequest)
			throws OrderNotFoundException {
		LOGGER.info("update-Order URL is opened");
		LOGGER.info("updateOrder() is initiated");
		orderService.updateOrderById(id, orderRequest);
		LOGGER.info("updateOrder() has executed");
		return new ResponseEntity<>("Updated ", HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getAllOrders 
	 * Description: It is used to view all Orders in Orders table
	 * @returns Order: It returns Order with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-all-order")
	public List<OrderDTO> viewAllOrders() {
		LOGGER.info("view-all-Order URL is opened");
		LOGGER.info("view-all-Order() is initiated");
		LOGGER.info("view-all-Order() has executed");
		return orderService.getAllOrders();
	}

	/************************************************************************************
	 * Method: DeleteOrder 
	 * Description: It is used to remove Order from Orders table
	 * @param Order: Long id
	 * @returns Order: It returns Order with details
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@DeleteMapping("/delete-order/{id}")
	public ResponseEntity<Object> deleteOrderById(@PathVariable Long id) throws OrderNotFoundException {
		LOGGER.info("delete-Order URL is opened");
		LOGGER.info("delete-Order() is initiated");
		orderService.deleteOrderById(id);
		LOGGER.info("delete-Order() has executed");
		return new ResponseEntity<>("deleted successfully:", HttpStatus.ACCEPTED);

	}
}
