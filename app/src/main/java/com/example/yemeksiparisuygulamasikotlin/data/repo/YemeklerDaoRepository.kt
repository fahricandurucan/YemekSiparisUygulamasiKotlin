package com.example.yemeksiparisuygulamasikotlin.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yemeksiparisuygulamasikotlin.data.entity.*
import com.example.yemeksiparisuygulamasikotlin.retrofit.ApiUtils
import com.example.yemeksiparisuygulamasikotlin.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository {

    var ydao : YemeklerDao

    var yemekListesi : MutableLiveData<List<Yemekler>>
    var sepetYemekListesi : MutableLiveData<List<SepetYemekler>>

    init {
        sepetYemekListesi = MutableLiveData()
    }

    init {
        ydao = ApiUtils.getYemeklerDao()
        yemekListesi = MutableLiveData()
    }

    fun sepeteEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        ydao.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
            .enqueue(object : Callback<CRUDCevap>{
                override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {}
                override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
            })
    }
    fun yemeklerYukle(){
        ydao.tumYemekler().enqueue(object : Callback<YemeklerCevap>{
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body()!!.yemekler
                yemekListesi.value = liste
            }

            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {}
        })
//        val liste = ArrayList<Yemekler>()
//        val y1 = Yemekler(1,"Ayran","download",12)
//        val y2 = Yemekler(1,"Ayran","download",12)
//        val y3 = Yemekler(1,"Ayran","download",12)
//        val y4 = Yemekler(1,"Ayran","download",12)
//        val y5 = Yemekler(1,"Ayran","download",12)
//        val y6 = Yemekler(1,"Ayran","download",12)
//
//        liste.add(y1)
//        liste.add(y2)
//        liste.add(y3)
//        liste.add(y4)
//        liste.add(y5)
//        liste.add(y6)
//        yemekListesi.value = liste
    }
    fun yemeklerGetir() : MutableLiveData<List<Yemekler>>{
        return  yemekListesi
    }

    fun sepetYemekYukle(kullanici_adi: String){
        ydao.sepetYemekGetir(kullanici_adi).enqueue(object : Callback<SepetYemeklerCevap>{
            override fun onResponse(call: Call<SepetYemeklerCevap>, response: Response<SepetYemeklerCevap>) {
                val liste = response.body()!!.sepet_yemekler
                sepetYemekListesi.value = liste
            }

            override fun onFailure(call: Call<SepetYemeklerCevap>, t: Throwable) {}

        })
//        val liste = ArrayList<SepetYemekler>()
//        val s1 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
//        val s2 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
//        val s3 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
//        val s4 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
//        val s5 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
//        val s6 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
//
//        liste.add(s1)
//        liste.add(s2)
//        liste.add(s3)
//        liste.add(s4)
//        liste.add(s5)
//        liste.add(s6)
//        sepetYemekListesi.value = liste
    }

    fun sepetYemekGetir() : MutableLiveData<List<SepetYemekler>>{
        return sepetYemekListesi
    }

    fun sepetYemekSil(sepet_yemek_id:Int,kullanici_adi: String){
        ydao.sepetYemekSil(sepet_yemek_id,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                sepetYemekYukle(kullanici_adi) //anlık olarak arayüzde sildikten sonra değişiklik yapması için yazdık
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })

    }
}