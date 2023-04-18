package com.example.yemeksiparisuygulamasikotlin.retrofit

import com.example.yemeksiparisuygulamasikotlin.data.entity.CRUDCevap
import com.example.yemeksiparisuygulamasikotlin.data.entity.SepetYemeklerCevap
import com.example.yemeksiparisuygulamasikotlin.data.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    // http://kasimadalan.pe.hu/    -> base url
    //yemekler/tumYemekleriGetir.php

    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() : Call<YemeklerCevap>


    @POST("yemekler/sepeteYemekEkle.php")  //veri istedigi için post
    @FormUrlEncoded
    fun sepeteYemekEkle(@Field("yemek_adi") yemek_adi:String,
                        @Field("yemek_resim_adi") yemek_resim_adi:String,
                        @Field("yemek_fiyat") yemek_fiyat:Int,
                        @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                        @Field("kullanici_adi") kullanici_adi:String) : Call<CRUDCevap>

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun sepetYemekGetir(@Field("kullanici_adi") kullanici_adi:String) : Call<SepetYemeklerCevap>

}