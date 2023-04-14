package com.example.yemeksiparisuygulamasikotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.yemeksiparisuygulamasikotlin.R
import com.example.yemeksiparisuygulamasikotlin.databinding.FragmentDetaySayfasiBinding
import com.google.android.material.snackbar.Snackbar

class DetaySayfasiFragment : Fragment() {
    private lateinit var binding: FragmentDetaySayfasiBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay_sayfasi, container, false)


        val bundle:DetaySayfasiFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek

        binding.toolbarDetay.title = "Yemek Adı"
        binding.ivYemekResim.setImageResource(resources.getIdentifier(gelenYemek.yemek_resim_adi,"drawable",requireContext().packageName))
        binding.tvYemekAdi.text = gelenYemek.yemek_adi
        binding.tvYemekFiyat.text = gelenYemek.yemek_fiyat.toString()

        binding.buttonSepetEkle.setOnClickListener {
            Snackbar.make(it,"${gelenYemek.yemek_adi} sepete eklendi",Snackbar.LENGTH_LONG).show()
        }


        return binding.root
    }

}