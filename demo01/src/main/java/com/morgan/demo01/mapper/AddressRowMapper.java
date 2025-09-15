package com.morgan.demo01.mapper;

import com.morgan.demo01.entity.DO.Address;
import com.morgan.demo01.entity.DO.User;
import com.morgan.demo01.entity.DTO.AddToAddWithU;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AddressRowMapper implements RowMapper<AddToAddWithU> {

    @Override
    public AddToAddWithU mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user=User.builder()
                .id(rs.getString("u.id"))
                .name(rs.getString("name"))
                .createTime(rs.getObject("u.create_time", LocalDateTime.class))
                .updateTime(rs.getObject("u.update_time", LocalDateTime.class))
                .build();
        Address address=Address.builder()
                .id(rs.getString("a.id"))
                .detail(rs.getString("detail"))
                .userId(rs.getString("user_id"))
                .createTime(rs.getObject("a.create_time",LocalDateTime.class))
                .updateTime(rs.getObject("a.update_time", LocalDateTime.class))
                .build();
        return AddToAddWithU.builder()
                .user(user)
                .address(address)
                .build();
    }
}
