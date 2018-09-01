package com.lxj.qingframe.exts

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * ImageView相关扩展，主要是封装了Glide相关扩展
 */

fun ImageView.load(url: String,
                   asGif: Boolean = false,
                   placeHolderRes: Int = 0,
                   placeHolderDrawable: Drawable? = null,
                   errorRes: Int = 0,
                   errorDrawable: Drawable? = null,
                   roundedValue: Int = 0,
                   noFade: Boolean = true
) {
    val options = RequestOptions().centerCrop()
    if (placeHolderRes != 0) {
        options.placeholder(placeHolderRes)
    }
    if (placeHolderDrawable != null) {
        options.placeholder(placeHolderDrawable)
    }
    if (errorRes != 0) {
        options.error(errorRes)
    }
    if (errorDrawable != null) {
        options.error(errorDrawable)
    }
    if (roundedValue > 0) {
        options.transforms(RoundedCorners(roundedValue))
    }

    val requestManager = Glide.with(this.context)
    val requestBuilder = if (asGif) {
        requestManager.asGif().load(url)
    } else {
        requestManager.asBitmap().load(url).transition(
                if (noFade) BitmapTransitionOptions.withCrossFade(0)
                else BitmapTransitionOptions().crossFade())
    }

    requestBuilder.apply(options).into(this)
}