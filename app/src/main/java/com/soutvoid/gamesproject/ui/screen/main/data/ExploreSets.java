package com.soutvoid.gamesproject.ui.screen.main.data;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import lombok.Data;

@Data
public class ExploreSets {

    private List<ExploreSetData> data;

    public ExploreSets(Object... objects) {
        data = Stream.of(objects).map(object -> (ExploreSetData) object).collect(Collectors.toList());
    }
}
