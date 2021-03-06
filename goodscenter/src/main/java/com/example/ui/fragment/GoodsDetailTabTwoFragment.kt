package com.example.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.example.baselibrary.ext.loadUrl
import com.example.baselibrary.ui.fragment.BaseFragment
import com.example.event.GoodsDetailEvent
import com.example.goodscenter.R
import kotlinx.android.synthetic.main.fragment_goods_detail_tab_two.*

/**
 * Created by Administrator on 2018/3/20.
 */
class GoodsDetailTabTwoFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater?.inflate(R.layout.fragment_goods_detail_tab_two, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserve()
    }

    private fun initObserve() {
        Bus.observe<GoodsDetailEvent>()
                .subscribe { t: GoodsDetailEvent ->
                    run {
                        mGoodsDetailOneIv.loadUrl(t.imgOne)
                        mGoodsDetailTwoIv.loadUrl(t.imgTwo)
                    }


                }
                .registerInBus(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

}