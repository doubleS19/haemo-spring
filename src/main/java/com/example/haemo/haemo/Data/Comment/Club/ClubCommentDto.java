package com.example.haemo.haemo.Data.Comment.Club;

import lombok.Data;

@Data
public class ClubCommentDto {
    Long cId;
    String content;
    String nickname;
    Long pId;
    String date;
    Long type;
}
