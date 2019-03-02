package cn.com.woong.readhub

import android.app.Application
import android.content.Context
import com.blankj.utilcode.util.Utils
import com.facebook.stetho.Stetho

/**
 * Created by wong on 2019/01/21.
 * @author Woong
 */
class App : Application() {
    companion object {
        var mInstance: App? = null

        fun getInstance(): App? {
            return mInstance
        }

        fun getAppContext(): Context? {
            return mInstance?.getApplicationContext()
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        Utils.init(this)
        Stetho.initializeWithDefaults(this)
    }
}