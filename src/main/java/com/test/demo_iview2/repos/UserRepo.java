package com.test.demo_iview2.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo_iview2.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	Optional<User> findByUserName(String username);

}
