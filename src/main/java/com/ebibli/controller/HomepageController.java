package com.ebibli.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomepageController.class);

    @GetMapping(value = "/")
    public String viewHomepage() {
        LOGGER.info("HomepageController -- viwHomepage");
        return "homepage";
    }
}
