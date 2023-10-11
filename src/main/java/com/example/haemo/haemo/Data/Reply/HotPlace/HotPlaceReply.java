package com.example.haemo.haemo.Data.Reply.HotPlace;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HotPlaceReply")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotPlaceReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hrId")
    private Long hrId;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "hcId")
    private Long hcId;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private Long type;
}