package com.soutvoid.gamesproject.domain.company;

import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by andrew on 2/23/17.
 */

@Data
@AllArgsConstructor
public class Company implements Serializable {

    private Long id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private Image logo;
    private String description;
    private String country;
    private String website;
    private Long startDate;
    private Integer startDateCategory;
    private Long changedCompanyId;
    private Long changeDate;
    private Integer changeDateCategory;
    private String twitter;
    private ArrayList<Long> published;
    private ArrayList<Long> developed;

}
