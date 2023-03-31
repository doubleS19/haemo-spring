package com.example.haemo.haemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Post{
    @GeneratedValue
    @Id
    Integer pId;
    String title;
    String content;
    String nickname;
    Integer person;
    String category;
}