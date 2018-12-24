package com.jit.team.csv_to_liquibase_converter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

@Configuration
public class JacksonConfiguration {

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new XmlMapper();

		JaxbAnnotationModule module = new JaxbAnnotationModule();
		mapper.registerModule(module);

		return mapper;
	}
}
