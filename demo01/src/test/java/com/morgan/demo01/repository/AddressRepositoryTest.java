package com.morgan.demo01.repository;

import com.morgan.demo01.entity.DO.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@Slf4j
class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

//    查
    @Test
    void findTest(){
        for (Address address: addressRepository.getAddressesByUserId("1416323881434828800")){
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
        addressRepository.saveAll(addresses);
    }
    @Test
    void findAllTest(){
        System.out.println(addressRepository.getAllAddressByUserId("1416336075241246721"));
    }

    @Test
    void findAToAU(){
        System.out.println(addressRepository.getAddToAddWithUByAid("1416340065286836224"));
    }
    @Test
    void findUToAU(){
        System.out.println(addressRepository.getUidToAddWithU("1416336075211886592"));
    }
    @Test
    void findNameWithAdd(){
        System.out.println(addressRepository.getNameWithAdd());
    }
}