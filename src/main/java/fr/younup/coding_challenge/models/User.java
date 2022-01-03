package fr.younup.coding_challenge.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "_USER")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_album",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id"))
    @ToString.Exclude
    Set<Album> favoriteAlbums;

}
