package fr.younup.coding_challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USERALBUM")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class UserAlbum {

    @Id
    @Column(name = "USER_ALBUM_ID")
    private Integer id;

    @Column
    private String tag;

    @Column
    private boolean liked;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ALBUM_ID")
    private Album album;
}

