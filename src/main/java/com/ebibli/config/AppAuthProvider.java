package com.ebibli.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

public class AppAuthProvider extends DaoAuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppAuthProvider.class);


}