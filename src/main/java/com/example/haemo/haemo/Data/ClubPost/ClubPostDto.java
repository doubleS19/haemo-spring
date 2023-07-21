package com.example.haemo.haemo.Data.ClubPost;

import lombok.Data;

@Data
public class ClubPostDto {
    Long pId;
    String title;
    String content;
    String nickname;
    Long person;
    String category;
}
