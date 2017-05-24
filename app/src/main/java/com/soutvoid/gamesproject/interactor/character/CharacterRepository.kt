package com.soutvoid.gamesproject.interactor.character

import com.agna.ferro.mvp.component.scope.PerApplication
import com.soutvoid.gamesproject.domain.character.Character
import com.soutvoid.gamesproject.interactor.character.network.CharacterApi
import com.soutvoid.gamesproject.interactor.character.network.response.CharacterObj
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker
import com.soutvoid.gamesproject.interactor.util.*
import rx.Observable
import java.util.*
import javax.inject.Inject


@PerApplication
class CharacterRepository @Inject
constructor(private val characterApi: CharacterApi, private val networkConnectionChecker: NetworkConnectionChecker) {

    fun getCharacterById(id: Int, fields: Fields?): Observable<ArrayList<Character>> {
        return characterApi.getCharactersById(id, fields.toString())
                .flatMap { characterObjs -> Observable.just(TransformUtil.transformCollection<Character, CharacterObj>(characterObjs)) }

    }

    fun searchCharacters(searchQuery: String?,
                         fields: Fields?,
                         limit: Int,
                         offset: Int,
                         order: Order?): Observable<ArrayList<Character>> {
        return characterApi.searchForCharacters(fields.toString(), limit, offset, order.toString(), searchQuery)
                .flatMap { characterObjs -> Observable.just(TransformUtil.transformCollection<Character, CharacterObj>(characterObjs)) }
    }

    fun searchCharacters(searchQuery: String?,
                         fields: Fields?,
                         limit: Int,
                         offset: Int,
                         order: Order?,
                         filter: Filter?): Observable<ArrayList<Character>> {
        return characterApi.searchForCharacters(fields.toString(), limit, offset, order.toString(), searchQuery, filter?.toMap())
                .flatMap { characterObjs -> Observable.just(TransformUtil.transformCollection<Character, CharacterObj>(characterObjs)) }
    }

    fun searchCharacters(query: Query): Observable<ArrayList<Character>> {
        return searchCharacters(
                query.searchQuery,
                query.fields,
                query.limit,
                query.offset,
                query.order,
                query.filter)
    }

}
