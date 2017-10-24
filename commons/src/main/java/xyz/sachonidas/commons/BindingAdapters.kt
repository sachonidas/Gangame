package xyz.sachonidas.commons

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by sachonidas on 20/10/17.
 */

//Adaptador para poder asignar las urls de las imageviews

@BindingAdapter("imageUrl")
        fun loadImage(imageView: ImageView, url: String){
            Glide.with(imageView)
                    .load(url)
                    .into(imageView)
        }