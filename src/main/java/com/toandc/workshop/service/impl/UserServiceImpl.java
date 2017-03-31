package com.toandc.workshop.service.impl;

import com.toandc.workshop.dto.UserDTO;
import com.toandc.workshop.entity.User;
import com.toandc.workshop.repository.UserRepository;
import com.toandc.workshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by toandc on 3/31/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository repository;


    @Override
    public List<User> findByFullName(String fullName) {
        return repository.findByFullName(fullName);
    }

    @Override
    public User create(UserDTO created) {
        User user = new User(created.getFullName(), created.getAddress(), created.getPhone(), created.getNote());
        return repository.save(user);
    }

    @Override
    public User delete(int userId) {
        User deleted = repository.findOne(userId);
        repository.delete(userId);
        return deleted;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(int userId) {
        return repository.findOne(userId);
    }

    @Override
    public User update(UserDTO updated) {
        User user = new User(updated.getFullName(), updated.getAddress(), updated.getPhone(), updated.getNote());
        return repository.save(user);
    }
}
