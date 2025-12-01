package org.jaboumal.schuetzenportal.service;


import org.jaboumal.schuetzenportal.model.dto.CompetitorDTO;
import org.jaboumal.schuetzenportal.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegistrationsService {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationsService.class);
    private static final String SEMI_COLON = ";";
    private final FileService fileService;
    private static final String CSV_PATH = "BerchtoldAnmeldung.csv";


    public RegistrationsService() {
        this.fileService = new FileService();
    }

    public boolean saveRegistration(CompetitorDTO competitorDTO) {

        int lizenzNummer = competitorDTO.getLizenzNummer() == null ? 9999999 : competitorDTO.getLizenzNummer();

        String berchtoldField;
        if (competitorDTO.getBerchtoldSelections() != null && !competitorDTO.getBerchtoldSelections().isEmpty()) {
            berchtoldField = String.join("|", competitorDTO.getBerchtoldSelections());
        } else {
            berchtoldField = "No Selection";
        }

        StringBuilder row = new StringBuilder();
        row.append(DateUtil.now()).append(SEMI_COLON);
        row.append(lizenzNummer).append(SEMI_COLON);
        row.append(escapeCsv(competitorDTO.getVorname())).append(SEMI_COLON);
        row.append(escapeCsv(competitorDTO.getName())).append(SEMI_COLON);
        row.append(escapeCsv(competitorDTO.getJahrgang())).append(SEMI_COLON);
        row.append(competitorDTO.isGuest()).append(SEMI_COLON);
        row.append(escapeCsv(berchtoldField));

        String data = row.toString();

        boolean ok = fileService.writeToCSV(data, CSV_PATH);
        if (!ok) {
            logger.error("Failed to write registration to CSV");
            return false;
        }

        logger.info("Saved registration: {}", data);
        return true;
    }

    private String escapeCsv(String value) {
        if (value == null) return "";
        return value.replace("\n", " ").replace("\r", " ").replace(";", ",");
    }
}
