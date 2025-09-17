package com.morgan.backendexamples.component;

import com.morgan.backendexamples.POJO.VO.Result;
import com.morgan.backendexamples.component.exception.BusinessException;
import com.morgan.backendexamples.component.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    //    数据库连接异常
    @ExceptionHandler(SQLException.class)
    public Result handleSQLException(SQLException SQLe){
        //错误处理逻辑
        //把sql自己的错误信息发送给维护人员

        SystemException systemException=SystemException.builder()
                .code(Code.SYSTEM_SQL).build();
        return handleSystemException(systemException);
    }

    //    唯一键冲突
    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException de){
        //错误处理逻辑
        //把错误原信息发送给维护人员

        BusinessException businessException=BusinessException.builder()
                .code(Code.BUSINESS_SQL_UNIQUE_KEY_REPEAT).build();
        return handleBusinessException(businessException);
    }
    //    数据完整性错误
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Result handleDataIntegrityViolationException(DataIntegrityViolationException dive){
        //错误处理逻辑
        //把错误原信息发送给维护人员

        BusinessException businessException=BusinessException.builder()
                .code(Code.BUSINESS_SQL_DATA_INCOMPLETE).build();
        return handleBusinessException(businessException);
    }
//    系统异常
    @ExceptionHandler(SystemException.class)
    public Result handleSystemException(SystemException se){
        //错误处理逻辑

        return Result.builder()
                .code(se.getCode().getCode())
                .message(se.getCode().getMessage())
                .data(null).build();
    }
//    业务异常
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException be){
        //错误处理逻辑

        return Result.builder()
                .code(be.getCode().getCode())
                .message(be.getCode().getMessage())
                .data(null).build();
    }

    //    其他异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        //错误处理逻辑
        //把错误源信息传给维护人员

        return Result.builder()
                .code(Code.EXCEPTION.getCode())
                .message(Code.EXCEPTION.getMessage())
                .data(null).build();
    }

}
