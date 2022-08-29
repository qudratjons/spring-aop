package com.jonson.aop.util;

import lombok.Data;

import java.util.Collection;

@Data
public class CustomResponse<T> {
    private int code;
    private String message;
    private Collection<T> responseList;

    public CustomResponse(Collection<T> responseList, CustomStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.responseList = responseList;
    }
}
