package com.example.haemo.haemo.Data.User;

import jakarta.persistence.*;
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
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lId")
    private Long lId;

    @Column(name = "studentId")
    private String studentId;

    @Column(name = "pwd")
    private String pwd;
}