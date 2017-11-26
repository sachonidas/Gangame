package xyz.sachonidas.gangame.data

import xyz.sachonidas.gangamesdk.Deal

/**
 * Created by sachonidas on 24/11/17.
 */
object DealMapper {

    fun fromSdk(deal: xyz.sachonidas.gangamesdk.Deal): Deal{
        return Deal(
                deal.title,
                deal.salePrice,
                deal.normalPrice,
                deal.metacriticScore,
                deal.steamRating,
                deal.thumb)
    }
}