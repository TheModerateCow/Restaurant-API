package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Food;
import com.example.demo.Repository.FoodRepository;

@Service
public class FoodService {
	@Autowired
	private FoodRepository foodRepository;
	
	public List<Food> getAllFoods() {
		return foodRepository.findAll();
	}
}
