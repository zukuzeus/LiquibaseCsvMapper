package com.jit.team.csv_to_liquibase_converter.entity;

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
@XmlRootElement(name = "column")
@XmlAccessorType(XmlAccessType.FIELD)
public class Column {

	@XmlAttribute(name = "name")
	String name;

	@XmlAttribute(name = "value")
	String value;

}
