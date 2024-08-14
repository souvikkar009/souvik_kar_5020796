package com.ems.entitites;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {
	@Id
	@Column(name = "dept_id")
	private int id;

	@Column(name = "dept_name", nullable = false)
	private String name;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Employee> employees;
}
