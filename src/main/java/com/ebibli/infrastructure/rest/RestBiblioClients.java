package com.ebibli.infrastructure.rest;

import com.ebibli.domain.BiblioClients;
import com.ebibli.dto.LivreDto;
import com.ebibli.dto.UtilisateurDto;

import java.util.List;

public class RestBiblioClients implements BiblioClients {

    private final BiblioClientApi biblioClientApi;

    public RestBiblioClients(BiblioClientApi biblioClientApi) {
        this.biblioClientApi = biblioClientApi;
    }

    @Override
    public UtilisateurDto getCustomerByEmail(String email) {
        return biblioClientApi.getUtilisateurByEmail(email);
    }

    @Override
    public void save(UtilisateurDto utilisateur) {
        biblioClientApi.save(utilisateur);
    }

    @Override
    public void delete(UtilisateurDto utilisateur) {
        biblioClientApi.delete(utilisateur);
    }

    @Override
    public List<LivreDto> findEmpruntsByUtilisateur(Integer userid) {
        return biblioClientApi.getEmpruntsByUtilisateur(userid);
    }


}
