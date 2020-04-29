package com.example.vkrecyclerviewkotlin

import android.os.Parcel
import android.os.Parcelable


data class News(var id: Int, var accountPhotoUrl: Int, var accountName: String?, var date: String?, var newsText: String?, var postPhotoUrl: Int,
                var likesUrl: Int, var likesCount: Int, var liked: Int, var userLike1: Int, var userLike2: Int, var likesDetail:String?,
                var showCom: String?, var userComUrl1: Int, var userComAcc1: String?, var userComText1: String?,
                var userComDate1: String?, var userComReplyUrl1: Int, var userComLikeUrl1: Int, var userComLike1: Int,
                var commentsUrl: Int, var commentsCount: String?, var postsUrl: Int, var postsCount: String?, var viewersUrl: Int,
                var viewersCount: String?) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(accountPhotoUrl)
        parcel.writeString(accountName)
        parcel.writeString(date)
        parcel.writeString(newsText)
        parcel.writeInt(postPhotoUrl)
        parcel.writeInt(likesUrl)
        parcel.writeInt(likesCount)
        parcel.writeInt(liked)
        parcel.writeInt(userLike1)
        parcel.writeInt(userLike2)
        parcel.writeString(likesDetail)
        parcel.writeString(showCom)
        parcel.writeInt(userComUrl1)
        parcel.writeString(userComAcc1)
        parcel.writeString(userComText1)
        parcel.writeString(userComDate1)
        parcel.writeInt(userComReplyUrl1)
        parcel.writeInt(userComLikeUrl1)
        parcel.writeInt(userComLike1)
        parcel.writeInt(commentsUrl)
        parcel.writeString(commentsCount)
        parcel.writeInt(postsUrl)
        parcel.writeString(postsCount)
        parcel.writeInt(viewersUrl)
        parcel.writeString(viewersCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<News> {
        override fun createFromParcel(parcel: Parcel): News {
            return News(parcel)
        }

        override fun newArray(size: Int): Array<News?> {
            return arrayOfNulls(size)
        }
    }

}