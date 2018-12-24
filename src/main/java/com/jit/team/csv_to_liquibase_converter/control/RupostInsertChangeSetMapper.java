package com.jit.team.csv_to_liquibase_converter.control;

import org.springframework.stereotype.Service;

import com.jit.team.csv_to_liquibase_converter.entity.Column;

@Service
public class RupostInsertChangeSetMapper implements LiquibaseInsertMapper {

	private static final String COURIER_SYMBOL_COLUMN_NAME = "courierSymbol";
	private static final String MAPPED_STATUS_COLUMN_NAME = "mappedStatus";
	private static final String STATUS_COLUMN_NAME = "status";

	public Column mapCourierColumn(String courierSymbol) {
		return new Column(COURIER_SYMBOL_COLUMN_NAME, courierSymbol);
	}

	public Column mapMappedStatus(String[] csvLine) {
		return new Column(MAPPED_STATUS_COLUMN_NAME, csvLine[3]);
	}

	public Column mapStatus(String[] csvLine) {
		return new Column(STATUS_COLUMN_NAME, csvLine[0]);
	}
}
