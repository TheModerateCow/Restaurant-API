package com.example.demo.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {
	private static final long serialVersionUID = -2699343909923715543L;

	@Id
	@SequenceGenerator(name = "Position_Gen", sequenceName = "Position_Gen")
	@GeneratedValue(generator = "Position_Gen")
	private Long id;

	private String name;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "position")
	private Set<Employee> employees = new HashSet<>();

	public Position(String name) {
		super();
		this.name = name;
	}

}
