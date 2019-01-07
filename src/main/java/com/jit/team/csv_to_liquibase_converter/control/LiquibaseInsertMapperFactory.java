package com.jit.team.csv_to_liquibase_converter.control;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LiquibaseInsertMapperFactory {

	private RupostInsertChangeSetMapper rupostInsertChangeSetMapper;
	private CDEKInsertChangeSetMapper cdekInsertChangeSetMapper;

	public LiquibaseInsertMapper getCourierMapper(String courierSymbol) {
		switch (courierSymbol) {
			case "POST_RU":
				return rupostInsertChangeSetMapper;
			case "CDEK":
				return cdekInsertChangeSetMapper;
			case "DPD_UK":
				throw new IllegalArgumentException("DPD UK not implemented yet - implement LiquibaseInsertMapper and create bean with its type");
			default:
				throw new IllegalArgumentException(String.format("No implementation available for given courier symbol: %s", courierSymbol));
		}
	}
}
