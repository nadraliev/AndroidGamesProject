package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
@AllArgsConstructor
public class Game implements Serializable {

    private Integer id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private String summary;
    private String storyline;
    private Integer collection;
    private Long franchise;
    private Double rating;
    private Integer rating_count;
    private Integer hypes;
    private Double popularity;
    private Double aggregatedRating;
    private Long game;
    private ArrayList<Integer> developers = null;
    private ArrayList<Integer> publishers = null;
    private Integer category;
    private TimeToBeat timeToBeat;
    private ArrayList<Integer> playerPerspectives = null;
    private ArrayList<Integer> gameModes = null;
    private ArrayList<Integer> keywords = null;
    private ArrayList<Integer> themes = null;
    private ArrayList<Integer> genres = null;
    private Long firstReleaseDate;
    private Integer status;
    private ArrayList<ReleaseDate> releaseDates = null;
    private ArrayList<AlternativeName> alternativeNames = null;
    private ArrayList<Screenshot> screenshots = null;
    private ArrayList<Video> videos = null;
    private Cover cover;
    private Esrb esrb;
    private Pegi pegi;

    @Override
    public String toString() {
        String result = "";
        Field[] fields = getClass().getFields();
        for (Field field :
                fields) {
            try {
                result += field.getName() + ": " + field.get(this).toString() + "\n";
            } catch (IllegalAccessException | NullPointerException e) {
                //ignore
            }
        }
        return result;
    }

}
