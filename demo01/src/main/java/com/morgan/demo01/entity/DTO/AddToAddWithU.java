package com.morgan.demo01.entity.DTO;

import com.morgan.demo01.entity.DO.Address;
import com.morgan.demo01.entity.DO.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddToAddWithU {
    private User user;
    private Address address;
}
