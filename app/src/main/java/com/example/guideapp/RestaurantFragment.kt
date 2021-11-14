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
import com.example.guideapp.databinding.FragmentRestaurantBinding
import com.example.guideapp.items.ItemAdapter
import com.example.guideapp.items.Items

class RestaurantFragment : Fragment(), RecyclerLocationClick, RecyclerNumberClick {
    lateinit var binding: FragmentRestaurantBinding
    private val adapter by lazy { ItemAdapter(requireContext(), this, this) }
    private val imageList by lazy{
        mutableListOf(R.drawable.res_buhara, R.drawable.res_faiza, R.drawable.res_navat, R.drawable.res_supara)
    }

    private val itemList by lazy {
        mutableListOf(
            Items(getString(R.string.buhara_info),
                getString(R.string.buhara),
                getString(R.string.buhara_contact),
                getString(R.string.buhara_location),
                getString(R.string.buhara_location_url)),
            Items(getString(R.string.faiza_info),
                getString(R.string.faiza),
                getString(R.string.faiza_contact),
                getString(R.string.faiza_location),
                getString(R.string.faiza_location_url)),
            Items(getString(R.string.navat_info),
                getString(R.string.navat),
                getString(R.string.navat_contact),
                getString(R.string.navat_location),
                getString(R.string.navat_location_url)),
            Items(getString(R.string.supara_info),
                getString(R.string.supara),
                getString(R.string.supara_contact),
                getString(R.string.supara_location),
                getString(R.string.supara_location_url)))
     }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_restaurant, container, false)
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
