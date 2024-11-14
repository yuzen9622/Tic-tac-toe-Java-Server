package com.seroter.azure_basic_app.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT s FROM User s WHERE s.email=?1")
	Optional<User> findUserByEmail(String email);

	@Query("SELECT s FROM User s WHERE s.name=?1")
	Optional<User> findUserByName(String name);

	@Query("SELECT s FROM User s WHERE s.email=?1 AND s.password=?2")
	Optional<User> login(String email, String password);
}