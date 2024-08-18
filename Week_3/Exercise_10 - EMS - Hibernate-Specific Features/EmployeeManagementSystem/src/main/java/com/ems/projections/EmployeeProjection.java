package com.ems.projections;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
	@Value("#{target.id}")
	int getId();

	@Value("#{target.name}")
	String getName();

	@Value("#{target.email}")
	String getEmail();
	
}
