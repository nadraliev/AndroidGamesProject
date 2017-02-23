package com.soutvoid.gamesproject.interactor.company.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.company.Company;
import com.soutvoid.gamesproject.interactor.common.network.response.ImageObj;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;
import com.soutvoid.gamesproject.util.Transformable;

import java.util.ArrayList;

/**
 * Created by andrew on 2/23/17.
 */

public class CompanyObj implements Transformable<Company> {

    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("slug")
    private String slug;
    @SerializedName("url")
    private String url;
    @SerializedName("created_at")
    private Long createdAt;
    @SerializedName("updated_at")
    private Long updatedAt;
    @SerializedName("logo")
    private ImageObj logo;
    @SerializedName("description")
    private String description;
    @SerializedName("country")
    private String country;
    @SerializedName("website")
    private String website;
    @SerializedName("start_date")
    private Long startDate;
    @SerializedName("start_date_category")
    private Integer startDateCategory;
    @SerializedName("changed_company_id")
    private Long changedCompanyId;
    @SerializedName("change_date")
    private Long changeDate;
    @SerializedName("change_date_category")
    private Integer changeDateCategory;
    @SerializedName("twitter")
    private String twitter;
    @SerializedName("published")
    private ArrayList<Long> published;
    @SerializedName("developed")
    private ArrayList<Long> developed;

    @Override
    public Company transform() {
        return new Company(
                id,
                name,
                slug,
                url,
                createdAt,
                updatedAt,
                TransformUtil.transform(logo),
                description,
                country,
                website,
                startDate,
                startDateCategory,
                changedCompanyId,
                changeDate,
                changeDateCategory,
                twitter,
                published,
                developed
        );
    }
}
