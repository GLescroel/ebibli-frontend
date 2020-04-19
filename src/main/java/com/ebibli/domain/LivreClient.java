package com.ebibli.domain;

import com.ebibli.dto.LivreDto;

import java.util.List;

public interface LivreClient {

    LivreDto getLivreById(Integer livreId);

    List<LivreDto> getAllLivresByBibliotheque(Integer bibliothequeId);

    List<LivreDto> getDispoByOuvrage(Integer ouvrageId);
}
