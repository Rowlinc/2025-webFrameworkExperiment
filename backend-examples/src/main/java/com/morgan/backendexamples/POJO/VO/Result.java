package com.morgan.backendexamples.POJO.VO;

import com.morgan.backendexamples.component.Code;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
    private Integer code;
    private String message;
    private Object data;
    public static Result error(Code code){
        return Result.builder()
                .code(code.getCode())
                .message(code.getMessage())
                .build();
    }

    public static Result error(Code code,String message){
        return Result.builder()
                .code(code.getCode())
                .message(message)
                .build();
    }

    public static Result success(Code code,Object data){
        return Result.builder()
                .code(code.getCode())
                .message(code.getMessage())
                .data(data)
                .build();
    }
}
