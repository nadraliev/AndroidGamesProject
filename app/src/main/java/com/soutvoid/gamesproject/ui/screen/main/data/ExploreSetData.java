package com.soutvoid.gamesproject.ui.screen.main.data;

import com.soutvoid.gamesproject.domain.game.Game;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class ExploreSetData {

    private int position;
    private String name;
    private ArrayList<Game> games;
}
