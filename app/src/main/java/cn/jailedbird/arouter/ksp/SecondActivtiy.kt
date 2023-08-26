package cn.jailedbird.arouter.ksp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cn.jailedbird.arouter.ksp.data.TestData
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import java.io.Serializable

@Route(path = "/app/SecondActivtiy")
class SecondActivtiy<T> : AppCompatActivity() {

    var t: T = "" as T

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView(R.layout.second_main)
        Log.d("TAG arrayList", arrayList.toString())
        Log.d("TAG arrayListObject", arrayListObject.toString())
        Log.d("TAG list", list.toString())
        Log.d("TAG pParcelable", pParcelable.toString())
        Log.d("TAG serializable", serializable.toString())

    }
}