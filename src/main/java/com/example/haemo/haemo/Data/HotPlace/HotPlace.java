package com.example.haemo.haemo.Data.HotPlace;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Table(name = "hotPlace")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hpId")
    private Long pId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "address")
    private String address;

    @Column(name="date")
    private String date;

    @Column(name="wishing")
    private Long wishing;

//    @Column(name="images")
//    private List<MultipartFile> images;
}