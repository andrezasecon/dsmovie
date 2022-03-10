package com.andrezasecon.dsmovie.repositories;

import com.andrezasecon.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
