package fr.younup.coding_challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ALBUM")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue
    @Column(name = "ALBUM_ID")
    private Integer id;

    @Column
    private String referenceId;

    @OneToMany(mappedBy = "album")
    @JsonIgnore
    @ToString.Exclude
    private Set<UserAlbum> albumUsers;

}

