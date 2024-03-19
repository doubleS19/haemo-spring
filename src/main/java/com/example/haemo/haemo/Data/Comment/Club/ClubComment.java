package com.example.haemo.haemo.Data.Comment.Club;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clubComment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClubComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ccId")
    private Long ccId;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "cpId")
    private Long cpId;

    @Column(name = "date")
    private String date;
}