package fr.younup.coding_challenge;

import fr.younup.coding_challenge.models.Album;
import fr.younup.coding_challenge.models.User;
import fr.younup.coding_challenge.repository.AlbumRepository;
import fr.younup.coding_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingChallengeApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AlbumRepository albumRepository;


	public static void main(String[] args) {
		SpringApplication.run(CodingChallengeApplication.class, args);
	}

}
