package com.mdambro.bci.exercise1.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

@Data
@JsonInclude( JsonInclude.Include.NON_NULL )
public class ResponseDTO<T> {

    @JsonUnwrapped
    private T data;
    private ErrorDTO[] error;

}
