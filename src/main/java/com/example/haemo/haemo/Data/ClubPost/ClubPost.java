package com.example.haemo.haemo.Data.ClubPost;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "clubPost")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClubPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpId")
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

    @Column(name = "description")
    private String description;

//    @Column(name = "logo")
//    private MultipartFile logo;
}