package com.soutvoid.gamesproject.domain.game;

import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class GameEngine implements Serializable {

    private Long id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private Image logo;
    private ArrayList<Long> games;
    private ArrayList<Long> companies;
    private ArrayList<Long> platforms;

}
