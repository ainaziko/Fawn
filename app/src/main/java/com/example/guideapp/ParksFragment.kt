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

class ParksFragment : Fragment(), RecyclerLocationClick, RecyclerNumberClick {
    lateinit var binding: FragmentCinemaBinding
    private val adapter by lazy { ItemAdapter(requireContext(), this, this) }
    private val imageList by lazy {
        mutableListOf(R.drawable.megaland, R.drawable.illusion, R.drawable.skypark)
    }

    private val itemList by lazy {
        mutableListOf(
            Items(getString(R.string.megaland_info),
                getString(R.string.megaland),
                getString(R.string.megaland_contact),
                getString(R.string.megaland_location),
                getString(R.string.megaland_location_url)),
            Items(getString(R.string.illusion_info),
                getString(R.string.illusion),
                getString(R.string.illusion_contact),
                getString(R.string.illusion_location),
                getString(R.string.illusion_location_url)),
            Items(getString(R.string.skypark_info),
                getString(R.string.skypark),
                getString(R.string.skypark_contact),
                getString(R.string.skypark_location),
                getString(R.string.skypark_location_url)))
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
