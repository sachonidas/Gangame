package xyz.sachonidas.gangamesdk

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.junit.Assert
import org.junit.Test

/**
 * Created by sachonidas on 19/11/17.
 */
class RequestTest {

    @Test
    fun dealRequest_success(){
        val apiService = GangameApiService()
        //la funcion execute la va ejecutar inmediatamente
        val response = apiService.apiClient.getDeals().execute()
        val deals = response.body()

        val parser = JsonParser()
        //Sirve para parsear los elementos recibidos en la respuesto.
        val jsonResponse: JsonArray = parser.parse(MockResponses.DEALS_RESPONSE).asJsonArray

        Assert.assertTrue(response.isSuccessful)

        //Con el let podemos hacer lo mismo que con este if, comprobamos que la variable no es nula.
        /*if (deals != null) {
            Assert.assertEquals(deals.size, 4)
        }*/

        deals?.let {
            Assert.assertEquals(deals.size, jsonResponse.size())
            
            //Junta dos collecciones de elementos
            //usando lamdas
            deals.zip(jsonResponse).forEach { (deal, jsonDeal) ->
                //Todo a partir de las llaves es como un jsonObject
                with(jsonDeal.asJsonObject){
                    //Como es un jsonObject podemos acceder a sus datos como si el mismo fuese un Json
                    Assert.assertEquals(deal.title, this["title"].asString)
                    Assert.assertEquals(deal.metacriticScore, this["metacriticScore"].asInt)
                    Assert.assertEquals(deal.steamRating, this["steamRatingPercent"].asInt)
                    Assert.assertEquals(deal.thumb, this["thumb"].asString)
                }
            }
            
        }

    }

    @Test
    fun topTopRatedRequest_success(){
        val apiService = GangameApiService()
        //la funcion execute la va ejecutar inmediatamente
        val response = apiService.apiClient.getTopRatedGames().execute()
        val games = response.body()

        //Asi es como podemos deconstruir una DataClass para poder acceder mejor a sus elementos
        //que es lo mismo con el map. Se peuden omitir elementos con un _
        //val (title, publisher, rating, owners, price, thumb) = TopGame("", "", 0, 0, 0F, "")

        val parser = JsonParser()
        //por medio del map recibimos el jsonobject y lo creamos como una List
        val jsonResponse: List<JsonObject> = parser.parse(MockResponses.TOP_100_GAMES)
                .asJsonObject
                .entrySet()
                .map { (_, json) ->
                    json.asJsonObject
                }

        Assert.assertTrue(response.isSuccessful)

        //Con el let podemos hacer lo mismo que con este if, comprobamos que la variable no es nula.
        /*if (deals != null) {
            Assert.assertEquals(deals.size, 4)
        }*/

        games?.let {
            Assert.assertEquals(games.size, jsonResponse.size)

            //Junta dos collecciones de elementos
            //usando lamdas
            games.zip(jsonResponse).forEach { (topGame, jsonTopGame) ->
                //Todo a partir de las llaves es como un jsonObject
                with(jsonTopGame.asJsonObject){
                    //Como es un jsonObject podemos acceder a sus datos como si el mismo fuese un Json
                    Assert.assertEquals(topGame.title, this["name"].asString)
                    Assert.assertEquals(topGame.steamRating, this["score_rank"].asInt)
                    Assert.assertEquals(topGame.publisher, this["publisher"].asString)
                    Assert.assertEquals(topGame.owners, this["owners"].asInt)
                    Assert.assertEquals(topGame.thumb, "http://cdn.akamai.steamstatic.com/steam/apps/${this["appid"].asInt}/capsule_sm_120.jpg?t=1488471030")
                }
            }

        }

    }
}