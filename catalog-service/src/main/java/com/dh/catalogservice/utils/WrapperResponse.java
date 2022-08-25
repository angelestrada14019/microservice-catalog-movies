package com.dh.catalogservice.utils;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WrapperResponse<T> {
    private boolean ok;
    private String mensaje;
    private T body;

    public ResponseEntity<WrapperResponse<T>> createResponse(HttpStatus status){
        return new ResponseEntity<>(this,status);
    }
}
