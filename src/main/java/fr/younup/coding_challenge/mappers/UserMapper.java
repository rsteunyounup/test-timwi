package fr.younup.coding_challenge.mappers;

import fr.younup.coding_challenge.models.Album;
import fr.younup.coding_challenge.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

}
