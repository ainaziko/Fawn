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
import com.example.guideapp.databinding.FragmentMallBinding
import com.example.guideapp.items.ItemAdapter
import com.example.guideapp.items.Items

class MallFragment : Fragment(), RecyclerLocationClick, RecyclerNumberClick {
    lateinit var binding: FragmentMallBinding
    private val adapter by lazy { ItemAdapter(requireContext(), this, this) }
    private val imageList by lazy{
        mutableListOf(R.drawable.res_buhara, R.drawable.mall_bishkekpark, R.drawable.res_navat, R.drawable.res_supara)
    }

    private val itemList by lazy {
        mutableListOf(
            Items(getString(R.string.plaza_info),
                getString(R.string.plaza),
                getString(R.string.plaza_contact),
                getString(R.string.plaza_location),
                getString(R.string.plaza_location_url)),
            Items(getString(R.string.bishkek_park_info),
                getString(R.string.bishkek_park),
                getString(R.string.bishkek_park_contact),
                getString(R.string.bishkek_park_location),
                getString(R.string.bishkek_park_location_url)),
            Items(getString(R.string.asiamall_info),
                getString(R.string.asiamall),
                getString(R.string.asiamall_contact),
                getString(R.string.asiamall_location),
                getString(R.string.asiamall_location_url)),
            Items(getString(R.string.ala_archa_info),
                getString(R.string.ala_archa),
                getString(R.string.ala_archa_contact),
                getString(R.string.ala_archa_location),
                getString(R.string.ala_archa_location_url)))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mall, container, false)
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
