package org.jaboumal.hoenggermeisterschaft.service;

import org.jaboumal.hoenggermeisterschaft.model.enums.Verein;
import org.jaboumal.hoenggermeisterschaft.model.dto.QualificationListDTO;
import org.jaboumal.hoenggermeisterschaft.model.dto.QualifikationAddDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling qualification data operations.
 * Provides methods for saving and retrieving qualification data from a CSV file.
 */
public class QualificationsService {

    private static final Logger logger = LoggerFactory.getLogger(QualificationsService.class);
    private static final String SEMI_COLON = ";";
    private final FileService fileService;
    private static final String CSV_PATH = "HoenggerMeisterschaftQuali.csv";

    /**
     * Constructs a new QualificationsService with a new FileService instance.
     */
    public QualificationsService() {
        this.fileService = new FileService();
    }

    /**
     * Saves qualification data to a CSV file.
     * 
     * @param qualifikationAddDTO the qualification data to be saved
     * @return true if the data was saved successfully, false otherwise
     */
    public boolean saveQualifications(QualifikationAddDTO qualifikationAddDTO) {
        logger.info("Saving qualification: {}", qualifikationAddDTO);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(qualifikationAddDTO.getName()).append(SEMI_COLON);
        stringBuilder.append(qualifikationAddDTO.getVorname()).append(SEMI_COLON);
        stringBuilder.append(qualifikationAddDTO.getJahrgang()).append(SEMI_COLON);
        stringBuilder.append(qualifikationAddDTO.getVerein()).append(SEMI_COLON);
        stringBuilder.append(qualifikationAddDTO.getKategorie().name()).append(SEMI_COLON);
        for (Integer schuss : qualifikationAddDTO.getSchussListe()) {
            stringBuilder.append(schuss).append(SEMI_COLON);
        }

        String data = stringBuilder.toString();

        boolean result = fileService.writeToCSV(data, CSV_PATH);
        if (result) {
            logger.info("Qualification saved to CSV successfully");
        } else {
            logger.error("Failed to save qualification to CSV");
        }
        return result;
    }

    /**
     * Retrieves all qualification data from the CSV file.
     * 
     * @return a list of QualificationListDTO objects containing all qualification data
     */
    public List<QualificationListDTO> getAllQualifications() {
        logger.info("Fetching all qualifications from CSV");
        String csvData = fileService.readFromCSV(CSV_PATH);
        List<QualificationListDTO> qualificationListDTO = new ArrayList<>();
        if (csvData.isEmpty()) {
            logger.warn("CSV data is empty");
            return qualificationListDTO;
        }

        String[] lines = csvData.split(System.lineSeparator());

        for (String line : lines) {
            String[] parts = line.split(SEMI_COLON);
            QualificationListDTO dto = new QualificationListDTO();
            dto.setName(parts[0]);
            dto.setVorname(parts[1]);
            dto.setJahrgang(Integer.parseInt(parts[2]));
            dto.setVerein(Verein.fromKuerzel(parts[3]).name());
            dto.setVereinName(Verein.fromKuerzel(parts[3]).getFullName());
            dto.setKategorie(parts[4]);
            List<Integer> schussListe = new ArrayList<>();
            int totalScore = 0;
            for (int i = 5; i < parts.length; i++) {
                totalScore += Integer.parseInt(parts[i]);
                schussListe.add(Integer.parseInt(parts[i]));
            }
            dto.setSchussListe(schussListe);
            dto.setTotalScore(totalScore);
            qualificationListDTO.add(dto);
        }
        return qualificationListDTO;
    }
}
