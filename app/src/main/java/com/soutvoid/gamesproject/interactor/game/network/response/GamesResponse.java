package com.soutvoid.gamesproject.interactor.game.network.response;

import com.soutvoid.gamesproject.interactor.common.network.response.BaseResponse;

import java.util.List;

import lombok.Data;

/**
 * Created by andrew on 2/21/17.
 */

@Data
public class GamesResponse extends BaseResponse {

    List<GameObj> gameObjList;

}
