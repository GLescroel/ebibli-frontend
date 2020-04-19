package com.ebibli.service;

import com.ebibli.domain.OuvrageClient;
import com.ebibli.dto.BibliothequeDto;
import com.ebibli.dto.Disponibilite;
import com.ebibli.dto.LivreDto;
import com.ebibli.dto.OuvrageDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OuvrageService {

    private final OuvrageClient ouvrageClient;
    private final LivreService livreService;

    public OuvrageService(OuvrageClient ouvrageClient, LivreService livreService) {
        this.ouvrageClient = ouvrageClient;
        this.livreService = livreService;
    }

    public List<OuvrageDto> getAllOuvrages() {
        List<OuvrageDto> ouvrages = ouvrageClient.getAllOuvrages();
        return setDisponibilités(ouvrages);
    }

    private List<OuvrageDto> setDisponibilités(List<OuvrageDto> ouvrages) {
        for (OuvrageDto ouvrage : ouvrages) {
            ouvrage.setDisponibilite(getOuvrageDispo(ouvrage.getId()));
        }
        return ouvrages;
    }

    private List<Disponibilite> getOuvrageDispo(Integer ouvrageId) {
        List<Disponibilite> disponibilites = new ArrayList<>();
        List<LivreDto> livres = livreService.getDispoByOuvrage(ouvrageId);
        HashMap<BibliothequeDto, Integer> disponibilitesMap = new HashMap<BibliothequeDto, Integer>();
        for (LivreDto livre : livres) {
            if (disponibilitesMap.get(livre.getBibliotheque()) != null) {
                disponibilitesMap.put(livre.getBibliotheque(), disponibilitesMap.get(livre.getBibliotheque()) + 1);
            } else {
                disponibilitesMap.put(livre.getBibliotheque(), 1);
            }
        }
        for (BibliothequeDto bibli : disponibilitesMap.keySet()) {
            Disponibilite disponibilite = new Disponibilite();
            disponibilite.setBibliotheque(bibli);
            disponibilite.setDispo(disponibilitesMap.get(bibli));
            disponibilites.add(disponibilite);
        }
        return disponibilites;
    }

    public List<OuvrageDto> filterOuvrages(String recherche) {
        List<OuvrageDto> ouvrages = ouvrageClient.filterOuvrages(recherche);
        return setDisponibilités(ouvrages);
    }
}
