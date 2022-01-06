package fr.younup.coding_challenge.services;

import fr.younup.coding_challenge.models.Album;
import fr.younup.coding_challenge.repository.AlbumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@Service
@Transactional
@Slf4j
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    public void deleteAll() {
        albumRepository.deleteAll();
    }

    public void setMocks() {

        List<Album> albumList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Album album = Album.builder().referenceId("ref_" + i).tag("tag_1"+i).liked(false).build();
            albumList.add(album);
        }

        if (albumRepository.findAll().isEmpty()) {
            albumRepository.saveAll(new LinkedHashSet<>(albumList));
        }
    }

}

