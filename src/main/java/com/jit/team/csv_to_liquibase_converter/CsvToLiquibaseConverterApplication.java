package com.jit.team.csv_to_liquibase_converter;

import java.io.File;
import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jit.team.csv_to_liquibase_converter.boundary.CsvToXmlLiquibaseInsertConverter;
import com.jit.team.csv_to_liquibase_converter.boundary.StringToTxtFileWriter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
public class CsvToLiquibaseConverterApplication implements ApplicationRunner {

	private static final String INPUT_CSV_FILE_ARGUMENT_NAME = "inputCsvFile";
	private static final String INPUT_COURIER_SYMBOL_ARGUMENT_NAME = "courierSymbol";
	private static final String OUTPUT_TXT_FILE_ARGUMENT_NAME = "outputFile";
	private static final String TABLE_NAME = "StatusMapping";

	private final CsvToXmlLiquibaseInsertConverter csvToXmlLiquibaseInsertConverter;

	private final StringToTxtFileWriter stringToTxtFileWriter;

	public static void main(String[] args) {
		SpringApplication.run(CsvToLiquibaseConverterApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));

		String xml = StringUtils.EMPTY;
		if (validateCommandLineArgumentExists(args, INPUT_CSV_FILE_ARGUMENT_NAME) && validateCommandLineArgumentExists(args, INPUT_COURIER_SYMBOL_ARGUMENT_NAME)) {
			final String courierSymbol = getOptionValue(args, INPUT_COURIER_SYMBOL_ARGUMENT_NAME);
			final String csvFilePath = getOptionValue(args, INPUT_CSV_FILE_ARGUMENT_NAME);
			xml = csvToXmlLiquibaseInsertConverter.convertCsvFileToXml(csvFilePath, courierSymbol, TABLE_NAME);
			log.info(xml);
		} else {
			log.warn("lack of --{}=courierPath or --{}=courierSymbol arguments", INPUT_CSV_FILE_ARGUMENT_NAME, INPUT_COURIER_SYMBOL_ARGUMENT_NAME);
		}
		if (validateCommandLineArgumentExists(args, OUTPUT_TXT_FILE_ARGUMENT_NAME)) {
			stringToTxtFileWriter.writeStringToFile(xml, getOptionValue(args, OUTPUT_TXT_FILE_ARGUMENT_NAME));
		}
	}

	private boolean validateCommandLineArgumentExists(ApplicationArguments args, String optionName) {
		return args.containsOption(optionName);
	}

	private String getOptionValue(ApplicationArguments args, String optionName) {
		return args.getOptionValues(optionName).get(0);
	}

}
