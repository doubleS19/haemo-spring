package com.example.haemo.haemo.Data.Reply.Post;

import lombok.Data;

@Data
public class ReplyDto {
    Long cId;
    String content;
    String nickname;
    Long pId;
    String date;
    Long type;
}
