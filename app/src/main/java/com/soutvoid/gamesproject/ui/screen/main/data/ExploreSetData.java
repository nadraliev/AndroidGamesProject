package com.soutvoid.gamesproject.ui.screen.main.data;

import com.soutvoid.gamesproject.domain.game.Game;

import java.util.ArrayList;

public class ExploreSetData {

    private int position;
    private String name;
    private ArrayList<Game> games;


    public ExploreSetData(int position, String name, ArrayList<Game> games) {
        this.position = position;
        this.name = name;
        this.games = games;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Game> getGames() {
        return this.games;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.ui.screen.main.data.ExploreSetData(position=" + this.getPosition() + ", name=" + this.getName() + ", games=" + this.getGames() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ExploreSetData)) return false;
        final ExploreSetData other = (ExploreSetData) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getPosition() != other.getPosition()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$games = this.getGames();
        final Object other$games = other.getGames();
        if (this$games == null ? other$games != null : !this$games.equals(other$games))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPosition();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $games = this.getGames();
        result = result * PRIME + ($games == null ? 43 : $games.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ExploreSetData;
    }
}
