package com.example.yemeksiparisuygulamasikotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasikotlin.R
import com.example.yemeksiparisuygulamasikotlin.data.entity.SepetYemekler
import com.example.yemeksiparisuygulamasikotlin.databinding.SepetYemekCardTasarimBinding

class SepetYemeklerAdapter(var mContext:Context,var sepetYemekListesi:List<SepetYemekler>)
    : RecyclerView.Adapter<SepetYemeklerAdapter.SepetYemekCardTasarimTutucu>(){


    inner class SepetYemekCardTasarimTutucu(var binding : SepetYemekCardTasarimBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetYemekCardTasarimTutucu {
        val binding : SepetYemekCardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.sepet_yemek_card_tasarim,parent,false)
        return SepetYemekCardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return sepetYemekListesi.size
    }

    override fun onBindViewHolder(holder: SepetYemekCardTasarimTutucu, position: Int) {
        val sepetYemek = sepetYemekListesi.get(position)
        val t = holder.binding
        t.imageViewSepet.setImageResource(mContext.resources.getIdentifier(sepetYemek.yemek_resim_adi,"drawable",mContext.packageName))
        t.tvSepetYemekAd.text = sepetYemek.yemek_adi
        t.tvSepetYemekFiyat.text = sepetYemek.yemek_fiyat.toString()
        t.tvSepetAdet.text = sepetYemek.yemek_siparis_adet.toString()
    }


}