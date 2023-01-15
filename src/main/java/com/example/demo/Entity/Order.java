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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Order\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
	private static final long serialVersionUID = -5795701063502156552L;

	@Id
	@SequenceGenerator(name = "Order_Gen", sequenceName = "Order_Gen")
	@GeneratedValue(generator = "Order_Gen")
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Employee host;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Set<OrderLine> orderLines = new HashSet<>();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@CreationTimestamp
	private Date createdAt;

	public Order(Set<OrderLine> orderLines) {
		super();
		this.orderLines = orderLines;
	}

}
