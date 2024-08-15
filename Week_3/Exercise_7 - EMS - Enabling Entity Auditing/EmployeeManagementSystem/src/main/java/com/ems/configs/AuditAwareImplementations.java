package com.ems.configs;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditAwareImplementations implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Souvik Kar");
	}

}
