
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Esrb implements Serializable {

    public String synopsis;
    public Integer rating;

}
