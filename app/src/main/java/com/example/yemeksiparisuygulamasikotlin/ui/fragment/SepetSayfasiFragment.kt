package com.example.yemeksiparisuygulamasikotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksiparisuygulamasikotlin.R
import com.example.yemeksiparisuygulamasikotlin.data.entity.SepetYemekler
import com.example.yemeksiparisuygulamasikotlin.databinding.FragmentSepetSayfasiBinding
import com.example.yemeksiparisuygulamasikotlin.ui.adapter.SepetYemeklerAdapter
import com.example.yemeksiparisuygulamasikotlin.ui.viewmodel.SepetSayfasiViewModel

class SepetSayfasiFragment : Fragment() {
    private lateinit var binding: FragmentSepetSayfasiBinding
    private lateinit var viewModel:SepetSayfasiViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet_sayfasi, container, false)

        binding.rvSepet.layoutManager = LinearLayoutManager(requireContext())

        val sepetYemekListesi = ArrayList<SepetYemekler>()
        val s1 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
        val s2 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
        val s3 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
        val s4 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
        val s5 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")
        val s6 = SepetYemekler(1,"Ayran","download",10,2,"qwdqw")

        sepetYemekListesi.add(s1)
        sepetYemekListesi.add(s2)
        sepetYemekListesi.add(s3)
        sepetYemekListesi.add(s4)
        sepetYemekListesi.add(s5)
        sepetYemekListesi.add(s6)

        val adapter = SepetYemeklerAdapter(requireContext(),sepetYemekListesi)
        binding.rvSepet.adapter = adapter


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:SepetSayfasiViewModel by viewModels()
        viewModel = tempViewModel
    }

}