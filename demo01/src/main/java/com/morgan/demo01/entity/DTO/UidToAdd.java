package com.morgan.demo01.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UidToAdd {
    private String userId;
    private String detail;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
