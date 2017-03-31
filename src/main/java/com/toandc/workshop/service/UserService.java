package com.toandc.workshop.service;

import com.toandc.workshop.dto.UserDTO;
import com.toandc.workshop.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by toandc on 3/31/17.
 */
public interface UserService {

    List<User> findByFullName(String fullName);

    /**
     * Creates a new person.
     * @param created   The information of the created person.
     * @return  The created person.
     */
    User create(UserDTO created);


    /**
     * Deletes a person.
     * @param personId  The id of the deleted person.
     * @return  The deleted person.
     * @throws PersonNotFoundException  if no person is found with the given id.
     */
    User delete(int userId);

    /**
     * Finds all persons.
     * @return  A list of persons.
     */
    List<User> findAll();

    /**
     * Finds person by id.
     * @param userId    The id of the wanted person.
     * @return  The found person. If no person is found, this method returns null.
     */
    User findById(int userId);

    /**
     * Updates the information of a person.
     * @param updated   The information of the updated person.
     * @return  The updated person.
     * @throws PersonNotFoundException  if no person is found with given id.
     */
    User update(UserDTO updated);
}
