package com.morgan.demo01.dao;

import com.morgan.demo01.entity.DO.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,String> {
}
