package com.lingxiao.onenews.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.lingxiao.onenews.utils.UIUtils
import com.lingxiao.onenews.view.fragment.BaseFragment
import com.lingxiao.onenews.view.fragment.HomeNewsFragment

/**
 * Created by lingxiao on 17-11-28.
 */
class MainPagerAdapter(fm: FragmentManager?,val strs:List<String>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        var fragment = HomeNewsFragment()
        return fragment
    }

    override fun getCount(): Int {
        return strs.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return strs!![position]
    }
}