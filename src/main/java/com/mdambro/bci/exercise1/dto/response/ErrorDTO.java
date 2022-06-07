package com.mdambro.bci.exercise1.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ErrorDTO {

    private Timestamp timestamp;
    @JsonProperty( "codigo" )
    private int code;
    private String detail;

}