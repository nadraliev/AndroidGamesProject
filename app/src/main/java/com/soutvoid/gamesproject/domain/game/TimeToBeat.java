package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.lang.reflect.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by andrew on 2/23/17.
 */

@Data
@AllArgsConstructor
public class TimeToBeat implements Serializable {

    private Long hastly;
    private Long normally;
    private Long completely;

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

}
