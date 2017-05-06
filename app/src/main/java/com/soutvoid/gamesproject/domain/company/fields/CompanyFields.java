package com.soutvoid.gamesproject.domain.company.fields;

/**
 * Created by andrew on 2/23/17.
 */

public enum CompanyFields {
    ID,
    NAME,
    SLUG,
    URL,
    CREATED_AT,
    UPDATED_AT,
    LOGO,
    DESCRIPTION,
    COUNTRY,
    WEBSITE,
    START_DATE,
    START_DATE_CATEGORY,
    CHANGED_COMPANY_ID,
    CHANGE_DATE,
    CHANGE_DATE_CATEGORY,
    TWITTER,
    PUBLISHED,
    DEVELOPED;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
