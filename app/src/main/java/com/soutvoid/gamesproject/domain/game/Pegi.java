
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pegi implements Serializable {

    public Integer rating;

}
