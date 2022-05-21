package com.example.greenvalleygp2

import android.os.Parcel
import android.os.Parcelable

data class FarmOwnerInfo (
    val id:String="",
    val firstname:String="",
    val lastname:String="",
    val foemail:String="",
    val fopasswd:String="",
    val fophone:String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {

    }
    override fun describeContents()=0

    override fun writeToParcel(dest: Parcel, flags: Int)=with(dest) {
        writeString(id)
        writeString(firstname)
        writeString(lastname)
        writeString(foemail)
        writeString(fopasswd)
        writeString(fophone)
    }

    companion object CREATOR : Parcelable.Creator<FarmOwnerInfo> {
        override fun createFromParcel(parcel: Parcel): FarmOwnerInfo {
            return FarmOwnerInfo(parcel)
        }

        override fun newArray(size: Int): Array<FarmOwnerInfo> {
            TODO("Not yet implemented")
        }
    }
}
