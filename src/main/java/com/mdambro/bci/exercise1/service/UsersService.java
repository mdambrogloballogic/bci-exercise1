package com.mdambro.bci.exercise1.service;

import com.mdambro.bci.exercise1.dto.user.UserDTO;

import java.util.List;

public interface UsersService {

    UserDTO getUser( UserDTO userDTO );

    UserDTO addUser( UserDTO userDTO );

    List<UserDTO> getAllUsers();

}
