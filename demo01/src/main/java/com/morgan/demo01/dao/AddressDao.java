package com.morgan.demo01.dao;

import com.morgan.demo01.entity.DO.Address;
import com.morgan.demo01.entity.DTO.AddToAddWithU;
import com.morgan.demo01.entity.DTO.NameWithAdd;
import com.morgan.demo01.entity.DTO.UidToAdd;
import com.morgan.demo01.entity.DTO.UidToAddWithU;
import com.morgan.demo01.mapper.UserResultSetExtractor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends CrudRepository<Address,String> {
    @Query("select * from `2023211454`.address a where a.user_id=:userId")
    List<Address> getAddressesByUserId(String userId);
    @Query("select user_id,detail,create_time,update_time from `2023211454`.address a where a.user_id=:userId")
    List<UidToAdd> getAllAddressByUserId(String userId);
    @Query("select a.id,a.detail,a.user_id,u.name from `2023211454`.address a left join `2023211454`.user u on a.user_id=u.id where a.id=:addressId")
    AddToAddWithU getAddToAddWithUByAid(String addressId, RowMapper<AddToAddWithU> rowMapper);
    @Query(value = "select * from `2023211454`.user u join `2023211454`.address a on u.id=a.user_id where u.id=:userId",resultSetExtractorClass = UserResultSetExtractor.class)
    UidToAddWithU getUidToAddWithU(String userId);
    @Query("select u.name,count(a.id) as count from user u left join address a on u.id = a.user_id group by u.id order by count")
    List<NameWithAdd> getNameWithAdd();
}
