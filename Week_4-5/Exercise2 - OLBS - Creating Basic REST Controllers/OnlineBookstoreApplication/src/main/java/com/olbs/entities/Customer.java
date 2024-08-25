package com.olbs.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;

	@Column(name = "customer_name", nullable = false)
	@NonNull
	@Size(min = 2, max = 40)
	private String name;

	@Column(name = "customer_email", nullable = false, unique = true)
	@NonNull
	@Email
	private String email;

	@Column(name = "customer_password", nullable = false)
	@NonNull
	@Min(6)
	private String password;

	@OneToMany
	private List<Order> orders;
	
//	@Version
//	@Column(name = "version", nullable = false)
//	private Integer version;

}
