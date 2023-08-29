package com.example.haemo.haemo.Data.Acceptation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Acceptation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Acceptation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aId")
    private Long aId;

    @Column(name = "uId")
    private Long uId;

    @Column(name = "pId")
    private Long pId;

    @Column(name = "accept")
    private boolean accept;
}