/*
 * Copyright (c) 2021 Muhammad Aditya P. D.
 * You are prohibited to copy this source code without my permission
 * This project is intended for academic purpose only
 */
package com.example.listviewapp

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class LandmarkAdapter(
    context: Context,
    landmarks: ArrayList<HashMap<String, String>>,
) : BaseAdapter() {

    // Variabel untuk mengambil nilai dari parameter class
    var landmarkList = landmarks
    var context = context

    override fun getCount(): Int {
        return landmarkList.size
    }

    override fun getItem(position: Int): Any {
        return landmarkList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    // Fungsi untuk membuat Custom Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var myView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            val mInflater = (context as Activity).layoutInflater
            myView = mInflater.inflate(R.layout.list_item, parent, false)

            // Membuat object dari kelas ViewHolder
            holder = ViewHolder()

            // Menempatkan objek View dalam activity list_item.xml kedalam objek holder
            holder.mImageView = myView!!.findViewById<ImageView>(R.id.icon)
            holder.mHeader = myView.findViewById<TextView>(R.id.list_title)
            holder.mSubHeader = myView.findViewById<TextView>(R.id.list_desc)
        } else {
            holder = myView!!.tag as ViewHolder
        }

        val map = landmarkList.get(position)

        holder.mImageView!!.setImageResource(context.resources.getIdentifier(map.get("icon"), "drawable", context.packageName))
        holder.mHeader!!.text = map.get("name")
        holder.mSubHeader!!.text = map.get("subtitle")

        return myView
    }

    // Kelas untuk menyimpan View pada list_item.xml
    class ViewHolder {
        var mImageView: ImageView? = null
        var mHeader: TextView? = null
        var mSubHeader: TextView? = null
    }
}