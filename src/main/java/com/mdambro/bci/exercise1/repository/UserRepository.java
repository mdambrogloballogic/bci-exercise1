package com.mdambro.bci.exercise1.repository;

import com.mdambro.bci.exercise1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query( "SELECT user " +
            "  FROM User user " +
            " WHERE LOWER( user.email ) = LOWER( :email ) " +
            "   AND user.password = :password"
    )
    UserEntity retrieveByEmail(
            @Param( value = "email" ) String email,
            @Param( value = "password" ) String password,
            @Param( value = "token" ) String token
    );

}
