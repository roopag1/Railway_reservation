package org.ey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<org.ey.dto.User, Long> {
	Optional<org.ey.dto.User> findByUsername(String username);
}