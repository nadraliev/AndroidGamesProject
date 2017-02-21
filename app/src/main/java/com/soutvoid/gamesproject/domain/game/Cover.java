
package com.soutvoid.gamesproject.domain.game;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cover implements Serializable {

    public String url;
    public String cloudinaryId;
    public Integer width;
    public Integer height;

}
