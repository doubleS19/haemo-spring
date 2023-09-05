package com.example.haemo.haemo.Data.WishClub;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wishClub")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wcId")
    private Long wcId;


    @Column(name = "uId")
    private Long uId;

    @Column(name = "cpId")
    private Long cpId;
}