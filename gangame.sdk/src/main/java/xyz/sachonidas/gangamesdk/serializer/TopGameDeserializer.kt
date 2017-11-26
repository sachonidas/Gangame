package xyz.sachonidas.gangamesdk.serializer

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import xyz.sachonidas.gangamesdk.TopGame
import java.lang.reflect.Type

/**
 * Created by sachonidas on 29/10/17.
 */
class TopGameDeserializer : JsonDeserializer<TopGame> {

    //a partir de esto todo va a ser estatico
    companion object {
        const val BASE_IMG_URL = "http://cdn.akamai.steamstatic.com/steam/apps/%s/capsule_sm_120.jpg?t=1488471030"
    }

    //Deserializador con el que obtenemos la url de la imagen con el id que tiene el JSON devuelve
    //en el request.

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): TopGame {
        val gson = Gson()

        val topGame = gson.fromJson(json, TopGame::class.java)
        val appId = json.asJsonObject["appid"].asInt.toString() //Es lo mismo que hacerlo con un get("appid")

        val thumb = String.format(BASE_IMG_URL, appId)

        topGame.thumb = thumb
        return topGame
    }

}