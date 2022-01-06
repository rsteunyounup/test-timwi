package fr.younup.coding_challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @ToString.Exclude
    private Set<UserAlbum> albumUsers;

}
