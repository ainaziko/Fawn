package com.example.guideapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guideapp.databinding.FragmentCinemaBinding
import com.example.guideapp.items.ItemAdapter
import com.example.guideapp.items.Items

class CinemaFragment : Fragment(), RecyclerLocationClick, RecyclerNumberClick {
    lateinit var binding: FragmentCinemaBinding
    private val adapter by lazy { ItemAdapter(requireContext(), this, this) }
    private val imageList by lazy {
        mutableListOf(R.drawable.cin_russia, R.drawable.cin_cosmo_park, R.drawable.cin_ala_too, R.drawable.cin_october)
    }

    private val itemList by lazy {
        mutableListOf(
            Items(getString(R.string.alatoo_info),
                getString(R.string.alatoo),
                getString(R.string.alatoo_contact),
                getString(R.string.alatoo_location),
                getString(R.string.alatoo_location_url)),
            Items(getString(R.string.cosmo_park_info),
                getString(R.string.cosmo_park),
                getString(R.string.cosmo_park_contact),
                getString(R.string.cosmo_park_location),
                getString(R.string.cosmo_park_location_url)),
            Items(getString(R.string.october_info),
                getString(R.string.october),
                getString(R.string.october_contact),
                getString(R.string.october_location),
                getString(R.string.october_location_url)),
            Items(getString(R.string.russia_info),
                getString(R.string.russia),
                getString(R.string.russia_contact),
                getString(R.string.russia_location),
                getString(R.string.russia_location_url)))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cinema, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.apply {
            rcView.adapter = adapter
            rcView.layoutManager = LinearLayoutManager(requireContext())
        }
        adapter.setList(itemList)
        adapter.setImageList(imageList)
    }

    override fun recyclerLocationClicked(item: Items) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.location))
        startActivity(intent)
    }

    override fun recyclerNumberClicked(item: Items) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("call:${item.phone_number}"))
        startActivity(intent)
    }

}
