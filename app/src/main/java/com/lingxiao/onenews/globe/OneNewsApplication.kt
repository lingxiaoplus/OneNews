package com.lingxiao.onenews.globe

import android.app.Application
import android.content.Context
import android.os.Handler

/**
 * Created by lingxiao on 17-11-28.
 */
class OneNewsApplication :Application(){


    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
        mHandler = Handler()
        mainThreadId = android.os.Process.myPid()
    }
    companion object {
        var mContext: Context? = null
        var mHandler: Handler? = null
        var mainThreadId: Int = 0
    }

}