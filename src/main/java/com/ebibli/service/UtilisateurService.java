package com.ebibli.service;

import com.ebibli.domain.BiblioClients;
import com.ebibli.dto.UtilisateurDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UtilisateurService implements UserDetailsService {

    private final BiblioClients biblioClients;

    public UtilisateurService(BiblioClients biblioClients) {
        this.biblioClients = biblioClients;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Objects.requireNonNull(email);
        return getUtilisateurByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public Optional<UtilisateurDto> getUtilisateurByEmail(String email) {
        return Optional.ofNullable(findUtilisateurByEmail(email));
    }

    public UtilisateurDto findUtilisateurByEmail(String email) {
        return biblioClients.getCustomerByEmail(email);
    }


    public void save(UtilisateurDto utilisateur) {
        biblioClients.save(utilisateur);
    }

    public void remove(UtilisateurDto utilisateur) {
        biblioClients.delete(utilisateur);
    }
}
