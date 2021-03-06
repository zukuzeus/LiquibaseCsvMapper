package com.jit.team.csv_to_liquibase_converter.control;

import org.springframework.stereotype.Service;

import com.jit.team.csv_to_liquibase_converter.entity.Column;

@Service
public class RupostInsertChangeSetMapper implements LiquibaseInsertMapper {

	public Column mapMappedStatus(String[] csvLine) {
		return new Column(MAPPED_STATUS_COLUMN_NAME, csvLine[3]);
	}

	public Column mapStatus(String[] csvLine) {
		return new Column(STATUS_COLUMN_NAME, csvLine[0]);
	}
}
