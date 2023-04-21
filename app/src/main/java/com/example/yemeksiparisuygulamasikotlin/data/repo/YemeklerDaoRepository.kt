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

    }
    fun yemeklerGetir() : MutableLiveData<List<Yemekler>>{
        return  yemekListesi
    }

    fun sepetYemekYukle(kullanici_adi: String){
        Log.e("xxx","yyy")
        ydao.sepetYemekGetir(kullanici_adi).enqueue(object : Callback<SepetYemeklerCevap>{
            override fun onResponse(call: Call<SepetYemeklerCevap>, response: Response<SepetYemeklerCevap>) {
                val liste = response.body()!!.sepet_yemekler
                sepetYemekListesi.value = liste
            }

            override fun onFailure(call: Call<SepetYemeklerCevap>, t: Throwable) {
                //silme kısmında son elemanı silerken sayfa değişikliği yapınca görebiliyordum silindigini
                //bu kod o sorunu çözdü
                sepetYemekListesi.value = ArrayList<SepetYemekler>()
            }

        })
    }

    fun sepetYemekGetir() : MutableLiveData<List<SepetYemekler>>{
        return sepetYemekListesi
    }

    fun sepetYemekSil(sepet_yemek_id:Int,kullanici_adi: String){
        if (sepetYemekListesi.value?.size == 1){

        }
        ydao.sepetYemekSil(sepet_yemek_id,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                sepetYemekYukle(kullanici_adi) //anlık olarak arayüzde sildikten sonra değişiklik yapması için yazdık
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {}
        })

    }


    fun ara(aramaKelimesi:String){
        var liste = yemekListesi.value
        var filter = liste!!.filter { (it.yemek_adi).toLowerCase().contains(aramaKelimesi.toLowerCase()) }
        yemekListesi.value = filter
    }









}