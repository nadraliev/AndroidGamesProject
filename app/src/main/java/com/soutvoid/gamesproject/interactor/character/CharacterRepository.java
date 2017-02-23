package com.soutvoid.gamesproject.interactor.character;

import com.soutvoid.gamesproject.domain.character.Character;
import com.soutvoid.gamesproject.interactor.character.network.CharacterApi;
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker;
import com.soutvoid.gamesproject.interactor.util.TransformUtil;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    public Observable<ArrayList<Character>> getCharacterById(int id, String fields) {
        return characterApi.getCharactersById(id, fields)
                .flatMap(characterObjs -> Observable.just(TransformUtil.transformCollection(characterObjs)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Observable<ArrayList<Character>> searchCharacters(String searchQuery,
                                                             String fields,
                                                             int limit,
                                                             int offset,
                                                             String order) {
        return characterApi.searchForCharacters(fields, limit, offset, order, searchQuery)
                .flatMap(characterObjs -> Observable.just(TransformUtil.transformCollection(characterObjs)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ArrayList<Character>> searchCharactersWithFilters(String searchQuery,
                                                                        String fields,
                                                                        int limit,
                                                                        int offset,
                                                                        String order,
                                                                        Map<String, String> filters) {
        return characterApi.searchForCharacters(fields, limit, offset, order, searchQuery, filters)
                .flatMap(characterObjs -> Observable.just(TransformUtil.transformCollection(characterObjs)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
