package xyz.sachonidas.gangamesdk

/**
 * Created by sachonidas on 29/10/17.
 */
object Routes {

    const val CHEAP_SHARK_STEAM_STORE = "1"

    const val BASE_URL = "https://steamspy.com/api.php/"
    const val BASE_URL_STEAM_SPY = "https://steamspy.com/api.php"
    const val BASE_URL_CHEAP_SHARK= "https://cheapshark.com/api/1.0"

    //Se crea en tiempo compilación
    const val GET_TOP_100_GAMES = BASE_URL_STEAM_SPY + "?request=top100gamesin2weeks"
    const val GET_MOST_OWNED_GAMES = BASE_URL_STEAM_SPY + "?request=top100owned"
    const val GET_DEALS = BASE_URL_CHEAP_SHARK + "/deals?storeID=" + CHEAP_SHARK_STEAM_STORE

}