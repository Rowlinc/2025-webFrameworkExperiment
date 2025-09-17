package com.morgan.backendexamples.component.exception;

import com.morgan.backendexamples.component.Code;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemException extends RuntimeException {
    private Code code;
}
