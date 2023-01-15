package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

}
