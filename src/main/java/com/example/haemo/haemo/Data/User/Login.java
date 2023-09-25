package com.example.haemo.haemo.Data.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "login")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    @Column(name = "studentId")
    private String studentId;

    @Column(name = "pwd")
    private String pwd;
}