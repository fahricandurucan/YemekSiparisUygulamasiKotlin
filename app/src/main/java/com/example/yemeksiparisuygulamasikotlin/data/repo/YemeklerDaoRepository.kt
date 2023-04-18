package com.example.yemeksiparisuygulamasikotlin.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yemeksiparisuygulamasikotlin.data.entity.Yemekler

class YemeklerDaoRepository {

    var yemekListesi : MutableLiveData<List<Yemekler>>

    init {
        yemekListesi = MutableLiveData()
    }

    fun sepeteEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        Log.e("Sepete Ekle", "$yemek_adi - $yemek_fiyat - $yemek_siparis_adet")
    }
    fun yemeklerYukle(){
        val liste = ArrayList<Yemekler>()
        val y1 = Yemekler(1,"Ayran","download",12)
        val y2 = Yemekler(1,"Ayran","download",12)
        val y3 = Yemekler(1,"Ayran","download",12)
        val y4 = Yemekler(1,"Ayran","download",12)
        val y5 = Yemekler(1,"Ayran","download",12)
        val y6 = Yemekler(1,"Ayran","download",12)

        liste.add(y1)
        liste.add(y2)
        liste.add(y3)
        liste.add(y4)
        liste.add(y5)
        liste.add(y6)
        yemekListesi.value = liste
    }
    fun yemeklerGetir() : MutableLiveData<List<Yemekler>>{
        return  yemekListesi
    }
}