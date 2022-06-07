package com.mdambro.bci.exercise1.controller.impl;

import com.mdambro.bci.exercise1.controller.UsersController;
import com.mdambro.bci.exercise1.dto.response.ResponseDTO;
import com.mdambro.bci.exercise1.dto.user.UserDTO;
import com.mdambro.bci.exercise1.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersControllerImpl implements UsersController {

    private final UsersService usersService;

    @Override
    public ResponseEntity<ResponseDTO<UserDTO>> login( @Valid @RequestBody UserDTO user ) {
        ResponseDTO<UserDTO> response = new ResponseDTO<>();
        response.setData( usersService.getUser( user ) );

        return new ResponseEntity<>( response, HttpStatus.OK );
    }

    @Override
    public ResponseEntity<ResponseDTO<UserDTO>> signUp( @Valid @RequestBody UserDTO user ) {
        ResponseDTO<UserDTO> response = new ResponseDTO<>();
        response.setData( usersService.addUser( user ) );

        return new ResponseEntity<>( response, HttpStatus.OK );
    }

    @Override
    public ResponseEntity<ResponseDTO<List<UserDTO>>> report() {
        ResponseDTO<List<UserDTO>> response = new ResponseDTO<>();
        response.setData( usersService.getAllUsers() );

        return new ResponseEntity<>( response, HttpStatus.OK );
    }

}
