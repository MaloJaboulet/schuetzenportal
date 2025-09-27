package org.jaboumal.hoenggermeisterschaft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainWebContoller {

    @GetMapping("/")
    public String showIndex(Model model) {

        // Add current page for navigation highlighting
        model.addAttribute("currentPage", "/");
        return "indexMain";
    }
}
