package fr.younup.coding_challenge.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "_ALBUM")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String referenceId;

    @ManyToMany (mappedBy = "favoriteAlbums")
    @ToString.Exclude
    Set<User> users;
}

