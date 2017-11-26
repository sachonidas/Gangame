package xyz.sachonidas.gangamesdk

import okhttp3.*

/**
 * Created by sachonidas on 29/10/17.
 */
class MockResponseInterceptor(val responses: HashMap<String, String>,
                              val defaultJsonResponse : String) : Interceptor{

    /*
    * Interceptor para poder examinar los datos de la peticion antes de que se conecte a internet
    * y la haga. Con lo que podemos manipularla antes de que llegue a nuestra aplicacion, con lo que
    * devuelve una respuesta sin conectarse a internet.
    */

    val MEDIA_TYPE_JSON = MediaType.parse("application/Json")

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = getResponseFor(request.url().toString())

        return Response.Builder()
                .body(ResponseBody.create(MEDIA_TYPE_JSON, response)) //que tipo de respuesta recibe
                .request(request) //el que recibe
                .protocol(Protocol.HTTP_1_0) // que tipo de protocolo utiliza
                .code(200) // el codigo que espera
                .message("Success") // mensaje a mostrar
                .build() // que construya
    }

    private fun getResponseFor(url: String) : String{
        return if(responses.containsKey(url))
            responses[url]!! //!! significa que siempre va a existir, osea que no va a ser nulo nunca
        else
            defaultJsonResponse
    }
}