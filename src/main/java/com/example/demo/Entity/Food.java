package com.example.demo.Entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food implements Serializable {
	private static final long serialVersionUID = 1469686037326538198L;

	@Id
	@SequenceGenerator(name = "Food_Gen", sequenceName = "Food_Gen")
	@GeneratedValue(generator = "Food_Gen")
	private Long id;

	private String name;

	private Float price;

	public Food(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

}
