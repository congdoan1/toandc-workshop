package com.toandc.workshop.service.impl;

import com.toandc.workshop.dto.UserDTO;
import com.toandc.workshop.dto.UserInputDTO;
import com.toandc.workshop.entity.User;
import com.toandc.workshop.repository.UserRepository;
import com.toandc.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by toandc on 3/31/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<UserDTO> findByFullName(String fullName) {
        List<User> users = repository.findByFullName("%" + fullName + "%");
        if (users.size() <= 0) {
            return new ArrayList<>();
        }
        // Java 8
        return StreamSupport.stream(users.spliterator(), false).map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = repository.findAll();
        if (users.size() <= 0) {
            return new ArrayList<>();
        }
        // Java 8
        return StreamSupport.stream(users.spliterator(), false).map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(int userId) {
        User user = repository.findOne(userId);
        if (user == null) {
            return null;
        }
        return new UserDTO(user);
    }

    @Override
    public UserDTO create(UserInputDTO userInputDTO) {
        User user = repository.saveAndFlush(convertToEntity(userInputDTO));
        return new UserDTO(user);
    }

    @Override
    public UserDTO update(int userId, UserInputDTO userInputDTO) {
        User user = repository.findOne(userId);
        if (user == null) {
            return null;
        }
        user.setFullName(userInputDTO.getFullName());
        user.setAddress(userInputDTO.getAddress());
        user.setPhone(userInputDTO.getPhone());
        user.setNote(userInputDTO.getNote());
        return new UserDTO(repository.saveAndFlush(user));
    }

    @Override
    public void delete(int userId) {
        repository.delete(userId);
    }

    @Override
    public User convertToEntity(UserInputDTO userInputDTO) {
        User user = new User();
        user.setFullName(userInputDTO.getFullName());
        user.setAddress(userInputDTO.getAddress());
        user.setPhone(userInputDTO.getPhone());
        user.setNote(userInputDTO.getNote());
        return user;
    }
}
