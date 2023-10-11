package com.example.haemo.haemo.Data.Reply.Post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PostReply")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rId")
    private Long rId;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "cId")
    private Long cId;

    @Column(name = "date")
    private String date;
}