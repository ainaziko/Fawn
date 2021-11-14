package com.example.guideapp.items

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.guideapp.R
import com.example.guideapp.RecyclerLocationClick
import com.example.guideapp.RecyclerNumberClick
import com.example.guideapp.databinding.CardBinding

class ItemAdapter(private val context: Context, private val locationClicker: RecyclerLocationClick, private val numberClicker: RecyclerNumberClick): RecyclerView.Adapter<ItemAdapter.ItemHolder>() {


    private var list = mutableListOf<Items>()
    fun setList (list : MutableList<Items>){
        this.list = list
    }

    private var imageList = mutableListOf<Int>()
    fun setImageList(imageList: MutableList<Int>){
        this.imageList = imageList
    }

    class ItemHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = CardBinding.bind(item)

        fun bind(items: Items) = with(binding){
            description.text = items.description
            title.text = items.title
            number.text = items.phone_number
            location.text = items.locationName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from((parent.context)).inflate(R.layout.card, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(list[position])
        //code to make card expand when clicked
        val isExpanded: Boolean = list[position].expanded
        with(holder.binding){
            expandedLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE
            expandable.setOnClickListener {
                val items = list[position]
                items.expanded = !items.expanded
                notifyItemChanged(position)
            }
            number.setOnClickListener {
                numberClicker.recyclerNumberClicked(list[position])
            }
            location.setOnClickListener {
                locationClicker.recyclerLocationClicked(list[position])
            }
            Glide.with(context)
                .load(imageList[position])
                .into(holder.binding.im)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}