package com.jonson.aop.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomStatus {
    SUCCESS(0, "SUCCESS"),
    NOT_FOUND(1, "Not found record"),
    EXCEPTON(2, "Exception occured")
    ;
    private final int code;
    private final String message;

}
