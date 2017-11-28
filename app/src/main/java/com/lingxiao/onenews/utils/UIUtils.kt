package com.lingxiao.onenews.utils

/**
 * Created by lingxiao on 17-11-28.
 */
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.lingxiao.onenews.globe.OneNewsApplication

/**
 * Created by lingxiao on 2017/6/13.
 */
class UIUtils {
    companion object {
        fun getContext(): Context? {
            return OneNewsApplication.mContext
        }
        fun getHandler(): Handler? {
            return OneNewsApplication.mHandler
        }
        fun getMainThreadId(): Int{
            return OneNewsApplication.mainThreadId
        }
        //////////////////判断是否运行在主线程///////////
        fun isRunOnUIThread(): Boolean {
            //在android6.0系统中不行
            /*  int mypid = android.os.Process.myPid();
              if (mypid == getMainThreadId()){
                  return true;
              }
              return false;*/
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }
        //运行在主线程
        fun runOnUIThread(r:Runnable){
            if(isRunOnUIThread()){
                //如果是主线程，就直接运行
                r.run();
            }else{
                //如果在子线程，就借助handler让其在主线程运行
                getHandler()?.post(r);
            }
        }
    }

}