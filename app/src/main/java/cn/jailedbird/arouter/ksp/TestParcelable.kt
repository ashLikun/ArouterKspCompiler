package cn.jailedbird.arouter.ksp

import android.os.Parcel
import android.os.Parcelable

/**
 * 作者　　: 李坤
 * 创建时间: 2023/8/26　3:50
 * 邮箱　　：496546144@qq.com
 *
 * 功能介绍：
 */
data class TestParcelable(val str: String?, var ii: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(str)
        parcel.writeInt(ii)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestParcelable> {
        override fun createFromParcel(parcel: Parcel): TestParcelable {
            return TestParcelable(parcel)
        }

        override fun newArray(size: Int): Array<TestParcelable?> {
            return arrayOfNulls(size)
        }
    }
}