package com.example.nytpoc.utils

import android.view.View
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar



/**
 * show simple snack bar
 */
fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.animationMode = BaseTransientBottomBar.ANIMATION_MODE_SLIDE
    snack.show()
}

fun View.visible(){
    this.visibility=View.VISIBLE
}
fun View.inVisible(){
    this.visibility=View.INVISIBLE
}
