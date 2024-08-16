package com.ems.projections;

import org.springframework.beans.factory.annotation.Value;

public interface DepartmentProjection {
	@Value("#{target.id}")
	int getId();

	@Value("#{target.name}")
	String getName();
}
