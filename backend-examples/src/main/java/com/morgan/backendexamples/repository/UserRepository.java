package com.morgan.backendexamples.repository;

import com.morgan.backendexamples.POJO.DO.UserBackendExamples;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserBackendExamples,String> {
    @Query("select * from user_backend_examples where account=:account")
    UserBackendExamples findByAccount(String account);
    @Query("select * from user_backend_examples where role='USER'")
    List<UserBackendExamples> findAllUser();
    @Modifying
    @Query("update user_backend_examples set password=:#{#user.password} where id=:#{#user.id}")
    int updatePasswordById(UserBackendExamples user);
//    @Modifying
//    @Query("insert into user_backend_examples(id,account,password) values (:#{#user.id},:#{#user.account},:#{#user.password})")
//    Integer insertUser(UserBackendExamples user);

}
