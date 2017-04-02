package com.toandc.workshop.repository;

import com.toandc.workshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by toandc on 3/31/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByFullName(@Param("fullName") String fullName);
}
