package com.mdambro.bci.exercise1.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.mdambro.bci.exercise1.misc.CustomDateFormatterDeserializer;
//import com.mdambro.bci.exercise1.misc.CustomDateFormatterSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.UUID;

@Data
public class UserDTO {

    private UUID id;
    //@JsonSerialize( using = CustomDateFormatterSerializer.class )
    //@JsonDeserialize( using = CustomDateFormatterDeserializer.class )
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy hh:mm:ss a" )
    private Date created;
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy hh:mm:ss a" )
    private Date lastLogin;
    private String token;
    @JsonIgnore
    private Boolean isActive;
    private String name;
    @NotNull( message = "The email is mandatory." )
    @NotEmpty( message = "The email cannot be empty." )
    @Email( message = "Email should be valid." )
    private String email;
    @NotNull( message = "The password is mandatory." )
    @NotEmpty( message = "The password cannot be empty." )
    @Min( value = 8, message = "Password must contains at less 8 characters." )
    @Max( value = 12, message = "Password must contains a maximum of 12 characters." )
    @Pattern(
            regexp = "/^([a-z]*[A-Z][a-z]*\\d[a-z]*\\d[a-z]*)|([a-z]*\\d[a-z]*[A-Z][a-z]*\\d[a-z]*)|([a-z]*\\d[a-z]*\\d[a-z]*[A-Z][a-z]*)$/",
            message = "The password must contain only 1 mandatory capital letter and only 2 mandatory numbers."
    )
    @JsonIgnore
    private String password;
    private PhoneDTO[] phones;

}
