package com.example.haemo.haemo.Data.Post;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PostDto {
    Long pId;
    String title;
    String content;
    String nickname;
    Long person;
    String category;
    String date;
    String deadline;
}
