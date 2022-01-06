package fr.younup.coding_challenge.models;

import lombok.*;

import javax.persistence.*;

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

    @Column
    private String tag;

    @Column
    private Boolean liked;
}

