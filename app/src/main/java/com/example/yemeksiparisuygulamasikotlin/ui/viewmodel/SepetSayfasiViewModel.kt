package com.example.yemeksiparisuygulamasikotlin.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasikotlin.data.entity.SepetYemekler
import com.example.yemeksiparisuygulamasikotlin.data.repo.YemeklerDaoRepository

class SepetSayfasiViewModel : ViewModel() {
    var repo = YemeklerDaoRepository()

    var sepetYemekListesi : MutableLiveData<List<SepetYemekler>>

    init {
        sepetYemekYukle()
        sepetYemekListesi = repo.sepetYemekGetir()
    }

    fun sepetYemekYukle(){
        repo.sepetYemekYukle()
    }

}