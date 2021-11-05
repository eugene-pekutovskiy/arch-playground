package com.eugene.pekutovskyi.data

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TmdbApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val originalHttpUrl: HttpUrl = originalRequest.url
        val modifiedHttpUrl: HttpUrl = originalHttpUrl.newBuilder()
            .addQueryParameter(QUERY_PARAM_API_KEY, BuildConfig.THE_MOVIES_DB_API_KEY)
            .build()

        val rb: Request.Builder = originalRequest
            .newBuilder()
            .url(modifiedHttpUrl)

        return chain.proceed(rb.build())
    }

    private companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
    }
}
