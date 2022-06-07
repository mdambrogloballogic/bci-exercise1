package com.mdambro.bci.exercise1.service.impl;

import com.mdambro.bci.exercise1.dto.user.UserDTO;
import com.mdambro.bci.exercise1.entity.UserEntity;
import com.mdambro.bci.exercise1.mapper.UserMapper;
import com.mdambro.bci.exercise1.repository.UserRepository;
import com.mdambro.bci.exercise1.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUser( UserDTO userDTO ) {

        UserEntity userEntity = Optional.ofNullable(
                this.userRepository.retrieveByEmail(
                        userDTO.getEmail(),
                        userDTO.getPassword(),
                        userDTO.getToken()
                )
        ).orElseThrow( EntityNotFoundException::new );

        userEntity.setLastLogin( new Date() );

        return UserMapper.INSTANCE.userEntityToUserDTO(
                this.userRepository.saveAndFlush( userEntity )
        );
    }

    @Override
    public UserDTO addUser( UserDTO userDTO ) {

        UserEntity userEntity = UserMapper.INSTANCE.userDTOToUserEntity( userDTO );
        userEntity.setCreated( new Date() );
        userEntity.setIsActive( true );

        return UserMapper.INSTANCE.userEntityToUserDTO(
                this.userRepository.saveAndFlush( userEntity )
        );
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return this.userRepository.findAll()
                .stream()
                .map( UserMapper.INSTANCE::userEntityToUserDTO )
                .collect( Collectors.toList() );
    }

}
