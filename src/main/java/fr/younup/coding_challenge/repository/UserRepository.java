package fr.younup.coding_challenge.repository;

import fr.younup.coding_challenge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}