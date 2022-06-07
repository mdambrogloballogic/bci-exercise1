package com.mdambro.bci.exercise1.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class PhoneDTO {

    @JsonIgnore
    private UUID id;
    private Long number;
    @JsonProperty("citycode")
    private Integer cityCode;
    @JsonProperty("contrycode")
    private String countryCode;

}
