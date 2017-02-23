package com.soutvoid.gamesproject.domain.collection;

import com.soutvoid.gamesproject.domain.game.Game;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by andrew on 2/23/17.
 */

@Data
@AllArgsConstructor
public class Collection implements Serializable {

    private Long id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private ArrayList<Game> games;

}
