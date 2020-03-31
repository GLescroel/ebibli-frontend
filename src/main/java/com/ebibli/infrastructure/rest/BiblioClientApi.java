package com.ebibli.infrastructure.rest;

import com.ebibli.dto.BibliothequeDto;
import com.ebibli.dto.LivreDto;
import com.ebibli.dto.OuvrageDto;
import com.ebibli.dto.UtilisateurDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "biblio-services",
        url = "${clients.com-ebibli-v1-vs.endpoint}")
public interface BiblioClientApi {

    @GetMapping(value = "/utilisateur/{email}")
    UtilisateurDto getUtilisateurByEmail(@PathVariable("email") String email);

    @PostMapping(value = "/utilisateur/creation")
    void save(@RequestBody UtilisateurDto utilisateur);

    @PostMapping(value = "/utilisateur/suppression")
    void delete(@RequestBody UtilisateurDto utilisateur);

    @GetMapping(value = "/emprunts/{id}")
    List<LivreDto> getEmpruntsByUtilisateur(@PathVariable("id") Integer userId);

    @GetMapping(value = "/bibliotheques")
    List<BibliothequeDto> getAllBibliotheques();

    @GetMapping(value = "/bibliotheque/{id}")
    BibliothequeDto getBibliotheque(@PathVariable("id") Integer bibliothequeId);

    @GetMapping(value = "/ouvrages")
    List<OuvrageDto> getAllOuvrages();

    @GetMapping(value = "/livres/{bibliothequeId}")
    List<LivreDto> getLivresByBibliotheque(@PathVariable("bibliothequeId") Integer bibliothequeId);

    @PostMapping(value = "/prolongation/{livreId}")
    LivreDto upgradePret(@PathVariable("livreId") Integer livreId);
}
