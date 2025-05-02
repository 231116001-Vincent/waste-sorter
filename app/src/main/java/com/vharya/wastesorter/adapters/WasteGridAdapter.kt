package com.vharya.wastesorter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.vharya.wastesorter.R
import com.vharya.wastesorter.models.WasteModel

class WasteGridAdapter(
    private val itemsImage: ArrayList<Int>,
    private val itemsName: ArrayList<String>,
    private val itemsCategory: ArrayList<String>,
) : BaseAdapter() {
    override fun getCount(): Int {
        return itemsName.size
    }

    override fun getItem(position: Int): Any {
        return itemsName[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if (convertView == null) {
            val inflater = LayoutInflater.from(parent!!.context)
            val view = inflater.inflate(R.layout.card_waste, parent, false)

            val imageView = view.findViewById<ImageView>(R.id.waste_image)
            val nameText = view.findViewById<TextView>(R.id.waste_name)
            val categoryText = view.findViewById<TextView>(R.id.waste_category)

            imageView.setImageResource(itemsImage[position])
            nameText.text = itemsName[position]
            categoryText.text = itemsCategory[position]

            when (itemsCategory[position]) {
                "Organik" -> {
                    view.setBackgroundResource(R.drawable.bg_card_organik)
                    categoryText.setBackgroundResource(R.drawable.bg_chip_organik)
                }
                "Anorganik" -> {
                    view.setBackgroundResource(R.drawable.bg_card_anorganik)
                    categoryText.setBackgroundResource(R.drawable.bg_chip_anorganik)
                }
                "B3" -> {
                    view.setBackgroundResource(R.drawable.bg_card_b3)
                    categoryText.setBackgroundResource(R.drawable.bg_chip_b3)
                }
            }

            return view
        }

        return convertView
    }
}