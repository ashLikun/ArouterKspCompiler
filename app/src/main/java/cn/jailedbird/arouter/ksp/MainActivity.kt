package cn.jailedbird.arouter.ksp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.jailedbird.arouter.ksp.data.TestData
import cn.jailedbird.arouter.ksp.data.TestSerializable
import cn.jailedbird.arouter.ksp.data.TestSerializable2
import cn.jailedbird.arouter.ksp.service.ITestService1
import cn.jailedbird.arouter.ksp.service.ITestService2
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter

class MainActivity : AppCompatActivity() {

    @Autowired
    var list = mutableListOf<String>()

    @Autowired
    var arrayList = arrayListOf<String>()

    @Autowired
    var array = LinkedHashMap<String, ArrayList<Int>>()

    @Autowired
    var hasSet = HashSet<LinkedHashMap<String, ArrayList<Int>>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.jump).setOnClickListener {
            ARouter.getInstance().build("/app/SecondActivtiy")
                .withSerializable(
                    "TestSerializable",
                    TestSerializable(
                        "ggg", 123,
                        TestSerializable2("ggggawdwd", 5555)
                    )
                )
                .withSerializable(
                    "arrayList",
                    arrayListOf(TestData("111111"), TestData("222222222"), TestData("3333333"))
                )
                .withObject(
                    "arrayListObject",
                    listOf(TestData("33333"), TestData("4444444444"), TestData("555555555"))
                )
                .withParcelable("TestParcelable", TestParcelable("wwwwwwww", 556))
                .withObject("list", mutableListOf("1", "2", "3", "4"))
                .navigation(this)
        }

        val testService1 = ARouter.getInstance()
            .navigation(ITestService1::class.java)
        val testService2 = ARouter.getInstance()
            .navigation(ITestService2::class.java)
        if (testService1 != null && testService2 != null && testService1 === testService2) {
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
        }
    }
}