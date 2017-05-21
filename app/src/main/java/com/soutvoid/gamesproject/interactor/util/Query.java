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
public class Query extends RealmObject {

    private String searchQuery;
    private Fields fields;
    private int limit = 20;
    private int offset;
    private Order order;
    private Filter filter;

}
