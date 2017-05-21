package com.soutvoid.gamesproject.interactor.util;

import io.realm.RealmObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ExploreQuery extends RealmObject {

    private int position;
    private String name;
    private Query query;

}
