package com.example.yemeksiparisuygulamasikotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.yemeksiparisuygulamasikotlin.R
import com.example.yemeksiparisuygulamasikotlin.databinding.FragmentSepetSayfasiBinding

class SepetSayfasiFragment : Fragment() {
    private lateinit var binding: FragmentSepetSayfasiBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet_sayfasi, container, false)

        return binding.root
    }

}