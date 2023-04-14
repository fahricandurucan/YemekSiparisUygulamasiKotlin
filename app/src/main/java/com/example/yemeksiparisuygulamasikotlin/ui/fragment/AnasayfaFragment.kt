package com.example.yemeksiparisuygulamasikotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.yemeksiparisuygulamasikotlin.R
import com.example.yemeksiparisuygulamasikotlin.data.entity.Yemekler
import com.example.yemeksiparisuygulamasikotlin.databinding.FragmentAnasayfaBinding
import com.example.yemeksiparisuygulamasikotlin.ui.adapter.YemeklerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)

        binding.toolbarAnasayfa.title = "Yemekler Listesi"

        binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val yemeklerListesi = ArrayList<Yemekler>()
        val y1 = Yemekler(1,"Ayran","download",12)
        val y2 = Yemekler(1,"Ayran","download",12)
        val y3 = Yemekler(1,"Ayran","download",12)
        val y4 = Yemekler(1,"Ayran","download",12)
        val y5 = Yemekler(1,"Ayran","download",12)
        val y6 = Yemekler(1,"Ayran","download",12)

        yemeklerListesi.add(y1)
        yemeklerListesi.add(y2)
        yemeklerListesi.add(y3)
        yemeklerListesi.add(y4)
        yemeklerListesi.add(y5)
        yemeklerListesi.add(y6)

        val adapter = YemeklerAdapter(requireContext(),yemeklerListesi)
        binding.rv.adapter = adapter


        return binding.root
    }
}