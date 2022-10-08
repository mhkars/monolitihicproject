package com.halit.monolitihicproject.repository;

import com.halit.monolitihicproject.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findOptionalByEmailAndPassword(String email, String password);


    Optional<User> findOptionalById(Long id);
}
