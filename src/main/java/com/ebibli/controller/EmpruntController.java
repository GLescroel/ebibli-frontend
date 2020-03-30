package com.ebibli.controller;

import com.ebibli.dto.LivreDto;
import com.ebibli.service.LivreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpruntController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpruntController.class);

    @Autowired
    private LivreService livreService;

    @GetMapping(value = "/Utilisateur/{id}/mesEmprunts")
    public String viewEmpruntsPage(Model model, @PathVariable("id") Integer idUtilisateur) {
        LOGGER.info(">>>>> Dans EmpruntController - GetMapping");

        List<LivreDto> livres = livreService.findEmpruntsByUtilisateur(idUtilisateur);
        model.addAttribute("emprunts", livres);
        return "emprunt";
    }

    @PostMapping(value = "/prolongation/{id}")
    public String upgradePret(Model model, @PathVariable("id") Integer livreId) {
        LOGGER.info(">>>>> Dans EmpruntController - upgradePret");

        LivreDto livre = livreService.upgradePret(livreId);
        List<LivreDto> livres = livreService.findEmpruntsByUtilisateur(livre.getEmprunteur().getId());
        model.addAttribute("emprunts", livres);
        return "emprunt";
    }

}
