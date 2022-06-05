package com.example.greenvalleygp2

import android.os.Parcel
import android.os.Parcelable

data class FarmsInfo(
    val farmName:String="",
    val farmAddress:String="",
    val farmOwnerId:String="",
    val ProductList : List<String>? = ArrayList(),
    val EventsList: List<String>? = ArrayList(),
    val farmOrdersHistory: List<String>? = ArrayList(),
    val PhoneNum:String="",
    val farmRating:Int=0,
    val Feedback:String="",
    val availability:String="true"
    ):Parcelable{
        constructor(parcel: Parcel): this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.createStringArrayList(),
            parcel.createStringArrayList(),
            parcel.createStringArrayList(),
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!,
            ){

        }
    override fun describeContents()=0

    override fun writeToParcel(dest: Parcel, flags: Int)=with(dest) {
    writeString(farmName)
    writeString(farmAddress)
    writeString(farmOwnerId)
    writeStringList(ProductList)
    writeStringList(EventsList)
    writeStringList(farmOrdersHistory)
    writeString(PhoneNum)
    writeInt(farmRating)
    writeString(Feedback)
    writeString(availability)
    }

    companion object CREATOR : Parcelable.Creator<FarmsInfo> {
        override fun createFromParcel(parcel: Parcel): FarmsInfo {
            return FarmsInfo(parcel)
        }

        override fun newArray(size: Int): Array<FarmsInfo> {
            TODO("Not yet implemented")
        }
    }
}

//            parcel.createStringArrayList()!!,
//    val EventsList:ArrayList<String>,
//arrayListOf<String>().apply {
//                parcel.readList(this, String::class.java.classLoader)
//            },