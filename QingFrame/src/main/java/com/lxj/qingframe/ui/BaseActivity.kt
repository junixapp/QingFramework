package com.lxj.qingframe.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.lxj.qingframe.exts.load

class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImageView(this).load("xxx")
    }
}