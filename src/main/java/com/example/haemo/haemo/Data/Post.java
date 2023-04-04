package com.example.haemo.haemo.Data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pId")
    private Long pId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "person")
    private String person;

    @Column(name = "category")
    private String category;

    public Long getpId(){
        return pId;
    }

    public void setPId(){
        this.pId = pId;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(){
        this.title = title;
    }
    public String getContent(){
        return content;
    }

    public void setContent(){
        this.content = content;
    }
    public String getNickname(){
        return nickname;
    }
    public void setNickname(){
        this.nickname= nickname;
    }
    public String getpPerson(){
        return person;
    }
    public void setPerson(){
        this.person = person;
    }
    public String getpCategory(){
        return category;
    }
    public void setCategory(){
        this.category = category;
    }
}