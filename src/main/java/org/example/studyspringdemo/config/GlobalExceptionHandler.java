/**
 * 全局异常捕捉
 */


package org.example.studyspringdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // 返回JSON格式的错误响应
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
}

// 定义一个错误响应类
@Setter
@Getter
class ErrorResponse {
    private String error;
    private String msg;

    public ErrorResponse(String error, String msg) {
        this.error = error;
        this.msg = msg;
    }

}

