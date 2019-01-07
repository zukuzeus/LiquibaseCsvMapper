package com.jit.team.csv_to_liquibase_converter.control;

import org.springframework.stereotype.Component;

import com.jit.team.csv_to_liquibase_converter.entity.Column;

@Component
public class CDEKInsertChangeSetMapper implements LiquibaseInsertMapper {

	public Column mapMappedStatus(String[] csvLine) {
		return new Column(MAPPED_STATUS_COLUMN_NAME, csvLine[1]);
	}

	public Column mapStatus(String[] csvLine) {
		return new Column(STATUS_COLUMN_NAME, csvLine[0]);
	}
}
