package org.jaboumal.hoenggermeisterschaft.service;


import org.jaboumal.hoenggermeisterschaft.model.dto.CompetitorDTO;
import org.jaboumal.hoenggermeisterschaft.util.DateUtil;
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
        String registrationData = DateUtil.now() + SEMI_COLON+
                lizenzNummer + SEMI_COLON +
                competitorDTO.getVorname() + SEMI_COLON +
                competitorDTO.getName() + SEMI_COLON +
                competitorDTO.getJahrgang() + SEMI_COLON +
                competitorDTO.isGuest() + SEMI_COLON +
                competitorDTO.isEssen();


        boolean result = fileService.writeToCSV(registrationData, CSV_PATH);
        if (result) {
            logger.info("Registration saved to CSV successfully");
        } else {
            logger.error("Failed to save registration to CSV");
        }
        return result;
    }
}
