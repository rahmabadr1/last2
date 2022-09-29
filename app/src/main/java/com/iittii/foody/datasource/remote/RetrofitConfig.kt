package com.iittii.foody.datasource.remote

import com.iittii.foody.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitConfig {
    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

    }

    fun getServiceInstance(): ApiService {
        return getRetrofitInstance().create<ApiService>()
    }
}


