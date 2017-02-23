package com.soutvoid.gamesproject.domain.character;

import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by andrew on 22-Feb-17.
 */

@Data
@AllArgsConstructor
public class Character implements Serializable {

    private Integer id;
    private String name;
    private Long createdAt;
    private Long updatedAt;
    private String slug;
    private String url;
    private Image mugShot;
    private Integer gender;
    private ArrayList<String> akas;
    private Integer species;
    private ArrayList<Integer> people = null;
    private ArrayList<Integer> games = null;

}
