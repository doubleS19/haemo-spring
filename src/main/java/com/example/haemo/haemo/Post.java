package com.example.haemo.haemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post{
    @Id
    Long pId;
    String title;
    String content;
    String nickname;
    Long person;
    String category;
}