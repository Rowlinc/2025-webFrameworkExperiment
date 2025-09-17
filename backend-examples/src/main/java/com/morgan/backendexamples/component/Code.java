package com.morgan.backendexamples.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Code {
    EXCEPTION(500000,"系统正在缓冲中..."),

    BUSINESS_TOKEN_EXPIRED(400101,"token过期"),
    BUSINESS_TOKEN_INCORRECT(400102,"token不匹配"),
    BUSINESS_TOKEN_NOT_ADMIN(400103,"非管理员用户"),
    BUSINESS_TOKEN_IS_ADMIN(401104,"管理员用户"),
    BUSINESS_SQL_NODATA(400201,"数据不存在"),
    BUSINESS_SQL_FAIL_TO_UPDATE(400202,"修改失败"),
    BUSINESS_SQL_TABLE_EMPTY(400203,"当前表中无数据"),
    BUSINESS_SQL_UNIQUE_KEY_REPEAT(400204,"唯一键冲突"),
    BUSINESS_SQL_DATA_INCOMPLETE(400205,"数据不完整"),
    BUSINESS_SQL_UPDATE_PASSWORD_SUCCESS(401206,"密码修改成功"),
    BUSINESS_SQL_INSERT_USER_SUCCESS(401207,"用户添加成功"),
    BUSINESS_SQL_GET_ALL_USER_SUCCESS(401208,"获取用户成功"),
    BUSINESS_PASSWORD_ERROR(400301,"密码错误"),
    BUSINESS_LOGIN_SUCCESS(401301,"登录成功"),

    SYSTEM_SQL(300101,"数据库连接错误");
    private final Integer code;
    private final String message;
}
