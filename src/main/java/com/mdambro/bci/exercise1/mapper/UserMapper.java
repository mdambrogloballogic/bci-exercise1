package com.mdambro.bci.exercise1.mapper;

import com.mdambro.bci.exercise1.dto.user.UserDTO;
import com.mdambro.bci.exercise1.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper( uses = PhoneMapper.class )
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDTO userEntityToUserDTO( UserEntity user );

    UserEntity userDTOToUserEntity( UserDTO user );

}
