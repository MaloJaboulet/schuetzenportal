package org.jaboumal.schuetzenportal.controller;

import org.jaboumal.schuetzenportal.model.enums.Kategorie;
import org.jaboumal.schuetzenportal.model.enums.Verein;
import org.jaboumal.schuetzenportal.model.dto.QualificationListDTO;
import org.jaboumal.schuetzenportal.model.dto.QualifikationAddDTO;
import org.jaboumal.schuetzenportal.service.QualificationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Web controller for handling Thymeleaf views and form submissions.
 * Provides endpoints for displaying the data entry form and results page.
 */
@Controller
@RequestMapping("/hoengger/")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    private final QualificationsService qualificationsService;

    /**
     * Constructs a new WebController with a new QualificationsService instance.
     */
    public WebController() {
        this.qualificationsService = new QualificationsService();
    }

    /**
     * Displays the data entry form.
     * 
     * @param model the Spring MVC model to add attributes to
     * @return the view name for the form page
     */
    @GetMapping("/")
    public String showForm(Model model) {
        logger.info("GET / - Showing form");
        if (!model.containsAttribute("qualifikationAddDTO")) {
            model.addAttribute("qualifikationAddDTO", new QualifikationAddDTO());
        }

        // Add enum values to the model for dropdowns
        model.addAttribute("vereinOptions", Verein.values());
        model.addAttribute("kategorieOptions", Kategorie.values());

        // Add current page for navigation highlighting
        model.addAttribute("currentPage", "/hoengger/");

        return "hoengger/hoenggermeisterschaft";
    }

    /**
     * Handles the form submission for saving qualification data.
     * 
     * @param qualifikationAddDTO the qualification data from the form
     * @param redirectAttributes attributes to be added to the redirect
     * @return a redirect to the form page
     */
    @PostMapping("/save")
    public String saveQualifikation(@ModelAttribute QualifikationAddDTO qualifikationAddDTO,
                                   RedirectAttributes redirectAttributes) {
        logger.info("POST /save - Saving qualification: {}", qualifikationAddDTO);
        boolean isDataSaved = qualificationsService.saveQualifications(qualifikationAddDTO);

        if (isDataSaved) {
            logger.info("Qualification saved successfully");
            redirectAttributes.addFlashAttribute("success", true);
        } else {
            logger.error("Failed to save qualification");
            redirectAttributes.addFlashAttribute("error", true);
        }

        // Add a new DTO and the enum values for the form
        redirectAttributes.addFlashAttribute("qualifikationAddDTO", new QualifikationAddDTO());
        redirectAttributes.addFlashAttribute("vereinOptions", Verein.values());
        redirectAttributes.addFlashAttribute("kategorieOptions", Kategorie.values());

        // Add current page for navigation highlighting
        redirectAttributes.addFlashAttribute("currentPage", "/hoengger/");

        return "redirect:/hoengger/";
    }

    /**
     * Displays the results page showing all qualification data.
     * 
     * @param model the Spring MVC model to add attributes to
     * @return the view name for the results page
     */
    @GetMapping("/results")
    public String showResults(Model model) {
        List<QualificationListDTO> qualifikationen = qualificationsService.getAllQualifications();
        model.addAttribute("qualifikationen", qualifikationen);

        // Add current page for navigation highlighting
        model.addAttribute("currentPage", "/hoengger/results");

        return "hoengger/results-page";
    }
}
