package com.morgan.demo01.entity.DTO;

import com.morgan.demo01.entity.DO.Address;
import com.morgan.demo01.entity.DO.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UidToAddWithU {
    private User user;
    private List<Address> addresses;
}
