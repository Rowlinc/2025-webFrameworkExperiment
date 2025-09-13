package com.morgan.demo01.dao;

import com.morgan.demo01.entity.DO.Address;
import com.morgan.demo01.mapper.AddressRowMapper;
import com.morgan.demo01.mapper.UserResultSetExtractor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressDaoTest {
    @Autowired
    private AddressDao addressDao;

//    查
    @Test
    void findTest(){
        for (Address address:addressDao.getAddressesByUserId("1416323881434828800")){
            log.debug("address:{}",address);
        }
    }
//    增多条
    @Test
    void saveAllTest(){
        List<Address> addresses= Stream.of(
                Address.builder().detail("henan").userId("1416336075211886592").build(),
                Address.builder().detail("hebei").userId("1416336075211886592").build(),
                Address.builder().detail("shandong").userId("1416336075211886592").build(),
                Address.builder().detail("shanxi").userId("1416336075241246720").build(),
                Address.builder().detail("beijing").userId("1416336075241246721").build(),
                Address.builder().detail("tianjin").userId("1416336075241246721").build()
        ).toList();
        addressDao.saveAll(addresses);
    }
    @Test
    void findAllTest(){
        System.out.println(addressDao.getAllAddressByUserId("1416336075241246721"));
    }

    @Test
    void findAToAU(){
        System.out.println(addressDao.getAddToAddWithUByAid("1416340065286836224",new AddressRowMapper()));
    }
    @Test
    void findUToAU(){
        System.out.println(addressDao.getUidToAddWithU("1416336075211886592"));
    }
    @Test
    void findNameWithAdd(){
        System.out.println(addressDao.getNameWithAdd());
    }
}