package com.dhcc.csr.net

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @Author: wlsh
 * @Date: 2019/7/19 13:56
 * @Description: 接口
 */
interface ApiService {

    @FormUrlEncoded
    @POST("MobileLogin")
    fun loginObservable(
        @Field("userId") userId: String, @Field("ps") ps: String,
        @Field("type") type: String, @Field("deviceToken") deviceToken: String
    ): Observable<String>

    @FormUrlEncoded
    @POST("MobileLogin")
    fun loginNew(
        @Field("userId") userId: String, @Field("ps") ps: String,
        @Field("type") type: String, @Field("deviceToken") deviceToken: String
    ): Call<String>
}