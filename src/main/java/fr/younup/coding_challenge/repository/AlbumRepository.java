package fr.younup.coding_challenge.repository;

import fr.younup.coding_challenge.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query(value = "select a.reference_id as referenceId, u.tag as tag from album a left join useralbum u on a.album_id = u.album_id where user_id=:id", nativeQuery = true)
    List<AlbumJpaDto> findAllAlbumsByUser(@Param("id") Integer userId);
}
