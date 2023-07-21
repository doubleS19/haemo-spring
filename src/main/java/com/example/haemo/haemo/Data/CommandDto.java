package com.example.haemo.haemo.Data;

import lombok.Data;

@Data
public class CommandDto {
    Long cId;
    String content;
    String nickname;
    Long pId;
    String date;
}
