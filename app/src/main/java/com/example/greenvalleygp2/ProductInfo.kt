package com.example.greenvalleygp2
import android.os.Parcel
import android.os.Parcelable

data class ProductInfo(
    val productName: String="",
    val productPrice: Double=0.00,
    val productAvailable: String="",
    val amount: Double=0.00,
    val productNutritionalValue: String=""
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readString()!!
    ){

    }
    override fun describeContents()=0

    override fun writeToParcel(dest: Parcel, flags: Int)=with(dest) {
        writeString(productName)
        writeDouble(productPrice)
        writeString(productAvailable)
        writeDouble(amount)
        writeString(productNutritionalValue)
    }
    companion object CREATOR : Parcelable.Creator<ProductInfo> {
        override fun createFromParcel(parcel: Parcel): ProductInfo {
            return ProductInfo(parcel)
        }

        override fun newArray(size: Int): Array<ProductInfo> {
            TODO("Not yet implemented")
        }
    }
}
