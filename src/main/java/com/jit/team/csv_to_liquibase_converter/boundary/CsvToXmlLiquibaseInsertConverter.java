package com.jit.team.csv_to_liquibase_converter.boundary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jit.team.csv_to_liquibase_converter.control.LiquibaseInsertMapperFactory;
import com.jit.team.csv_to_liquibase_converter.entity.ChangeSet;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Service
@AllArgsConstructor
public class CsvToXmlLiquibaseInsertConverter {

	private ObjectMapper objectMapper;

	private LiquibaseInsertMapperFactory liquibaseInsertMapperFactory;

	public String convertCsvFileToXml(String csvFilePath, String courierSymbol, String tableName) throws IOException {
		final CSVReader csvReader = buildCsvReader(csvFilePath);

		final List<String[]> lines = csvReader.readAll();

		final ChangeSet changeSetObject = lines.stream()
				.map(csvLineArray -> liquibaseInsertMapperFactory.getCourierMapper(courierSymbol)
						.mapCsvLineOntoLiquibaseInsert(csvLineArray, courierSymbol, tableName))
				.collect(
						ChangeSet::new,
						(changeSet, liquibaseInsert) -> changeSet.getInsert().add(liquibaseInsert),
						(changeSet, changeSet2) -> changeSet.getInsert().addAll(changeSet2.getInsert())
				);

		final String valueAsString = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(changeSetObject);
		return StringUtils.LF + valueAsString;
	}

	private CSVReader buildCsvReader(String filePath) throws FileNotFoundException {
		return new CSVReaderBuilder(new FileReader(filePath))
				.withSkipLines(1)
				.withCSVParser(buildCsvParser())
				.build();
	}

	private CSVParser buildCsvParser() {
		return new CSVParserBuilder()
				.withSeparator(';')
				.build();
	}

}
