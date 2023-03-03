package com.dev_akash.carousellnews.utils

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dev_akash.carousellnews.R

fun AppCompatImageView.loadImage(url:String?){
    Glide.with(this.context)
        .load(url)
        .placeholder(R.drawable.placeholder)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}