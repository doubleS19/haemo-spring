package com.example.haemo.haemo.Data.Reply.Club;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clubReply")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClubReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crId")
    private Long crId;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "ccId")
    private Long ccId;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private Long type;
}