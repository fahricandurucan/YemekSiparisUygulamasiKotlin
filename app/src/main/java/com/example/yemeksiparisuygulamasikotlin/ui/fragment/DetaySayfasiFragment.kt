package com.example.yemeksiparisuygulamasikotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.yemeksiparisuygulamasikotlin.R
import com.example.yemeksiparisuygulamasikotlin.databinding.FragmentDetaySayfasiBinding

class DetaySayfasiFragment : Fragment() {
    private lateinit var binding: FragmentDetaySayfasiBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay_sayfasi, container, false)

        binding.toolbarDetay.title = "Yemek Adı"

        binding.button2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.yemekSepetGecis)
        }

        return binding.root
    }

}