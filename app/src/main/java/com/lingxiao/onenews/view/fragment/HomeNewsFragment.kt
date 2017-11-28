package com.lingxiao.onenews.view.fragment

import android.view.View
import com.lingxiao.onenews.R

/**
 * Created by lingxiao on 17-11-28.
 */
class HomeNewsFragment : BaseFragment() {
    override fun initData() {

    }

    override fun initView(): View {
        val view = View.inflate(activity,R.layout.fragment_home,null)
        return view
    }
}