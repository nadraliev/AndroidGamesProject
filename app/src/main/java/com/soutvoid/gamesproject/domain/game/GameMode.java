package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameMode implements Serializable {

    private Long id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private ArrayList<Long> games;

}
