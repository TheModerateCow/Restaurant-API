package com.example.demo.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine implements Serializable {
	private static final long serialVersionUID = -2959753054292947864L;

	@Id
	@SequenceGenerator(name = "OrderLine_Gen", sequenceName = "OrderLine_Gen")
	@GeneratedValue(generator = "OrderLine_Gen")
	private Long id;

	private Integer quantity;

	@ManyToOne
	private Food food;

	public OrderLine(Integer quantity, Food food) {
		super();
		this.quantity = quantity;
		this.food = food;
	}

}
