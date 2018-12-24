package com.jit.team.csv_to_liquibase_converter.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "insert")
@XmlAccessorType(XmlAccessType.FIELD)
public class LiquibaseInsert {

	@XmlAttribute
	private String tableName;

	private List<Column> column = new ArrayList<>();
}
