package fr.younup.coding_challenge.service;

import fr.younup.coding_challenge.models.Album;
import fr.younup.coding_challenge.models.User;
import fr.younup.coding_challenge.repository.AlbumRepository;
import fr.younup.coding_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

@Service
@Transactional
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    UserRepository userRepository;

    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    public void setMocks() {

        List<Album> albumList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            Album album = Album.builder().referenceId("ref_" + i).build();
            albumList.add(album);
        }

        albumRepository.saveAll(new LinkedHashSet<>(albumList));

        userRepository.save(User.builder().username("user_1").password("user_1").favoriteAlbums(new HashSet<>(albumList)).build());
    }

    public void deleteAlbums() {
        List<User> userList = userRepository.findAll();

        userList.forEach(user -> {
            user.setFavoriteAlbums(null);
            userRepository.save(user);
        });
    }

}

