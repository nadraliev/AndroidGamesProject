package com.soutvoid.gamesproject.domain.company;

import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by andrew on 2/23/17.
 */

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


    public Company(Long id, String name, String slug, String url, Long createdAt, Long updatedAt, Image logo, String description, String country, String website, Long startDate, Integer startDateCategory, Long changedCompanyId, Long changeDate, Integer changeDateCategory, String twitter, ArrayList<Long> published, ArrayList<Long> developed) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.logo = logo;
        this.description = description;
        this.country = country;
        this.website = website;
        this.startDate = startDate;
        this.startDateCategory = startDateCategory;
        this.changedCompanyId = changedCompanyId;
        this.changeDate = changeDate;
        this.changeDateCategory = changeDateCategory;
        this.twitter = twitter;
        this.published = published;
        this.developed = developed;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getUrl() {
        return this.url;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public Long getUpdatedAt() {
        return this.updatedAt;
    }

    public Image getLogo() {
        return this.logo;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCountry() {
        return this.country;
    }

    public String getWebsite() {
        return this.website;
    }

    public Long getStartDate() {
        return this.startDate;
    }

    public Integer getStartDateCategory() {
        return this.startDateCategory;
    }

    public Long getChangedCompanyId() {
        return this.changedCompanyId;
    }

    public Long getChangeDate() {
        return this.changeDate;
    }

    public Integer getChangeDateCategory() {
        return this.changeDateCategory;
    }

    public String getTwitter() {
        return this.twitter;
    }

    public ArrayList<Long> getPublished() {
        return this.published;
    }

    public ArrayList<Long> getDeveloped() {
        return this.developed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public void setStartDateCategory(Integer startDateCategory) {
        this.startDateCategory = startDateCategory;
    }

    public void setChangedCompanyId(Long changedCompanyId) {
        this.changedCompanyId = changedCompanyId;
    }

    public void setChangeDate(Long changeDate) {
        this.changeDate = changeDate;
    }

    public void setChangeDateCategory(Integer changeDateCategory) {
        this.changeDateCategory = changeDateCategory;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void setPublished(ArrayList<Long> published) {
        this.published = published;
    }

    public void setDeveloped(ArrayList<Long> developed) {
        this.developed = developed;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Company)) return false;
        final Company other = (Company) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$slug = this.getSlug();
        final Object other$slug = other.getSlug();
        if (this$slug == null ? other$slug != null : !this$slug.equals(other$slug)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$createdAt = this.getCreatedAt();
        final Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt))
            return false;
        final Object this$updatedAt = this.getUpdatedAt();
        final Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null ? other$updatedAt != null : !this$updatedAt.equals(other$updatedAt))
            return false;
        final Object this$logo = this.getLogo();
        final Object other$logo = other.getLogo();
        if (this$logo == null ? other$logo != null : !this$logo.equals(other$logo)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$country = this.getCountry();
        final Object other$country = other.getCountry();
        if (this$country == null ? other$country != null : !this$country.equals(other$country))
            return false;
        final Object this$website = this.getWebsite();
        final Object other$website = other.getWebsite();
        if (this$website == null ? other$website != null : !this$website.equals(other$website))
            return false;
        final Object this$startDate = this.getStartDate();
        final Object other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate))
            return false;
        final Object this$startDateCategory = this.getStartDateCategory();
        final Object other$startDateCategory = other.getStartDateCategory();
        if (this$startDateCategory == null ? other$startDateCategory != null : !this$startDateCategory.equals(other$startDateCategory))
            return false;
        final Object this$changedCompanyId = this.getChangedCompanyId();
        final Object other$changedCompanyId = other.getChangedCompanyId();
        if (this$changedCompanyId == null ? other$changedCompanyId != null : !this$changedCompanyId.equals(other$changedCompanyId))
            return false;
        final Object this$changeDate = this.getChangeDate();
        final Object other$changeDate = other.getChangeDate();
        if (this$changeDate == null ? other$changeDate != null : !this$changeDate.equals(other$changeDate))
            return false;
        final Object this$changeDateCategory = this.getChangeDateCategory();
        final Object other$changeDateCategory = other.getChangeDateCategory();
        if (this$changeDateCategory == null ? other$changeDateCategory != null : !this$changeDateCategory.equals(other$changeDateCategory))
            return false;
        final Object this$twitter = this.getTwitter();
        final Object other$twitter = other.getTwitter();
        if (this$twitter == null ? other$twitter != null : !this$twitter.equals(other$twitter))
            return false;
        final Object this$published = this.getPublished();
        final Object other$published = other.getPublished();
        if (this$published == null ? other$published != null : !this$published.equals(other$published))
            return false;
        final Object this$developed = this.getDeveloped();
        final Object other$developed = other.getDeveloped();
        if (this$developed == null ? other$developed != null : !this$developed.equals(other$developed))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $slug = this.getSlug();
        result = result * PRIME + ($slug == null ? 43 : $slug.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $createdAt = this.getCreatedAt();
        result = result * PRIME + ($createdAt == null ? 43 : $createdAt.hashCode());
        final Object $updatedAt = this.getUpdatedAt();
        result = result * PRIME + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        final Object $logo = this.getLogo();
        result = result * PRIME + ($logo == null ? 43 : $logo.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $country = this.getCountry();
        result = result * PRIME + ($country == null ? 43 : $country.hashCode());
        final Object $website = this.getWebsite();
        result = result * PRIME + ($website == null ? 43 : $website.hashCode());
        final Object $startDate = this.getStartDate();
        result = result * PRIME + ($startDate == null ? 43 : $startDate.hashCode());
        final Object $startDateCategory = this.getStartDateCategory();
        result = result * PRIME + ($startDateCategory == null ? 43 : $startDateCategory.hashCode());
        final Object $changedCompanyId = this.getChangedCompanyId();
        result = result * PRIME + ($changedCompanyId == null ? 43 : $changedCompanyId.hashCode());
        final Object $changeDate = this.getChangeDate();
        result = result * PRIME + ($changeDate == null ? 43 : $changeDate.hashCode());
        final Object $changeDateCategory = this.getChangeDateCategory();
        result = result * PRIME + ($changeDateCategory == null ? 43 : $changeDateCategory.hashCode());
        final Object $twitter = this.getTwitter();
        result = result * PRIME + ($twitter == null ? 43 : $twitter.hashCode());
        final Object $published = this.getPublished();
        result = result * PRIME + ($published == null ? 43 : $published.hashCode());
        final Object $developed = this.getDeveloped();
        result = result * PRIME + ($developed == null ? 43 : $developed.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Company;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.domain.company.Company(id=" + this.getId() + ", name=" + this.getName() + ", slug=" + this.getSlug() + ", url=" + this.getUrl() + ", createdAt=" + this.getCreatedAt() + ", updatedAt=" + this.getUpdatedAt() + ", logo=" + this.getLogo() + ", description=" + this.getDescription() + ", country=" + this.getCountry() + ", website=" + this.getWebsite() + ", startDate=" + this.getStartDate() + ", startDateCategory=" + this.getStartDateCategory() + ", changedCompanyId=" + this.getChangedCompanyId() + ", changeDate=" + this.getChangeDate() + ", changeDateCategory=" + this.getChangeDateCategory() + ", twitter=" + this.getTwitter() + ", published=" + this.getPublished() + ", developed=" + this.getDeveloped() + ")";
    }
}
