package org.jaboumal.schuetzenportal.controller;

import org.jaboumal.schuetzenportal.model.dto.CompetitorDTO;
import org.jaboumal.schuetzenportal.service.RegistrationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/berchtold/")
public class WebControllerBerchtold {
    private static final Logger logger = LoggerFactory.getLogger(WebControllerBerchtold.class);
    private final RegistrationsService registrationsService;

    @Autowired
    public WebControllerBerchtold(RegistrationsService registrationsService) {
        this.registrationsService = registrationsService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        logger.info("GET /registrations/ - Showing form");
        if (!model.containsAttribute("competitor")) {
            model.addAttribute("competitorDTO", new CompetitorDTO());
        }

        // Add current page for navigation highlighting
        model.addAttribute("currentPage", "/berchtold/");

        return "berchtold/indexBerchtold";
    }

    @PostMapping("/save")
    public String saveRegistration(@ModelAttribute CompetitorDTO competitorDTO, RedirectAttributes redirectAttributes) {
        logger.info("POST /registrations/save - Saving registration: {}", competitorDTO);
        boolean isDataSaved = registrationsService.saveRegistration(competitorDTO);

        if (isDataSaved) {
            logger.info("Registration saved successfully");
            redirectAttributes.addFlashAttribute("success", true);
        } else {
            logger.error("Failed to save registration");
            redirectAttributes.addFlashAttribute("error", true);
        }

        redirectAttributes.addFlashAttribute("competitorDTO", new CompetitorDTO());
        // Add current page for navigation highlighting
        redirectAttributes.addFlashAttribute("currentPage", "/berchtold/");

        return "redirect:/berchtold/";
    }
}
