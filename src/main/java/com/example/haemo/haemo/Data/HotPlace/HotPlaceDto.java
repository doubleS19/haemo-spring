package com.example.haemo.haemo.Data.HotPlace;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class HotPlaceDto {
    Long pId;
    String title;
    String content;
    String nickname;
    String address;
    String date;
    List<MultipartFile> images;
}
