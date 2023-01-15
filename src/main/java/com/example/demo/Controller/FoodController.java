package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Food;
import com.example.demo.Service.FoodService;

@RestController
public class FoodController {
	@Autowired
	private FoodService foodService;

	@GetMapping(path = "/foods")
	public List<Food> getAllFoods() {
		return foodService.getAllFoods();
	}
}
