package com.soutvoid.gamesproject.interactor.character;

import com.soutvoid.gamesproject.domain.character.Character;
import com.soutvoid.gamesproject.interactor.character.network.CharacterApi;
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by andrew on 22-Feb-17.
 */

public class CharacterRepository {

    private CharacterApi characterApi;
    private NetworkConnectionChecker networkConnectionChecker;

    @Inject
    public CharacterRepository(CharacterApi characterApi, NetworkConnectionChecker networkConnectionChecker) {
        this.characterApi = characterApi;
        this.networkConnectionChecker = networkConnectionChecker;
    }

    public Observable<ArrayList<Character>> getCharacterById(int id) {
        return characterApi.getCharactersById(id)
                .flatMap(characterObjs ->  Observable.just(TransformUtil.transformCollection(characterObjs)));

    }

    public Observable<ArrayList<Character>> getCharacters(String searchQuery) {
        return characterApi.searchForCharacters("*", 20, 0, "release_dates.date:desc", searchQuery)   //TODO поменять статичные параметры на enum
                .flatMap(characterObjs ->  Observable.just(TransformUtil.transformCollection(characterObjs)));
    }

}
