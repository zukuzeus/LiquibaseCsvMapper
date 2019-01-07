package com.jit.team.csv_to_liquibase_converter.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "changeSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChangeSet {
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<LiquibaseInsert> insert = new ArrayList<>();
}
