package com.example.yemeksiparisuygulamasikotlin.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasikotlin.data.repo.YemeklerDaoRepository

class DetaySayfasiViewModel : ViewModel() {

    val repo = YemeklerDaoRepository()

    fun sepeteEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        repo.sepeteEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
    }
}