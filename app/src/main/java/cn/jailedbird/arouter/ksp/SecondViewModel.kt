package cn.jailedbird.arouter.ksp

import android.util.Log
import cn.jailedbird.arouter.ksp.data.TestData
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.ashlikun.core.mvvm.BaseViewModel
import java.io.Serializable

/**
 * 作者　　: 李坤
 * 创建时间: 2023/8/26　19:00
 * 邮箱　　：496546144@qq.com
 *
 * 功能介绍：
 */
class SecondViewModel : BaseViewModel() {
    @Autowired
    var list = mutableListOf<String>()

    @Autowired(required = true)
    var arrayList = java.util.ArrayList<TestData>()

    @Autowired(required = true)
    var arrayListObject = mutableListOf<TestData>()

    @Autowired
    var array = LinkedHashMap<String, ArrayList<Int>>()

    @Autowired(name = "TestParcelable")
    lateinit var pParcelable: TestParcelable

    @Autowired(name = "TestSerializable")
    lateinit var serializable: Serializable

    @Autowired
    var hasSet = HashSet<LinkedHashMap<String, ArrayList<Int>>>()
    override fun onCreate() {
        super.onCreate()
        Log.d("SecondViewModel arrayList", arrayList.toString())
        Log.d("SecondViewModel arrayListObject", arrayListObject.toString())
        Log.d("SecondViewModel list", list.toString())
        Log.d("SecondViewModel pParcelable", pParcelable.toString())
        Log.d("SecondViewModel serializable", serializable.toString())
    }
}