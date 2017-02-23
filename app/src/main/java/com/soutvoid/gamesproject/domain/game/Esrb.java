
package com.soutvoid.gamesproject.domain.game;

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
        Field[] fields = getClass().getFields();
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

}
