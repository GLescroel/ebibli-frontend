package com.ebibli.service;

import com.ebibli.domain.OuvrageClient;
import com.ebibli.dto.OuvrageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OuvrageService {

    private final OuvrageClient ouvrageClient;

    public OuvrageService(OuvrageClient ouvrageClient) {
        this.ouvrageClient = ouvrageClient;
    }

    public List<OuvrageDto> getAllOuvrages() {
        return ouvrageClient.getAllOuvrages();
    }

    public List<OuvrageDto> filterOuvrages(String recherche) {
        return ouvrageClient.filterOuvrages(recherche);
    }
}
