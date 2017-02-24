package com.soutvoid.gamesproject.domain.person;


import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Serializable {

    private Integer id;
    private String name;
    private Long createdAt;
    private Long updatedAt;
    private String slug;
    private String url;
    private Image mugShot;
    private ArrayList<Integer> characters;
    private ArrayList<Integer> games;
    private ArrayList<Integer> voiceActed;

}
