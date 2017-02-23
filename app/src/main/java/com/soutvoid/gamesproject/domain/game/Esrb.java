
package com.soutvoid.gamesproject.domain.game;

import com.soutvoid.gamesproject.domain.game.enums.EsrbRating;

import java.io.Serializable;
import java.lang.reflect.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Esrb implements Serializable {

    public String synopsis;
    public Integer rating;

    @Override
    public String toString() {
        String result = "";
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            try {
                result += field.getName() + ": " + field.get(this).toString() + "\n";
            } catch (IllegalAccessException | NullPointerException e) {
                //ignore
            }
        }
        return result;
    }

    public String getStringRating() {
        return EsrbRating.values()[rating].toString().toLowerCase().replace("_", " ");
    }

}
