package com.mdambro.bci.exercise1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity( name = "Phone" )
@Table(
        name = "MY_PHONE",
        indexes = {
                @Index(
                        name = "idx_myphone_userid",
                        columnList = "user_id"
                )
        }
)
public class PhoneEntity implements Serializable {

    @Id
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            columnDefinition = "BINARY(16)"
    )
    @GeneratedValue
    private UUID id;

    @Column( name = "user_id", columnDefinition = "BINARY(16)" )
    private UUID userId;

    @Column( name = "number" )
    private Long number;

    @Column( name = "city_code" )
    private Integer cityCode;

    @Column( name = "country_code" )
    private String countryCode;

}
