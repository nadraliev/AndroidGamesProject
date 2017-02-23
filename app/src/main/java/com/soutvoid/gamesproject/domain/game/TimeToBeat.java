package com.soutvoid.gamesproject.domain.game;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by andrew on 2/23/17.
 */

@Data
@AllArgsConstructor
public class TimeToBeat {

    private Long hastly;
    private Long normally;
    private Long completely;

}
