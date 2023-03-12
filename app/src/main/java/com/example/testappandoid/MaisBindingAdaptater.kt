package com.example.testappandoid

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("loadImageUrl")
fun ImageView.loadImageUrl(url:String){
    Glide.with(context).load(url).into(this).view.animate().start()
}