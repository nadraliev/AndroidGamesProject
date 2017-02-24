package com.soutvoid.gamesproject.domain.platform;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlatformVersionReleaseDate implements Serializable {

    private Long date;
    private Long region;

}
