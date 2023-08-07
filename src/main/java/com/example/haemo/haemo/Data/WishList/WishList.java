package com.example.haemo.haemo.Data.WishList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wish")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wId")
    private Long wId;


    @Column(name = "uId")
    private Long uId;

    @Column(name = "pId")
    private Long pId;
}