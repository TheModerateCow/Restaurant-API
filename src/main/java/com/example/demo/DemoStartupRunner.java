package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.Food;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.OrderLine;
import com.example.demo.Entity.Position;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.FoodRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Repository.PositionRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class DemoStartupRunner implements CommandLineRunner {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PositionRepository positionRepository;

	@Override
	public void run(String... args) throws Exception {
		// Employees and Positions
		Position StoreManager = new Position("Store Manager");
		Position AssistantStoreManager = new Position("Assistant Store Manager");
		Position Cashier = new Position("Cashier");
		Position Waiter = new Position("Waiter");
		Position Janitor = new Position("Janitor");
		positionRepository.saveAll(List.of(StoreManager, AssistantStoreManager, Cashier, Janitor, Waiter));

		Employee Bryan = new Employee("Bryan", "Cuh", StoreManager, new Date());
		Employee Janice = new Employee("Janice", "Neh", AssistantStoreManager, new Date());
		Employee Sean = new Employee("Sean", "Con", Cashier, new Date());
		employeeRepository.saveAll(List.of(Bryan, Janice, Sean));

		Food Burger = new Food("Burger", 5.99F);
		Food Fries = new Food("Fries", 3.99F);
		Food WholeChicken = new Food("Whole Chicken", 15.99F);

		foodRepository.saveAll(List.of(Burger, Fries, WholeChicken));

		// Create New Order (Order1)
		Order Order1 = new Order();
		Order1.setHost(Sean);
		OrderLine orderLine1 = new OrderLine(2, Burger);
		OrderLine orderLine2 = new OrderLine(2, Fries);
		Order1.setOrderLines(Set.of(orderLine1, orderLine2));

		// Create New Order (Order2)
		Order Order2 = new Order();
		Order2.setHost(Janice);
		Order2.setOrderLines(Set.of(new OrderLine(1, WholeChicken)));

		// Save Orders
		orderRepository.saveAll(List.of(Order1, Order2));
	}

}
