package com.morgan.demo01.mapper;

import com.morgan.demo01.entity.DO.Address;
import com.morgan.demo01.entity.DO.User;
import com.morgan.demo01.entity.DTO.UidToAdd;
import com.morgan.demo01.entity.DTO.UidToAddWithU;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserResultSetExtractor implements ResultSetExtractor<UidToAddWithU> {
    @Override
    public UidToAddWithU extractData(ResultSet rs) throws SQLException, DataAccessException {
        User user=null;
        List<Address> list=new ArrayList<>();
        while (rs.next()){
            if (user==null){
                user=User.builder()
                        .id(rs.getString("u.id"))
                        .name(rs.getString("name"))
                        .createTime(rs.getObject("u.create_time", LocalDateTime.class))
                        .updateTime(rs.getObject("u.update_time", LocalDateTime.class))
                        .build();
            }
            list.add(Address.builder()
                    .id(rs.getString("a.id"))
                    .detail(rs.getString("detail"))
                    .userId(rs.getString("user_id"))
                    .createTime(rs.getObject("a.create_time", LocalDateTime.class))
                    .updateTime(rs.getObject("a.update_time", LocalDateTime.class))
                    .build()
            );
        }
        return UidToAddWithU.builder()
                .user(user)
                .addresses(list).build();
    }
}
