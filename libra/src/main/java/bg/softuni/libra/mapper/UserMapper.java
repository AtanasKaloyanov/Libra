package bg.softuni.libra.mapper;

import bg.softuni.libra.model.dto.UserRegisterDTO;
import bg.softuni.libra.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO registerDTO);


}
