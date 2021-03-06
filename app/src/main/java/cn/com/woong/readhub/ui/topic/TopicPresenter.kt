package cn.com.woong.readhub.ui.topic

import android.annotation.SuppressLint
import cn.com.woong.readhub.network.RxSchedulers
import cn.com.woong.readhub.network.ReadhubApiService
import cn.com.woong.readhub.App
import cn.com.woong.readhub.base.BaseContract
import cn.com.woong.readhub.constant.Constant
import com.blankj.utilcode.util.LogUtils


class TopicPresenter(var mView: BaseContract.IView) : TopicContract.Presenter {
    override fun getView(): TopicContract.View {
        return mView as TopicContract.View
    }

    @SuppressLint("CheckResult")
    override fun getTopicNews(order: String) {
        LogUtils.i("apiTopicNews === ")
        App.sInstance.apiService(ReadhubApiService::class.java)
                ?.apiTopic(order, Constant.TOPIC_PAGE_SIZE)
                ?.compose(RxSchedulers.io_main())
                ?.subscribe( {
                    getView()?.updateTopicData(order, it.data!!)
                }, {
                    LogUtils.e("apiTopic error ==== ${it}")
                })
    }
}