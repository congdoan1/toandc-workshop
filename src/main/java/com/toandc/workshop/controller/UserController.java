package com.toandc.workshop.controller;

import com.toandc.workshop.dto.UserDTO;
import com.toandc.workshop.dto.UserInputDTO;
import com.toandc.workshop.exception.Error;
import com.toandc.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by toandc on 3/31/17.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    protected static final String USER = "/users";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity find(@RequestParam(name = "fullName", required = true) String fullName) {
        List<UserDTO> users = userService.findByFullName(fullName);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity list() {
        List<UserDTO> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "users/{userId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("userId") int userId) {
        UserDTO userDTO = userService.findById(userId);
        if (userDTO == null) {
            return new ResponseEntity<>(new Error(Error.USER_NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UserInputDTO userInputDTO) {
        UserDTO userDTO = userService.create(userInputDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "users/{userId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("userId") int userId, @RequestBody UserInputDTO userInputDTO) {
        UserDTO dto = userService.update(userId, userInputDTO);
        if (dto == null) {
            return new ResponseEntity<>(new Error(Error.USER_NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("userId") int userId) {
        UserDTO userDTO = userService.findById(userId);
        if (userDTO == null) {
            return new ResponseEntity<>(new Error(Error.USER_NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        userService.delete(userId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
