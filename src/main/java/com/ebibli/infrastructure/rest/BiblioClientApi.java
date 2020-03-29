package com.ebibli.infrastructure.rest;

import com.ebibli.dto.BibliothequeDto;
import com.ebibli.dto.LivreDto;
import com.ebibli.dto.UtilisateurDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "biblio-services",
        url = "http://localhost:8081")
public interface BiblioClientApi {

    @GetMapping(value = "/Utilisateur/{email}")
    UtilisateurDto getUtilisateurByEmail(@PathVariable("email") String email);

    @PostMapping(value = "/Utilisateur/creation")
    void save(@RequestBody UtilisateurDto utilisateur);

    @PostMapping(value = "/Utilisateur/suppression")
    void delete(@RequestBody UtilisateurDto utilisateur);

    @GetMapping(value = "/Utilisateur/{id}/Emprunts")
    List<LivreDto> getEmpruntsByUtilisateur(@PathVariable("id") Integer userId);

    @GetMapping(value = "/Bibliotheques")
    List<BibliothequeDto> getAllBibliotheques();

    @GetMapping(value = "/Bibliotheque/{id}")
    BibliothequeDto getBibliotheque(@PathVariable("id") Integer bibliothequeId);
}
