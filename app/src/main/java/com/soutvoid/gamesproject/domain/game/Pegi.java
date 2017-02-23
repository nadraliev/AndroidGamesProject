
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.lang.reflect.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pegi implements Serializable {

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

    public int getMinimumAge() {
        switch (rating) {
            case 1:
                return 3;
            case 2:
                return 7;
            case 3:
                return 12;
            case 4:
                return 16;
            case 5:
                return 18;
        }
        return -1;
    }

}
