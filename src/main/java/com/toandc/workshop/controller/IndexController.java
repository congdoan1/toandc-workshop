package com.toandc.workshop.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by toanqri on 4/1/17.
 */
@RestController
@RequestMapping(value = "/")
public class IndexController implements ErrorController {

    public static final String ERROR_PATH = "/error";

    public String home() {
        return "Toan DC";
    }

    @RequestMapping(value = "error", method = RequestMethod.GET)
    public String error() {
        return "ERROR";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
