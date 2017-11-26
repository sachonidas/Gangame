package xyz.sachonidas.gangamesdk

import retrofit2.Retrofit

/**
 * Created by sachonidas on 12/11/17.
 */
interface GangameApiConfig {

    fun setupConfig(builder : Retrofit.Builder)
}