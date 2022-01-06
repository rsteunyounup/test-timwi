package fr.younup.coding_challenge.rest;

import fr.younup.coding_challenge.exception.ResourceNotFoundException;
import fr.younup.coding_challenge.models.Album;
import fr.younup.coding_challenge.repository.AlbumRepository;
import fr.younup.coding_challenge.repository.UserRepository;
import fr.younup.coding_challenge.services.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AlbumControler {


    @Autowired
    AlbumService albumService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @PostMapping("/albums")
    public Album createAlbum(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Integer id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Album not exist with id :" + id));
        return ResponseEntity.ok(album);
    }

    /**
     * Update album rest api
     *
     * @param id           l'id de l'album
     * @param albumDetails : le nouvel album
     * @return {@link ResponseEntity}
     */
    @PutMapping("/albums/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Integer id, @RequestBody Album albumDetails) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Album not exist with id :" + id));

        album.setReferenceId(albumDetails.getReferenceId());

        Album updatedAlbum = albumRepository.save(album);
        return ResponseEntity.ok(updatedAlbum);
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAlbum(@PathVariable Integer id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Album not exist with id :" + id));

        albumRepository.delete(album);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "/set",
            produces = "application/json")
    public ResponseEntity<List<Album>> setMocks() {

        log.debug("récupération de tous les albums");

        List<Album> albumList;

        try {
            albumService.setMocks();
            albumList = albumService.getAll();
        } catch (Exception e) {
            // 500 : Pour toute exception
            String errorMessage = "Une erreur interne est survenue lors de la récupération des albums";
            log.error(errorMessage + "{}", e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
        return ResponseEntity.ok(albumList);
    }

    @GetMapping(value = "/all",
            produces = "application/json")
    public ResponseEntity<List<Album>> getAll() {

        log.debug("récupération de tous les albums");

        List<Album> albumList;

        try {
            albumList = albumService.getAll();
        } catch (Exception e) {
            // 500 : Pour toute exception
            String errorMessage = "Une erreur interne est survenue lors de la récupération des albums";
            log.error(errorMessage + "{}", e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(albumList);
    }

    @DeleteMapping(value = "/delete",
            produces = "application/json")
    public ResponseEntity<List<Album>> deleteAll() {

        log.debug("delete des albums");

        try {
            userRepository.deleteAll();
            albumService.deleteAll();
        } catch (Exception e) {
            // 500 : Pour toute exception
            log.error("erreur : ", e);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ArrayList<>());
    }
}
