package com.soutvoid.gamesproject.domain.genre;

import com.soutvoid.gamesproject.interactor.util.RealmLong;
import com.soutvoid.gamesproject.interactor.util.RealmWrapUtils;

import java.io.Serializable;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Genre extends RealmObject implements Serializable {

    private Long id;
    private String name;
    private String slug;
    private String url;
    private Long createdAt;
    private Long updatedAt;
    private RealmList<RealmLong> games;

    public Genre() {
    }

    public Genre(Long id, String name, String slug, String url, Long createdAt, Long updatedAt, List<Long> games) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.games = RealmWrapUtils.wrapLongs(games);
    }
}
