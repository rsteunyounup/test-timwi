package fr.younup.coding_challenge.repository;

import fr.younup.coding_challenge.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}