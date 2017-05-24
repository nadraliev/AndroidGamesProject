package com.soutvoid.gamesproject.interactor.util;

import io.realm.RealmObject;

public class ExploreQuery extends RealmObject {

    private int position;
    private String name;
    private Query query;


    public ExploreQuery(int position, String name, Query query) {
        this.position = position;
        this.name = name;
        this.query = query;
    }

    public ExploreQuery() {
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public Query getQuery() {
        return this.query;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.util.ExploreQuery(position=" + this.getPosition() + ", name=" + this.getName() + ", query=" + this.getQuery() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ExploreQuery)) return false;
        final ExploreQuery other = (ExploreQuery) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPosition() != other.getPosition()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$query = this.getQuery();
        final Object other$query = other.getQuery();
        if (this$query == null ? other$query != null : !this$query.equals(other$query))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPosition();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $query = this.getQuery();
        result = result * PRIME + ($query == null ? 43 : $query.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ExploreQuery;
    }
}
