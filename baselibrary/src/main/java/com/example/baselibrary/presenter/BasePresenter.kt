package com.example.baselibrary.presenter

import android.content.Context
import com.example.baselibrary.presenter.view.BaseView
import com.example.baselibrary.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/7.
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}