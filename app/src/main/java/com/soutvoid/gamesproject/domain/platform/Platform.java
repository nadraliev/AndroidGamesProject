package com.soutvoid.gamesproject.domain.platform;


import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Platform implements Serializable {

    private Long id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private Image logo;
    private String website;
    private String summary;
    private String alternativeName;
    private Integer generation;
    private ArrayList<Long> games;
    private ArrayList<PlatformVersion> versions;

}
