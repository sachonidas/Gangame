package xyz.sachonidas.gangame.data

import xyz.sachonidas.gangame.TopGame

/**
 * Created by sachonidas on 24/11/17.
 */
object TopGameMapper {

    fun fromSdk(topGame: xyz.sachonidas.gangamesdk.TopGame, postion: Int): TopGame{
        return TopGame(
                topGame.title,
                topGame.owners,
                topGame.steamRating,
                topGame.publisher,
                topGame.price,
                postion,
                topGame.thumb)
    }

}