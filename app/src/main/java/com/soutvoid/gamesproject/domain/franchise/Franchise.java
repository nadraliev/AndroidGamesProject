package com.soutvoid.gamesproject.domain.franchise;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by andrew on 2/23/17.
 */

@Data
@AllArgsConstructor
public class Franchise implements Serializable {

    private Long id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private ArrayList<Long> games;

}
