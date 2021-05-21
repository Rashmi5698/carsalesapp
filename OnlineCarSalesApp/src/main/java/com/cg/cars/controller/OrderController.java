package com.cg.cars.controller;
import java.util.List;
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


//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@PostMapping("/add-order")
	public ResponseEntity<Object> insertOrder(@RequestBody Order order)
	{
		OrderDTO orderDTO = null;
		ResponseEntity<Object> orderResponse = null;
		orderDTO =orderService.addOrder(order);
		orderResponse = new ResponseEntity<Object>(orderDTO, HttpStatus.ACCEPTED);
		return orderResponse;
	}
	@GetMapping("/view-order/{id}")
	public ResponseEntity getOrderById(@PathVariable Long id) throws  OrderNotFoundException {
	
		OrderDTO orderDTO = orderService.getOrderById(id);
		
		return new ResponseEntity(orderDTO, HttpStatus.OK);
	}

@PutMapping("/update-order/{id}")
    public ResponseEntity updateOrderById(@PathVariable Long id, @RequestBody Order orderRequest) throws OrderNotFoundException {
		orderService.updateOrderById(id,orderRequest);
		return new ResponseEntity("Updated ", HttpStatus.OK);
}
	
	
	@GetMapping("/view-all-order")
	public List<OrderDTO> viewAllOrders() {
		
		return orderService.getAllOrders();
	}
	

	@DeleteMapping("/delete-order/{id}")
	public ResponseEntity<Object> deleteOrderById(@PathVariable Long id) throws OrderNotFoundException{
	
		orderService.deleteOrderById(id);
	
		return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);
	

}
}
