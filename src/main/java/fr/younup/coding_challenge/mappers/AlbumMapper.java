package fr.younup.coding_challenge.mappers;

import fr.younup.coding_challenge.models.Album;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumMapper {

    AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);


    AlbumDto albumToAlbumDto(Album album);

    Album albumDtoToAlbum(AlbumDto albumDto);

}
