package com.example.haemo.haemo.Data.Comment;

import lombok.Data;

@Data
public class CommentDto {
    Long cId;
    String content;
    String nickname;
    Long pId;
    String date;
}
