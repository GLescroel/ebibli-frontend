package com.ebibli.domain;

import com.ebibli.dto.UtilisateurDto;

public interface BiblioClients {

    UtilisateurDto getCustomerByEmail(String email);

    void save(UtilisateurDto utilisateur);

    void delete(UtilisateurDto utilisateur);
}
