package com.iittii.last.datasource.remote

import com.iittii.task5.util.Constants
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


