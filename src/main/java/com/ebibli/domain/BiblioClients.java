package com.ebibli.domain;

import com.ebibli.dto.BibliothequeDto;
import com.ebibli.dto.LivreDto;
import com.ebibli.dto.OuvrageDto;
import com.ebibli.dto.UtilisateurDto;

import java.util.List;

public interface BiblioClients {

    UtilisateurDto getCustomerByEmail(String email);

    void save(UtilisateurDto utilisateur);

    void delete(UtilisateurDto utilisateur);

    List<LivreDto> findEmpruntsByUtilisateur(Integer userid);

    List<BibliothequeDto> getAllBibliotheques();

    BibliothequeDto getBibliotheque(Integer bibliothequeId);

    List<OuvrageDto> getAllOuvrages();

    List<LivreDto> getAllLivresByBibliotheque(Integer bibliothequeId);
}
