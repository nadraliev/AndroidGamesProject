
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;
import java.lang.reflect.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cover implements Serializable {

    public String url;
    public String cloudinaryId;
    public Integer width;
    public Integer height;

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
