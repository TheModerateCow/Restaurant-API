package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}
