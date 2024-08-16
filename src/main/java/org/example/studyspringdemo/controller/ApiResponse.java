/**
 * 响应体-实体类
 */

package org.example.studyspringdemo.controller;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse<T> {
    // Getters and setters
    private int code;
    private String msg;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
