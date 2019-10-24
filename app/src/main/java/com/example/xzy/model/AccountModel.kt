package com.example.xzy.model
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.xzy.bean.AccountBean
import android.app.Application
import android.util.Log

/**
 * Description :
 * Created by XuZhuYun 2019/5/9 17:03 .
 */
class AccountModel(application: Application) : AndroidViewModel(application) {

    val account = MutableLiveData<AccountBean>()
    val result = MutableLiveData<String>()

    fun setAccount(name: String, phone: String, blog: String) {
        account.value = AccountBean(name, phone, blog)
        // 当需要在工作线程更新 liveData 的时候使用 postValue
        // account.postValue(AccountBean(name, phone, blog))
    }

    // 当MyActivity被销毁时，Framework会调用ViewModel的onCleared()
    override fun onCleared() {
        Log.e("AccountModel", "==========onCleared()==========")
        super.onCleared()
    }

    companion object {

        fun getFormatContent(name: String?, phone: String?, blog: String?): String {
            val mBuilder = StringBuilder()
            mBuilder.append("昵称:")
            mBuilder.append(name)
            mBuilder.append("\n手机:")
            mBuilder.append(phone)
            mBuilder.append("\n博客:")
            mBuilder.append(blog)
            return mBuilder.toString()
        }
    }
}