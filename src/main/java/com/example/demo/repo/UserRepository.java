package com.example.demo.repo;

import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    @Query
    public Optional<UserEntity> findByEmail(String email);
}
