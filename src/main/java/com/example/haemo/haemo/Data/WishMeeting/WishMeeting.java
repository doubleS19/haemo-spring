package com.example.haemo.haemo.Data.WishMeeting;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wishMeeting")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wmId")
    private Long wmId;


    @Column(name = "uId")
    private Long uId;

    @Column(name = "pId")
    private Long pId;
}