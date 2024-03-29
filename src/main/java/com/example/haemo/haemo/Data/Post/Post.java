package com.example.haemo.haemo.Data.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pId")
    private Long pId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "person")
    private Long person;

    @Column(name = "category")
    private String category;

    @Column(name = "deadline")
    private String deadline;

    @Column(name = "date")
    private String date;

    @Column(name="wishCnt")
    private Long wishCnt;
}