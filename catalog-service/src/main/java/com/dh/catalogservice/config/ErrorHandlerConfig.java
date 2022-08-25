package com.dh.catalogservice.config;
import com.dh.catalogservice.exceptions.GeneralServicesExceptions;
import com.dh.catalogservice.exceptions.NoDataFoundExceptions;
import com.dh.catalogservice.exceptions.ValidateServiceExceptions;
import com.dh.catalogservice.utils.WrapperResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> all(Exception e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response= new WrapperResponse<>(false,"Internal_Server_Error",null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ValidateServiceExceptions.class)
    public ResponseEntity<?> ValidateServiceExceptions(ValidateServiceExceptions e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response= new WrapperResponse<>(false,e.getMessage(),null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoDataFoundExceptions.class)
    public ResponseEntity<?> NoDataFoundExceptions(NoDataFoundExceptions e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response= new WrapperResponse<>(false,e.getMessage(),null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(GeneralServicesExceptions.class)
    public ResponseEntity<?> GeneralServicesExceptions(GeneralServicesExceptions e, WebRequest request){
        log.error(e.getMessage(),e);
        WrapperResponse<?> response= new WrapperResponse<>(false,"Internal_Server_Error",null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
