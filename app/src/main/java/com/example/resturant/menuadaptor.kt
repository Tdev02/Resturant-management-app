package com.example.resturant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MenuAdapter(private val context: Context, private val dataSource: List<MenuItem>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.list_item_menu, parent, false)

        val nameTextView = rowView.findViewById(R.id.menu_item_name) as TextView
        val descriptionTextView = rowView.findViewById(R.id.menu_item_description) as TextView
        val priceTextView = rowView.findViewById(R.id.menu_item_price) as TextView

        val menuItem = getItem(position) as MenuItem

        nameTextView.text = menuItem.name
        descriptionTextView.text = menuItem.description
        priceTextView.text = "$${menuItem.price}"

        return rowView
    }
}

