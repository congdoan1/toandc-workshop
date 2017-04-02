package com.toandc.workshop.service;

import com.toandc.workshop.dto.UserDTO;
import com.toandc.workshop.dto.UserInputDTO;
import com.toandc.workshop.entity.User;

import java.util.List;

/**
 * Created by toandc on 3/31/17.
 */
public interface UserService {

    List<UserDTO> findByFullName(String fullName);

    List<UserDTO> findAll();

    UserDTO findById(int userId);

    UserDTO create(UserInputDTO userInputDTO);

    UserDTO update(int userId, UserInputDTO userInputDTO);

    void delete(int userId);

    User convertToEntity(UserInputDTO userDTO);
}
