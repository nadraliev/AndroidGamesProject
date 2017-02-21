
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlternativeName implements Serializable {

    public String name;
    public String comment;

}
