package com.example.haemo.haemo.Data.Comment.Club;

import lombok.Data;

@Data
public class ClubCommentDto {
    Long ccId;
    String content;
    String nickname;
    Long cpId;
    String date;
    Long type;
}
