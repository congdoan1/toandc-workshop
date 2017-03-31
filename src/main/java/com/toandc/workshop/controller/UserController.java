package com.toandc.workshop.controller;

import com.toandc.workshop.dto.UserDTO;
import com.toandc.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by toandc on 3/31/17.
 */
@RestController
public class UserController {

    protected static final String USER_LIST = "api/users";

    @Autowired
    UserService service;

    @RequestMapping(value = "/")
    @ResponseBody
    public String home() {
        return "ToanDC";
    }

//    @RequestMapping(value = USER_LIST, method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity list() {
//        List<UserDTO> users = service.findAll();
//        return users;
//    }
}
