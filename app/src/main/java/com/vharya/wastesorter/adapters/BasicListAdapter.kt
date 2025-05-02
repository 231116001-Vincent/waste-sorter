package com.vharya.wastesorter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.vharya.wastesorter.R

class BasicListAdapter(
    private val items: ArrayList<String>
) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if (convertView == null) {
            val inflater = LayoutInflater.from(parent!!.context)
            val view = inflater.inflate(R.layout.basic_list_item, parent, false)

            val textView: TextView = view.findViewById(R.id.list_item_text)
            textView.text = "•  ${items[position]}"

            return view
        }

        return convertView
    }
}