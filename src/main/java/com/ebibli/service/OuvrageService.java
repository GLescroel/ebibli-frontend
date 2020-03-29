package com.ebibli.service;

import com.ebibli.domain.BiblioClients;
import com.ebibli.dto.OuvrageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OuvrageService {

    private final BiblioClients biblioClients;

    public OuvrageService(BiblioClients biblioClients) {
        this.biblioClients = biblioClients;
    }

    public List<OuvrageDto> getAllOuvrages() {
        return biblioClients.getAllOuvrages();
    }
}
