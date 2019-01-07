package com.jit.team.csv_to_liquibase_converter.control;

import java.util.ArrayList;
import java.util.List;

import com.jit.team.csv_to_liquibase_converter.entity.Column;
import com.jit.team.csv_to_liquibase_converter.entity.LiquibaseInsert;

public interface LiquibaseInsertMapper {

	String COURIER_SYMBOL_COLUMN_NAME = "courierSymbol";
	String MAPPED_STATUS_COLUMN_NAME = "mappedStatus";
	String STATUS_COLUMN_NAME = "status";

	default LiquibaseInsert mapCsvLineOntoLiquibaseInsert(final String[] csvLine, final String courierSymbol, final String tableName) {
		List<Column> columns = new ArrayList<>();

		columns.add(mapCourierColumn(courierSymbol));
		columns.add(mapMappedStatus(csvLine));
		columns.add(mapStatus(csvLine));

		return new LiquibaseInsert(tableName, columns);
	}

	default Column mapCourierColumn(String courierSymbol) {
		return new Column(COURIER_SYMBOL_COLUMN_NAME, courierSymbol);
	}

	Column mapMappedStatus(String[] csvLine);

	Column mapStatus(String[] csvLine);
}
