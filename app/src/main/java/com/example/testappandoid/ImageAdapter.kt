package com.example.testappandoid

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.testappandoid.model.Donner

class ImageAdapter constructor(private val context: Context, private val images: MutableList<Donner>) :  BaseAdapter() {

    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        if(view == null) {
            val layoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.model, parent, false)
        }

        val card = view!!.findViewById<ImageView>(R.id.imageView)
        val name : TextView = view!!.findViewById(R.id.textView)

        Glide.with(context).load(images[position].image).into(card)
        Log.println(Log.INFO,"DonnerImage",images[position].image)

        name.text = images[position].text
        Log.println(Log.INFO,"DonnerText",images[position].text)

        return view
    }

}