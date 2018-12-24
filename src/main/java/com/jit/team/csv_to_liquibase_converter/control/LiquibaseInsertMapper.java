package com.jit.team.csv_to_liquibase_converter.control;

import java.util.ArrayList;
import java.util.List;

import com.jit.team.csv_to_liquibase_converter.entity.Column;
import com.jit.team.csv_to_liquibase_converter.entity.LiquibaseInsert;

public interface LiquibaseInsertMapper {

	default LiquibaseInsert mapCsvLineOntoLiquibaseInsert(final String[] csvLine, final String courierSymbol, final String tableName) {
		List<Column> columns = new ArrayList<>();

		columns.add(mapCourierColumn(courierSymbol));
		columns.add(mapMappedStatus(csvLine));
		columns.add(mapStatus(csvLine));

		return new LiquibaseInsert(tableName, columns);
	}

	Column mapCourierColumn(String courierSymbol);

	Column mapMappedStatus(String[] csvLine);

	Column mapStatus(String[] csvLine);
}
