package com.jit.team.csv_to_liquibase_converter.boundary;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

@Service
@Slf4j
public class StringToTxtFileWriter {

	public void writeStringToFile(String fileContent, String filePath) throws IOException {
		final File file = new File(filePath);
		log.info("created file: {}, ", file.getAbsolutePath());
		FileUtils.writeStringToFile(file, fileContent, "UTF-8");
	}
}
