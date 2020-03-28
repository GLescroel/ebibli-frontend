package com.ebibli.domain;

import com.ebibli.dto.LivreDto;
import com.ebibli.dto.UtilisateurDto;

import java.util.List;

public interface BiblioClients {

    UtilisateurDto getCustomerByEmail(String email);

    void save(UtilisateurDto utilisateur);

    void delete(UtilisateurDto utilisateur);

    List<LivreDto> findEmpruntsByUtilisateur(Integer userid);
}
