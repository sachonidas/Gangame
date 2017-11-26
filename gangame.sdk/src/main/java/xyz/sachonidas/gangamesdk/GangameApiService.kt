package xyz.sachonidas.gangamesdk

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import xyz.sachonidas.gangamesdk.serializer.ListTopGameDeserializer
import xyz.sachonidas.gangamesdk.serializer.TopGameDeserializer

/**
 * Created by sachonidas on 29/10/17.
 */
class GangameApiService(val apiConfig: GangameApiConfig = GangameClientConfig()) {

    val apiClient : RetrofitGangameApi

    //Configuracion del cliente

    init {
        //Token para identificar el tipo de datos de un array list
        val tokenType = object: TypeToken<ArrayList<TopGame>>(){}.type

        val gson = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .registerTypeAdapter(tokenType, ListTopGameDeserializer())
                .create()

        val apiClientConfig =
                Retrofit.Builder()
                    .baseUrl(Routes.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //se crea el adaptador para recibir flujo de datos.


        apiConfig.setupConfig(apiClientConfig)


        //Regresa la clase de la api
        apiClient = apiClientConfig.build().create(RetrofitGangameApi::class.java)

    }
}