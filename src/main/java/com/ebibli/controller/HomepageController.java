package com.ebibli.controller;

import com.ebibli.dto.BibliothequeDto;
import com.ebibli.service.BibliothequeService;
import com.ebibli.service.LivreService;
import com.ebibli.service.OuvrageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomepageController.class);
    private static final BibliothequeDto DEFAULT_BIBLIOTHEQUE = new BibliothequeDto().builder().id(0).nom("Sélectionner une bibliothèque").build();

    @Autowired
    private BibliothequeService bibliothequeService;
    @Autowired
    private OuvrageService ouvrageService;
    @Autowired
    private LivreService livreService;

    @Value("${clients.com-ebibli-v1-vs.endpoint}")
    private String host;

    @GetMapping(value = "/")
    public ModelAndView viewHomepage() {
        LOGGER.info("HomepageController -- viewHomepage");

        ModelAndView modelAndview = new ModelAndView("homepage");
        modelAndview.addObject("bibliotheques", bibliothequeService.getAllBibliotheques());
        modelAndview.addObject("bibliothequeSelectionnee", DEFAULT_BIBLIOTHEQUE);
        modelAndview.addObject("ouvrages", ouvrageService.getAllOuvrages());
        modelAndview.addObject("urlBackend", host+"/");

        return modelAndview;
    }

    @GetMapping(value = "/Bibliotheque/{bibliothequeId}")
    public ModelAndView viewBibliotheque(@PathVariable(name = "bibliothequeId") Integer bibliothequeId) {
        LOGGER.info("HomepageController -- updateHomePage");

        ModelAndView modelAndview = new ModelAndView("homepage");
        modelAndview.addObject("bibliotheques", bibliothequeService.getAllBibliotheques());
        modelAndview.addObject("bibliothequeSelectionnee", bibliothequeService.getBibliotheque(bibliothequeId));
        modelAndview.addObject("livres", livreService.getAllLivresByBibliotheque(bibliothequeId));
        modelAndview.addObject("urlBackend", host+"/");

        return modelAndview;
    }
}
