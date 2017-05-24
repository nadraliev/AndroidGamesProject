package com.soutvoid.gamesproject.domain.platform;

import com.soutvoid.gamesproject.domain.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class PlatformVersion implements Serializable {

    private String url;
    private String name;
    private String slug;
    private String cpu;
    private String media;
    private String memory;
    private String online;
    private String output;
    private String storage;
    private String graphics;
    private String resolutions;
    private Image logo;
    private String summary;
    private ArrayList<PlatformVersionReleaseDate> releaseDates;


    public PlatformVersion(String url, String name, String slug, String cpu, String media, String memory, String online, String output, String storage, String graphics, String resolutions, Image logo, String summary, ArrayList<PlatformVersionReleaseDate> releaseDates) {
        this.url = url;
        this.name = name;
        this.slug = slug;
        this.cpu = cpu;
        this.media = media;
        this.memory = memory;
        this.online = online;
        this.output = output;
        this.storage = storage;
        this.graphics = graphics;
        this.resolutions = resolutions;
        this.logo = logo;
        this.summary = summary;
        this.releaseDates = releaseDates;
    }

    public String getUrl() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getCpu() {
        return this.cpu;
    }

    public String getMedia() {
        return this.media;
    }

    public String getMemory() {
        return this.memory;
    }

    public String getOnline() {
        return this.online;
    }

    public String getOutput() {
        return this.output;
    }

    public String getStorage() {
        return this.storage;
    }

    public String getGraphics() {
        return this.graphics;
    }

    public String getResolutions() {
        return this.resolutions;
    }

    public Image getLogo() {
        return this.logo;
    }

    public String getSummary() {
        return this.summary;
    }

    public ArrayList<PlatformVersionReleaseDate> getReleaseDates() {
        return this.releaseDates;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public void setResolutions(String resolutions) {
        this.resolutions = resolutions;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setReleaseDates(ArrayList<PlatformVersionReleaseDate> releaseDates) {
        this.releaseDates = releaseDates;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PlatformVersion)) return false;
        final PlatformVersion other = (PlatformVersion) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$slug = this.getSlug();
        final Object other$slug = other.getSlug();
        if (this$slug == null ? other$slug != null : !this$slug.equals(other$slug)) return false;
        final Object this$cpu = this.getCpu();
        final Object other$cpu = other.getCpu();
        if (this$cpu == null ? other$cpu != null : !this$cpu.equals(other$cpu)) return false;
        final Object this$media = this.getMedia();
        final Object other$media = other.getMedia();
        if (this$media == null ? other$media != null : !this$media.equals(other$media))
            return false;
        final Object this$memory = this.getMemory();
        final Object other$memory = other.getMemory();
        if (this$memory == null ? other$memory != null : !this$memory.equals(other$memory))
            return false;
        final Object this$online = this.getOnline();
        final Object other$online = other.getOnline();
        if (this$online == null ? other$online != null : !this$online.equals(other$online))
            return false;
        final Object this$output = this.getOutput();
        final Object other$output = other.getOutput();
        if (this$output == null ? other$output != null : !this$output.equals(other$output))
            return false;
        final Object this$storage = this.getStorage();
        final Object other$storage = other.getStorage();
        if (this$storage == null ? other$storage != null : !this$storage.equals(other$storage))
            return false;
        final Object this$graphics = this.getGraphics();
        final Object other$graphics = other.getGraphics();
        if (this$graphics == null ? other$graphics != null : !this$graphics.equals(other$graphics))
            return false;
        final Object this$resolutions = this.getResolutions();
        final Object other$resolutions = other.getResolutions();
        if (this$resolutions == null ? other$resolutions != null : !this$resolutions.equals(other$resolutions))
            return false;
        final Object this$logo = this.getLogo();
        final Object other$logo = other.getLogo();
        if (this$logo == null ? other$logo != null : !this$logo.equals(other$logo)) return false;
        final Object this$summary = this.getSummary();
        final Object other$summary = other.getSummary();
        if (this$summary == null ? other$summary != null : !this$summary.equals(other$summary))
            return false;
        final Object this$releaseDates = this.getReleaseDates();
        final Object other$releaseDates = other.getReleaseDates();
        if (this$releaseDates == null ? other$releaseDates != null : !this$releaseDates.equals(other$releaseDates))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $slug = this.getSlug();
        result = result * PRIME + ($slug == null ? 43 : $slug.hashCode());
        final Object $cpu = this.getCpu();
        result = result * PRIME + ($cpu == null ? 43 : $cpu.hashCode());
        final Object $media = this.getMedia();
        result = result * PRIME + ($media == null ? 43 : $media.hashCode());
        final Object $memory = this.getMemory();
        result = result * PRIME + ($memory == null ? 43 : $memory.hashCode());
        final Object $online = this.getOnline();
        result = result * PRIME + ($online == null ? 43 : $online.hashCode());
        final Object $output = this.getOutput();
        result = result * PRIME + ($output == null ? 43 : $output.hashCode());
        final Object $storage = this.getStorage();
        result = result * PRIME + ($storage == null ? 43 : $storage.hashCode());
        final Object $graphics = this.getGraphics();
        result = result * PRIME + ($graphics == null ? 43 : $graphics.hashCode());
        final Object $resolutions = this.getResolutions();
        result = result * PRIME + ($resolutions == null ? 43 : $resolutions.hashCode());
        final Object $logo = this.getLogo();
        result = result * PRIME + ($logo == null ? 43 : $logo.hashCode());
        final Object $summary = this.getSummary();
        result = result * PRIME + ($summary == null ? 43 : $summary.hashCode());
        final Object $releaseDates = this.getReleaseDates();
        result = result * PRIME + ($releaseDates == null ? 43 : $releaseDates.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PlatformVersion;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.domain.platform.PlatformVersion(url=" + this.getUrl() + ", name=" + this.getName() + ", slug=" + this.getSlug() + ", cpu=" + this.getCpu() + ", media=" + this.getMedia() + ", memory=" + this.getMemory() + ", online=" + this.getOnline() + ", output=" + this.getOutput() + ", storage=" + this.getStorage() + ", graphics=" + this.getGraphics() + ", resolutions=" + this.getResolutions() + ", logo=" + this.getLogo() + ", summary=" + this.getSummary() + ", releaseDates=" + this.getReleaseDates() + ")";
    }
}
