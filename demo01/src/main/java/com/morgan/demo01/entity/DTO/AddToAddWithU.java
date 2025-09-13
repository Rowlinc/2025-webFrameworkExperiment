package com.morgan.demo01.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddToAddWithU {
    private String id;
    private String detail;
    private String userId;
    private String name;
}
