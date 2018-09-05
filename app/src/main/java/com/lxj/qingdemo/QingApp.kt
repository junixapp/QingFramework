package com.lxj.qingdemo

import android.app.Application
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheEntity
import com.lzy.okgo.cache.CacheMode

class QingApp: Application(){
    override fun onCreate() {
        super.onCreate()
        val okGo = OkGo.getInstance().init(this)
        okGo.cacheMode = CacheMode.FIRST_CACHE_THEN_REQUEST               //全局统一缓存模式，默认不使用缓存，可以不传
        okGo.cacheTime = CacheEntity.CACHE_NEVER_EXPIRE   //全局统一缓存时间，默认永不过期，可以不传
//                .retryCount                             //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0

    }
}