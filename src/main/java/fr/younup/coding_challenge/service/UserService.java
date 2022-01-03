package fr.younup.coding_challenge.service;

import fr.younup.coding_challenge.models.Album;
import fr.younup.coding_challenge.models.User;
import fr.younup.coding_challenge.repository.AlbumRepository;
import fr.younup.coding_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

}

