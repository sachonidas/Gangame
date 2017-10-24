package xyz.sachonidas.gangame

/**
 * Created by sachonidas on 18/10/17.
 */

object PriceFormatter {
    val FORMAT_PRICE = "$%.2f"
    fun priceFormatted(price : Float) = String.format(FORMAT_PRICE, price)

}

data class Deal(var title: String,
                var salePrice : Float,
                var normalPrice : Float,
                var metacriticScore : Int,
                var steamRating : Int,
                var thumb : String){

    val salePriceFormated : String
    get() = PriceFormatter.priceFormatted(salePrice)

    val normalPriceFormated : String
    get() = PriceFormatter.priceFormatted(normalPrice)

}

data class TopGame(var title : String,
                   var owners : Int,
                   var steamRating: Int,
                   var publisher : String,
                   var price: Float,
                   var position: Int,
                   var thumb: String){

    val priceFormated : String
    get() = PriceFormatter.priceFormatted(price)
}

