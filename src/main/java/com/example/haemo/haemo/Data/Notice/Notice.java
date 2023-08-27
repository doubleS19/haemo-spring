package com.example.haemo.haemo.Data.Notice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notice")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nId")
    private Long nId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "MD")
    private String md;

    @Column(name = "type")
    private String type;

    @Column(name = "visible")
    private boolean visible;

    @Column(name = "date")
    private String date;
}