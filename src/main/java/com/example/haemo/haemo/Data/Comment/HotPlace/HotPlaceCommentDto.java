package com.example.haemo.haemo.Data.Comment.HotPlace;

import lombok.Data;

@Data
public class HotPlaceCommentDto {
    Long hcId;
    String content;
    String nickname;
    Long pId;
    String date;
    Long type;
}
