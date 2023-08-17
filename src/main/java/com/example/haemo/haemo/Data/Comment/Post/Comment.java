package com.example.haemo.haemo.Data.Comment.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PostComment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cId")
    private Long cId;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "pId")
    private Long pId;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private Long type;
}