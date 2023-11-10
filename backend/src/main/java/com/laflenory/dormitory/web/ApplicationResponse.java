package com.laflenory.dormitory.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationResponse<T> {
    private String message;
    private T data;
}
