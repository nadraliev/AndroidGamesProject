package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
@AllArgsConstructor
public class Game implements Serializable {

    public Integer id;
    public String name;
    public String slug;
    public String url;
    public Long createdAt;
    public Long updatedAt;
    public String summary;
    public String storyline;
    public Integer collection;
    public Integer hypes;
    public Double popularity;
    public ArrayList<Integer> developers = null;
    public ArrayList<Integer> publishers = null;
    public Integer category;
    public ArrayList<Integer> playerPerspectives = null;
    public ArrayList<Integer> gameModes = null;
    public ArrayList<Integer> keywords = null;
    public ArrayList<Integer> themes = null;
    public ArrayList<Integer> genres = null;
    public Long firstReleaseDate;
    public ArrayList<ReleaseDate> releaseDates = null;
    public ArrayList<AlternativeName> alternativeNames = null;
    public ArrayList<Screenshot> screenshots = null;
    public ArrayList<Video> videos = null;
    public Cover cover;
    public Esrb esrb;
    public Pegi pegi;

}
