package cn.jailedbird.arouter.ksp.data

import java.io.Serializable

/**
 * 作者　　: 李坤
 * 创建时间: 2023/8/26　13:32
 * 邮箱　　：496546144@qq.com
 *
 * 功能介绍：
 */
data class TestSerializable(
    var str: String,
    var intt: Int,
    var s2: TestSerializable2,
) : Serializable {

}