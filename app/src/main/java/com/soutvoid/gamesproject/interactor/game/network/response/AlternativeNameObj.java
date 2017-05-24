package com.soutvoid.gamesproject.interactor.game.network.response;

import com.google.gson.annotations.SerializedName;
import com.soutvoid.gamesproject.domain.game.AlternativeName;
import com.soutvoid.gamesproject.util.Transformable;

/**
 * Created by andrew on 2/21/17.
 */

public class AlternativeNameObj implements Transformable<AlternativeName> {

    @SerializedName("name")
    public String name;
    @SerializedName("comment")
    public String comment;

    public AlternativeNameObj() {
    }

    @Override
    public AlternativeName transform() {
        return new AlternativeName(
                name,
                comment
        );
    }

    public String getName() {
        return this.name;
    }

    public String getComment() {
        return this.comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof AlternativeNameObj)) return false;
        final AlternativeNameObj other = (AlternativeNameObj) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$comment = this.getComment();
        final Object other$comment = other.getComment();
        if (this$comment == null ? other$comment != null : !this$comment.equals(other$comment))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $comment = this.getComment();
        result = result * PRIME + ($comment == null ? 43 : $comment.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AlternativeNameObj;
    }

    public String toString() {
        return "com.soutvoid.gamesproject.interactor.game.network.response.AlternativeNameObj(name=" + this.getName() + ", comment=" + this.getComment() + ")";
    }
}
