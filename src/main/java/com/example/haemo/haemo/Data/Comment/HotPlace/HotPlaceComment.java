package com.example.haemo.haemo.Data.Comment.HotPlace;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HotPlaceComment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotPlaceComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cId")
    private Long cId;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "hpId")
    private Long pId;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private Long type;
}