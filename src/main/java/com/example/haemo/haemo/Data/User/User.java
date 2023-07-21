package com.example.haemo.haemo.Data.User;

import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uId")
    private Long uId;


    @Column(name = "studentId")
    private String studentId;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "major")
    private String major;

    @Column(name = "gender")
    private String gender;
}