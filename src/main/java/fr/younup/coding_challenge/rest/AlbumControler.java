package fr.younup.coding_challenge.rest;

import fr.younup.coding_challenge.models.Album;
import fr.younup.coding_challenge.models.User;
import fr.younup.coding_challenge.repository.AlbumRepository;
import fr.younup.coding_challenge.repository.UserRepository;
import fr.younup.coding_challenge.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
@Slf4j
@CrossOrigin
public class AlbumControler {


    @Autowired
    AlbumService albumService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/api/set",
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
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(albumList);
    }

    @GetMapping(value = "/api/all",
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

    @DeleteMapping(value = "/api/all",
            produces = "application/json")
    public ResponseEntity<List<Album>> deleteAll() {

        log.debug("delete des albums");

        try {
            albumService.deleteAlbums();
        } catch (Exception e) {
            // 500 : Pour toute exception
            log.error("erreur : ",e);
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ArrayList<>());
    }
}
