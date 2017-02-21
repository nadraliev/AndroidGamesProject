
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReleaseDate implements Serializable {

    public Integer category;
    public Integer platform;
    public Long date;
    public Integer region;
    public String human;
    public Integer y;
    public Integer m;
}
