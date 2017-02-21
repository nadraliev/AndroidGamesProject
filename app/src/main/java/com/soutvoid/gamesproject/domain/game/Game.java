package com.soutvoid.gamesproject.domain.game;

import android.provider.MediaStore;

import java.io.Serializable;
import java.util.List;

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
    public Integer createdAt;
    public Integer updatedAt;
    public String summary;
    public String storyline;
    public Integer collection;
    public Integer hypes;
    public Double popularity;
    public List<Integer> developers = null;
    public List<Integer> publishers = null;
    public Integer category;
    public List<Integer> playerPerspectives = null;
    public List<Integer> gameModes = null;
    public List<Integer> keywords = null;
    public List<Integer> themes = null;
    public List<Integer> genres = null;
    public Integer firstReleaseDate;
    public List<ReleaseDate> releaseDates = null;
    public List<AlternativeName> alternativeNames = null;
    public List<Screenshot> screenshots = null;
    public List<MediaStore.Video> videos = null;
    public Cover cover;
    public Esrb esrb;
    public Pegi pegi;

}
