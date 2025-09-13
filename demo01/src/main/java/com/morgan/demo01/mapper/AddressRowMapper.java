package com.morgan.demo01.mapper;

import com.morgan.demo01.entity.DTO.AddToAddWithU;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<AddToAddWithU> {

    @Override
    public AddToAddWithU mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AddToAddWithU(
                rs.getString("id"),
                rs.getString("detail"),
                rs.getString("user_id"),
                rs.getString("name")
        );
    }
}
