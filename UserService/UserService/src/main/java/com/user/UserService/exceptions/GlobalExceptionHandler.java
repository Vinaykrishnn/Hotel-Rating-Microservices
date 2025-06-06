//package com.user.UserService.exceptions;
//
//import com.user.UserService.payload.ApiResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception){
//
//        String message = exception.getMessage();
//        ApiResponse response = ApiResponse.builder()
//                .message(message)
//                .status(false) // or true, depending on your logic
//                .httpStatus(HttpStatus.NOT_FOUND.toString())
//                .build();
//        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
//    }
//}
