package com.soutvoid.gamesproject.domain.platform;

import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlatformVersion implements Serializable {

    private String url;
    private String name;
    private String slug;
    private String cpu;
    private String media;
    private String memory;
    private String online;
    private String output;
    private String storage;
    private String graphics;
    private String resolutions;
    private Image logo;
    private String summary;
    private ArrayList<PlatformVersionReleaseDate> releaseDates;

}
