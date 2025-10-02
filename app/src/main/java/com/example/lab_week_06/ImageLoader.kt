package com.example.lab_week_06

import android.content.Context
import android.widget.ImageView

interface ImageLoader {
    fun loadImage(context: Context, url: String, imageView: ImageView)
}
