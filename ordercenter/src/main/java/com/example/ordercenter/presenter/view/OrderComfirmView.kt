package com.example.ordercenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView
import com.kotlin.order.data.protocol.Order

/**
 * Created by Administrator on 2018/3/7.
 */
interface OrderComfirmView : BaseView {
    fun onGetOrderByIdResult(result: Order)
    fun onSubmitResult(result: String)

}