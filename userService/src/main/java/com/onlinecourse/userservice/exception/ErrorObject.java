package com.onlinecourse.userservice.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorObject {

    private String code;
    private String message;

}
