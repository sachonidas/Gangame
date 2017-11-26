package xyz.sachonidas.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by sachonidas on 30/9/17.
 */

fun ViewGroup.inflate(layoutResId: Int, attachToRoot: Boolean = false ): View {
    val inflater = LayoutInflater.from(context)
    return inflater.inflate(layoutResId, this, attachToRoot)
}