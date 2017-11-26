package xyz.sachonidas.gangamesdk.serializer

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import xyz.sachonidas.gangamesdk.TopGame
import java.lang.reflect.Type

/**
 * Created by sachonidas on 19/11/17.
 */
class ListTopGameDeserializer : JsonDeserializer<ArrayList<TopGame>>{

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): ArrayList<TopGame> {
        val jsonTopGames =
                json.asJsonObject
                    .entrySet()
                    .map { (key, json) ->
                        json.asJsonObject
                    }
        val gson = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()

        val listTopGames: List<TopGame> = jsonTopGames.map { json ->
            gson.fromJson(json, TopGame::class.java)
        }

        val arrayListTopGames: ArrayList<TopGame> = arrayListOf()
        arrayListTopGames.addAll(listTopGames)

        return arrayListTopGames
    }
}