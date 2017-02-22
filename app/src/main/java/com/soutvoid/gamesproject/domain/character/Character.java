package com.soutvoid.gamesproject.domain.character;

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
    
    public Integer id;
    public String name;
    public Long createdAt;
    public Long updatedAt;
    public String slug;
    public String url;
    public ArrayList<Integer> people = null;
    public ArrayList<Integer> games = null;

}
