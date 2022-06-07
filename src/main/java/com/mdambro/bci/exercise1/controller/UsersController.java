package com.mdambro.bci.exercise1.controller;

import com.mdambro.bci.exercise1.dto.response.ResponseDTO;
import com.mdambro.bci.exercise1.dto.user.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Api( tags = { "Users Authentication" } )
@RequestMapping( path = "/users" )
public interface UsersController {

    @PostMapping( path = "/login" )
    @ApiResponses( value = @ApiResponse( code = 200, message = "OK", response = UserDTO.class ) )
    ResponseEntity<ResponseDTO<UserDTO>> login( UserDTO user );

    @PostMapping( path = "/sign-up" )
    @ApiResponses( value = @ApiResponse( code = 200, message = "OK", response = UserDTO.class ) )
    ResponseEntity<ResponseDTO<UserDTO>> signUp( UserDTO user );

    @GetMapping( path = "/report" )
    @ApiResponses( value = @ApiResponse( code = 200, message = "OK", response = List.class ) )
    ResponseEntity<ResponseDTO<List<UserDTO>>> report();

}
