package com.example.haemo.haemo.Data;

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
}
