package com.example.bookstore_ordersapi.exception;

import com.example.bookstore_ordersapi.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class BookStoreExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> error_message = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST request", error_message.toString());
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ResponseDTO> handleBookStoreException(OrderException exception){
        ResponseDTO resDTO = new ResponseDTO("Exception while processing Orders REST request", exception.getMessage());
        return new ResponseEntity(resDTO, HttpStatus.BAD_REQUEST);
    }
}
