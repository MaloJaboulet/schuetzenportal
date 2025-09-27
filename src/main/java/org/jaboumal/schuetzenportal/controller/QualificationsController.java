package org.jaboumal.schuetzenportal.controller;


import org.jaboumal.schuetzenportal.model.dto.QualificationListDTO;
import org.jaboumal.schuetzenportal.model.dto.QualifikationAddDTO;
import org.jaboumal.schuetzenportal.service.QualificationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST controller for handling qualification data operations.
 * Provides endpoints for retrieving and adding qualification records.
 */
@RestController
public class QualificationsController {

    private static final Logger logger = LoggerFactory.getLogger(QualificationsController.class);

    private final QualificationsService qualificationsService;

    /**
     * Constructs a new QualificationsController with a new QualificationsService instance.
     */
    public QualificationsController() {
        super();
        this.qualificationsService = new QualificationsService();
    }

    /**
     * Retrieves all qualification records.
     * 
     * @return ResponseEntity containing a list of QualificationListDTO objects
     *         with HTTP status 200 (OK)
     */
    @GetMapping("/qualifikationen/list")
    public ResponseEntity<List<QualificationListDTO>> getQualifications() {
        logger.info("GET /qualifikationen/list called");
        List<QualificationListDTO> qualificationListDTO = qualificationsService.getAllQualifications();
        logger.info("Returning {} qualifications", qualificationListDTO.size());
        return ResponseEntity.ok(qualificationListDTO);
    }

    /**
     * Adds a new qualification record.
     * 
     * @param qualifikationAddDTO the qualification data to be saved
     * @return ResponseEntity with a success or error message and appropriate HTTP status code
     *         (200 OK for success, 500 Internal Server Error for failure)
     */
    @PostMapping("/qualifikationen/add")
    public ResponseEntity<String> addQualifikation(@RequestBody QualifikationAddDTO qualifikationAddDTO) {
        logger.info("POST /qualifikationen/add called with: {}", qualifikationAddDTO);
        boolean isDataSaved = qualificationsService.saveQualifications(qualifikationAddDTO);
        if (!isDataSaved) {
            logger.error("Error saving qualification data");
            return ResponseEntity.status(500).body("Error saving data");
        }
        logger.info("Qualification data saved successfully");
        return ResponseEntity.ok("Data saved successfully");
    }
}
