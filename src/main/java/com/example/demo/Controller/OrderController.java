package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Order;
import com.example.demo.Service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping(path = "/orders")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
}
