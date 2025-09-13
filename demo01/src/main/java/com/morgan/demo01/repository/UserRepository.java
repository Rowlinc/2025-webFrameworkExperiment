package com.morgan.demo01.repository;

import com.morgan.demo01.entity.DO.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
}
