package com.soutvoid.gamesproject.app.dagger;

import android.content.Context;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.soutvoid.gamesproject.interactor.character.CharacterModule;
import com.soutvoid.gamesproject.interactor.character.CharacterRepository;
import com.soutvoid.gamesproject.interactor.collection.CollectionModule;
import com.soutvoid.gamesproject.interactor.collection.CollectionRepository;
import com.soutvoid.gamesproject.interactor.common.network.NetworkModule;
import com.soutvoid.gamesproject.interactor.common.network.OkHttpModule;
import com.soutvoid.gamesproject.interactor.company.CompanyModule;
import com.soutvoid.gamesproject.interactor.company.CompanyRepository;
import com.soutvoid.gamesproject.interactor.franchise.FranchiseModule;
import com.soutvoid.gamesproject.interactor.franchise.FranchiseRepository;
import com.soutvoid.gamesproject.interactor.game.GameModule;
import com.soutvoid.gamesproject.interactor.game.GameRepository;
import com.soutvoid.gamesproject.interactor.genre.GenreModule;
import com.soutvoid.gamesproject.interactor.genre.GenreRepository;
import com.soutvoid.gamesproject.interactor.keyword.KeywordModule;
import com.soutvoid.gamesproject.interactor.keyword.KeywordRepository;
import com.soutvoid.gamesproject.interactor.network.connection.NetworkConnectionChecker;
import com.soutvoid.gamesproject.interactor.person.PersonModule;
import com.soutvoid.gamesproject.interactor.person.PersonRepository;

import dagger.Component;

/**
 * Created by andrew on 2/20/17.
 */
@PerApplication
@Component(modules = {
        AppModule.class,
        OkHttpModule.class,
        NetworkModule.class,
        GameModule.class,
        CharacterModule.class,
        CollectionModule.class,
        CompanyModule.class,
        FranchiseModule.class,
        GenreModule.class,
        KeywordModule.class,
        PersonModule.class
})
public interface AppComponent {
    Context context();
    NetworkConnectionChecker networkConnectionChecker();
    GameRepository gameRepository();
    CharacterRepository characterRepository();
    CollectionRepository collectionRepository();
    CompanyRepository companyRepository();
    FranchiseRepository franchiseRepository();
    GenreRepository genreRepository();
    KeywordRepository keywordRepository();

    PersonRepository personRepository();
}
