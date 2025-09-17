package com.morgan.backendexamples.component.exception;

import com.morgan.backendexamples.component.Code;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessException extends RuntimeException{
    private Code code;
}
