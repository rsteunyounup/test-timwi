package fr.younup.coding_challenge.mappers;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserDto implements Serializable {
    private final String username;
    private final Set<AlbumDto> favoriteAlbums;
}
