package com.shreeganeshfinance.creditapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.shreeganeshfinance.creditapplication.pojo.User;


import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    public Optional<User> findByUsername(String username);
}
