package com.vharya.wastesorter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vharya.wastesorter.R

class CategoryListAdapter(
    private val itemImages: ArrayList<Int>,
    private val itemNames: ArrayList<String>,
    private val onItemClicked: OnAdapterListener
) : RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_category, parent, false)
        return CategoryListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemNames.size
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.categoryImage.setImageResource(itemImages[position])
        holder.categoryName.text = itemNames[position]

        holder.itemView.setOnClickListener {
            onItemClicked.onItemClicked(itemNames[position])
        }

        when (itemNames[position]) {
            "Organik" -> holder.itemView.setBackgroundResource(R.drawable.bg_card_organik)
            "Anorganik" -> holder.itemView.setBackgroundResource(R.drawable.bg_card_anorganik)
            "B3" -> holder.itemView.setBackgroundResource(R.drawable.bg_card_b3)
        }
    }

    class CategoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage: ImageView = itemView.findViewById(R.id.category_image)
        val categoryName: TextView = itemView.findViewById(R.id.category_name)
    }

    interface OnAdapterListener {
        fun onItemClicked( categoryName:String )
    }
}