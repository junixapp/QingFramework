package com.lxj.qingdemo.vm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.lxj.qingdemo.enum.LoadingState
import com.lxj.qingdemo.ui.account.entity.User
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import com.lzy.okgo.request.base.Request

class LoginVM : ViewModel(){
    val userLiveData = MutableLiveData<User>()
    val stateLiveData = MutableLiveData<LoadingState>()

    fun login(username: String, password: String){
//        OkGo.get<User>("https://www.baidu.com").execute(object :JsonCallback<User>() {
//            override fun onSuccess(response: Response<User>) {
//                val user = response.body()
//                userLiveData.value = User(name = "lll")
//            }
//        })

        OkGo.get<String>("https://www.baidu.com")
                .execute(object :StringCallback() {
            override fun onStart(request: Request<String, out Request<Any, Request<*, *>>>?) {
                stateLiveData.value = LoadingState.Loading
                userLiveData.value = null
            }
            override fun onSuccess(response: Response<String>) {
                val user = response.body()
                userLiveData.value = User(name = "lll")
            }

            override fun onCacheSuccess(response: Response<String>?) {
                super.onCacheSuccess(response)
                userLiveData.value = User(name = "lll")
            }

            override fun onFinish() {
                super.onFinish()
                stateLiveData.value = LoadingState.Success
            }
        })
    }
}