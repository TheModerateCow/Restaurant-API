package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
	private static final long serialVersionUID = -4040489470921378500L;

	@Id
	@SequenceGenerator(name = "Employee_Gen", sequenceName = "Employee_Gen")
	@GeneratedValue(generator = "Employee_Gen")
	private Long id;

	private String firstName;

	private String lastName;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Position position;

	private Boolean employed = true;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn
	private Employee manager;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "manager")
	private Set<Employee> subordinates = new HashSet<>();

	private Date joinedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@CreationTimestamp
	private Date createdAt;

	public Employee(String firstName, String lastName, Position position, Date joinedAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.joinedAt = joinedAt;
	}

}
