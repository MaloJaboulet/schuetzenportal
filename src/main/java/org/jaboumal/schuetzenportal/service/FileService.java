package org.jaboumal.schuetzenportal.service;

import java.nio.file.Files;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for handling file operations.
 * Provides methods for reading from and writing to a CSV file.
 */
public class FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    /**
     * Writes data to the CSV file.
     * If the file does not exist, it will be created.
     * 
     * @param data the data to be written to the CSV file
     * @return true if the data was written successfully, false otherwise
     */
    public boolean writeToCSV(String data, String pathStr) {
        Path path = Path.of(pathStr);
        boolean newlyCreated = false;
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                newlyCreated = true;
                logger.info("CSV file created at {}", pathStr);
            } catch (Exception e) {
                logger.error("Failed to create CSV file", e);
            }
        }
        try {
            if (newlyCreated || Files.size(path) == 0) {
                String header = "Date;Lizenznummer;Vorname;Name;Jahrgang;Guest;Essen;BerchtoldSelections" + System.lineSeparator();
                Files.writeString(path, header, java.nio.file.StandardOpenOption.APPEND);
            }
            Files.writeString(path, data + System.lineSeparator(), java.nio.file.StandardOpenOption.APPEND);
            logger.info("Data written to CSV: {}", data);
        } catch (Exception e) {
            logger.error("Error writing to CSV file", e);
            return false;
        }
        return true;
    }

    /**
     * Reads data from the CSV file.
     * 
     * @return the content of the CSV file as a string, or an empty string if the file does not exist or an error occurs
     */
    public String readFromCSV(String pathStr) {
        Path path = Path.of(pathStr);
        if (!Files.exists(path)) {
            logger.warn("CSV file does not exist at {}", pathStr);
            return "";
        }
        try {
            String content = Files.readString(path);
            logger.info("Read data from CSV file");
            return content;
        } catch (Exception e) {
            logger.error("Error reading from CSV file", e);
            return "";
        }
    }
}
