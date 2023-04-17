package com.example.yemeksiparisuygulamasikotlin.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.yemeksiparisuygulamasikotlin.R
import com.example.yemeksiparisuygulamasikotlin.data.entity.SepetYemekler
import com.example.yemeksiparisuygulamasikotlin.databinding.FragmentDetaySayfasiBinding
import com.google.android.material.snackbar.Snackbar

class DetaySayfasiFragment : Fragment() {
    private lateinit var binding: FragmentDetaySayfasiBinding
    val kullanici_adi = "qwdqwd"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay_sayfasi, container, false)

//        binding.detaySayfasiFragment = this
//        binding.detaySayfasiToolbarBaslik = "Yemek Detay"


        val bundle:DetaySayfasiFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek

//        binding.yemekNesnesi = gelenYemek

        binding.toolbarDetay.title = "Yemek Adı"
        binding.ivYemekResim.setImageResource(resources.getIdentifier(gelenYemek.yemek_resim_adi,"drawable",requireContext().packageName))
        binding.tvYemekAdi.text = gelenYemek.yemek_adi
        binding.tvYemekFiyat.text = gelenYemek.yemek_fiyat.toString()
        binding.textViewAdet.text = "1"


        binding.buttonSepetEkle.setOnClickListener {

        }

        binding.buttonSepeteGit.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.yemekSepetGecis)
        }

        binding.imageViewNegative.setOnClickListener {
            var x : String = binding.textViewAdet.text.toString()
            var y = x.toInt()
            if(y != 0){
                y = y - 1
            }
            binding.textViewAdet.text = y.toString()
        }

        binding.imageViewPlus.setOnClickListener {
            var x : String = binding.textViewAdet.text.toString()
            var y = x.toInt()
            y = y + 1
            binding.textViewAdet.text = y.toString()
        }


        return binding.root
    }


    fun sepeteEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        Log.e("Sepete Ekle", "$yemek_adi - $yemek_fiyat - $yemek_siparis_adet")
    }



}