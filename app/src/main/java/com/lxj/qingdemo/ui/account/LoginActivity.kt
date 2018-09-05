package com.lxj.qingdemo.ui.account

import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lxj.qingdemo.enum.LoadingState
import com.lxj.qingdemo.ui.account.entity.User
import com.lxj.qingdemo.vm.LoginVM
import com.lxj.qingframework.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginVM: LoginVM
    lateinit var loadingDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginVM = ViewModelProviders.of(this).get(LoginVM::class.java)

        loadingDialog = ProgressDialog(this)

        loginVM.userLiveData.observe(this, Observer<User> {
            if (it != null) {
                tv_state.text = "user: ${it.name}"
            } else {
                tv_state.text = "当前未登录"
            }
        })

        loginVM.stateLiveData.observe(this, Observer<LoadingState> {
            when (it) {
                LoadingState.Loading -> loadingDialog.show()
                LoadingState.Success -> loadingDialog.hide()
            }
        })

        btn_login.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()

            loginVM.login(username, password)
        }
    }
}