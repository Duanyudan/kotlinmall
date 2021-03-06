package com.example.ordercenter.presenter

import com.example.baselibrary.ext.excute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.ordercenter.presenter.view.OrderComfirmView
import com.example.ordercenter.service.OrderServiceImpl
import com.kotlin.order.data.protocol.Order
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/7.
 */
class OrderComfirmPresenter @Inject constructor() : BasePresenter<OrderComfirmView>() {
    @Inject
    lateinit var orderService: OrderServiceImpl

    fun getOrderById(orderId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        orderService.getOrderById(orderId)
                .excute(object : BaseSubscriber<Order>(mView) {
                    override fun onNext(t: Order) {
                        mView.onGetOrderByIdResult(t)
                    }
                }, lifecycleProvider)
    }

    fun submitOrder(order: Order) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        orderService.submitOrder(order)
                .excute(object : BaseSubscriber<String>(mView) {
                    override fun onNext(t: String) {
                        mView.onSubmitResult(t)
                    }
                }, lifecycleProvider)
    }
}