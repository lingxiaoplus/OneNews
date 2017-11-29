package com.lingxiao.onenews.exception

/**
 * Created by lingxiao on 17-11-29.
 */
class ApiException:Exception() {
    private var code: Int = 0//错误码
    private var msg: String? = null//错误信息
}