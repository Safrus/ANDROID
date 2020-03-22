package com.example.vkrecyclerview;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class News implements Parcelable {
    private int id;
    private int accountPhotoUrl;
    private String accountName;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return getId() == news.getId() &&
                getAccountPhotoUrl() == news.getAccountPhotoUrl() &&
                getPostPhotoUrl() == news.getPostPhotoUrl() &&
                getLikesUrl() == news.getLikesUrl() &&
                getLikesCount() == news.getLikesCount() &&
                getLiked() == news.getLiked() &&
                getUserLike1() == news.getUserLike1() &&
                getUserLike2() == news.getUserLike2() &&
                getUserComUrl1() == news.getUserComUrl1() &&
                getUserComReplyUrl1() == news.getUserComReplyUrl1() &&
                getUserComLikeUrl1() == news.getUserComLikeUrl1() &&
                getUserComLike1() == news.getUserComLike1() &&
                getCommentsUrl() == news.getCommentsUrl() &&
                getPostsUrl() == news.getPostsUrl() &&
                getViewersUrl() == news.getViewersUrl() &&
                Objects.equals(getAccountName(), news.getAccountName()) &&
                Objects.equals(getDate(), news.getDate()) &&
                Objects.equals(getNewsText(), news.getNewsText()) &&
                Objects.equals(getLikesDetail(), news.getLikesDetail()) &&
                Objects.equals(getShowCom(), news.getShowCom()) &&
                Objects.equals(getUserComAcc1(), news.getUserComAcc1()) &&
                Objects.equals(getUserComText1(), news.getUserComText1()) &&
                Objects.equals(getUserComDate1(), news.getUserComDate1()) &&
                Objects.equals(getCommentsCount(), news.getCommentsCount()) &&
                Objects.equals(getPostsCount(), news.getPostsCount()) &&
                Objects.equals(getViewersCount(), news.getViewersCount());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountPhotoUrl(), getAccountName(), getDate(), getNewsText(), getPostPhotoUrl(), getLikesUrl(), getLikesCount(), getLiked(), getUserLike1(), getUserLike2(), getLikesDetail(), getShowCom(), getUserComUrl1(), getUserComAcc1(), getUserComText1(), getUserComDate1(), getUserComReplyUrl1(), getUserComLikeUrl1(), getUserComLike1(), getCommentsUrl(), getCommentsCount(), getPostsUrl(), getPostsCount(), getViewersUrl(), getViewersCount());
    }

    private String date;
    private String newsText;
    private int postPhotoUrl;
    private int likesUrl;
    private int likesCount;
    private int liked;
    private int userLike1;
    private int userLike2;
    private String likesDetail;
    private String showCom;
    private int userComUrl1;
    private String userComAcc1;
    private String userComText1;
    private String userComDate1;
    private int userComReplyUrl1;
    private int userComLikeUrl1;
    private int userComLike1;
    private int commentsUrl;
    private String commentsCount;
    private int postsUrl;
    private String postsCount;
    private int viewersUrl;
    private String viewersCount;

    public News() {
    }

    public News(int id, int accountPhotoUrl, String accountName, String date, String newsText, int postPhotoUrl, int likesUrl, int likesCount, int liked, int userLike1, int userLike2, String likesDetail, String showCom, int userComUrl1, String userComAcc1, String userComText1, String userComDate1, int userComReplyUrl1, int userComLikeUrl1, int userComLike1, int commentsUrl, String commentsCount, int postsUrl, String postsCount, int viewersUrl, String viewersCount) {
        this.id = id;
        this.accountPhotoUrl = accountPhotoUrl;
        this.accountName = accountName;
        this.date = date;
        this.newsText = newsText;
        this.postPhotoUrl = postPhotoUrl;
        this.likesUrl = likesUrl;
        this.likesCount = likesCount;
        this.liked = liked;
        this.userLike1 = userLike1;
        this.userLike2 = userLike2;
        this.likesDetail = likesDetail;
        this.showCom = showCom;
        this.userComUrl1 = userComUrl1;
        this.userComAcc1 = userComAcc1;
        this.userComText1 = userComText1;
        this.userComDate1 = userComDate1;
        this.userComReplyUrl1 = userComReplyUrl1;
        this.userComLikeUrl1 = userComLikeUrl1;
        this.userComLike1 = userComLike1;
        this.commentsUrl = commentsUrl;
        this.commentsCount = commentsCount;
        this.postsUrl = postsUrl;
        this.postsCount = postsCount;
        this.viewersUrl = viewersUrl;
        this.viewersCount = viewersCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountPhotoUrl() {
        return accountPhotoUrl;
    }

    public void setAccountPhotoUrl(int accountPhotoUrl) {
        this.accountPhotoUrl = accountPhotoUrl;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public int getPostPhotoUrl() {
        return postPhotoUrl;
    }

    public void setPostPhotoUrl(int postPhotoUrl) {
        this.postPhotoUrl = postPhotoUrl;
    }

    public int getLikesUrl() {
        return likesUrl;
    }

    public void setLikesUrl(int likesUrl) {
        this.likesUrl = likesUrl;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getUserLike1() {
        return userLike1;
    }

    public void setUserLike1(int userLike1) {
        this.userLike1 = userLike1;
    }

    public int getUserLike2() {
        return userLike2;
    }

    public void setUserLike2(int userLike2) {
        this.userLike2 = userLike2;
    }

    public String getLikesDetail() {
        return likesDetail;
    }

    public void setLikesDetail(String likesDetail) {
        this.likesDetail = likesDetail;
    }

    public String getShowCom() {
        return showCom;
    }

    public void setShowCom(String showCom) {
        this.showCom = showCom;
    }

    public int getUserComUrl1() {
        return userComUrl1;
    }

    public void setUserComUrl1(int userComUrl1) {
        this.userComUrl1 = userComUrl1;
    }

    public String getUserComAcc1() {
        return userComAcc1;
    }

    public void setUserComAcc1(String userComAcc1) {
        this.userComAcc1 = userComAcc1;
    }

    public String getUserComText1() {
        return userComText1;
    }

    public void setUserComText1(String userComText1) {
        this.userComText1 = userComText1;
    }

    public String getUserComDate1() {
        return userComDate1;
    }

    public void setUserComDate1(String userComDate1) {
        this.userComDate1 = userComDate1;
    }

    public int getUserComReplyUrl1() {
        return userComReplyUrl1;
    }

    public void setUserComReplyUrl1(int userComReplyUrl1) {
        this.userComReplyUrl1 = userComReplyUrl1;
    }

    public int getUserComLikeUrl1() {
        return userComLikeUrl1;
    }

    public void setUserComLikeUrl1(int userComLikeUrl1) {
        this.userComLikeUrl1 = userComLikeUrl1;
    }

    public int getUserComLike1() {
        return userComLike1;
    }

    public void setUserComLike1(int userComLike1) {
        this.userComLike1 = userComLike1;
    }

    public int getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(int commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getPostsUrl() {
        return postsUrl;
    }

    public void setPostsUrl(int postsUrl) {
        this.postsUrl = postsUrl;
    }

    public String getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(String postsCount) {
        this.postsCount = postsCount;
    }

    public int getViewersUrl() {
        return viewersUrl;
    }

    public void setViewersUrl(int viewersUrl) {
        this.viewersUrl = viewersUrl;
    }

    public String getViewersCount() {
        return viewersCount;
    }

    public void setViewersCount(String viewersCount) {
        this.viewersCount = viewersCount;
    }

    public static Creator<News> getCREATOR() {
        return CREATOR;
    }



    @Override
    public String toString() {
        final StringBuilder sb=new StringBuilder("News{");
        sb.append("accountPhotoUrl='").append(accountPhotoUrl).append('\'');
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", date'").append(date).append('\'');
        sb.append(", newsText'").append(newsText).append('\'');
        sb.append(", postPhotoUrl'").append(postPhotoUrl).append('\'');
        sb.append(", likesCount'").append(likesCount).append('\'');
        sb.append(", commentsCount'").append(commentsCount).append('\'');
        sb.append(", postsCount'").append(postsCount).append('\'');
        sb.append(", viewersCount'").append(viewersCount);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents(){ //describeContents()-Описание виды специальных объектов, содержащихся
        // в правильном порядке представления этого экземпляра Parcelable.
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.accountPhotoUrl);
        dest.writeString(this.accountName);
        dest.writeString(this.date);
        dest.writeString(this.newsText);
        dest.writeInt(this.postPhotoUrl);
        dest.writeInt(this.likesUrl);
        dest.writeInt(this.likesCount);
        dest.writeInt(this.liked);
        dest.writeInt(this.userLike1);
        dest.writeInt(this.userLike2);
        dest.writeString(this.likesDetail);
        dest.writeString(this.showCom);//private String showCom;
        dest.writeInt(this.userComUrl1);//private int userComUrl1;
        dest.writeString(this.userComAcc1);//private String userComAcc1;
        dest.writeString(this.userComText1);//private String userComText1;
        dest.writeString(this.userComDate1);//private String userComDate1;
        dest.writeInt(this.userComReplyUrl1);//private int userComReplyUrl1;
        dest.writeInt(this.userComLikeUrl1);//private int userComLikeUrl1;
        dest.writeInt(this.userComLike1);//private int userComLike1;
        dest.writeInt(this.commentsUrl);
        dest.writeString(this.commentsCount);
        dest.writeInt(this.postsUrl);
        dest.writeString(this.postsCount);
        dest.writeInt(this.viewersUrl);
        dest.writeString(this.viewersCount);
    }

    protected News(Parcel in){
        this.id = in.readInt();
        this.accountPhotoUrl=in.readInt();
        this.accountName=in.readString();
        this.date=in.readString();          // конструктор, считывающий данные из Parcel
        this.newsText=in.readString();
        this.postPhotoUrl=in.readInt();
        this.likesUrl=in.readInt();
        this.likesCount=in.readInt();
        this.liked=in.readInt();
        this.userLike1=in.readInt();
        this.userLike2=in.readInt();
        this.likesDetail=in.readString();
        this.showCom=in.readString();//private String showCom;
        this.userComUrl1=in.readInt();//private int userComUrl1;
        this.userComAcc1=in.readString();//private String userComAcc1;
        this.userComText1=in.readString();//private String userComText1;
        this.userComDate1=in.readString();//private String userComDate1;
        this.userComReplyUrl1=in.readInt();//private int userComReplyUrl1;
        this.userComLikeUrl1=in.readInt();//private int userComLikeUrl1;
        this.userComLike1=in.readInt();//private int userComLike1;
        this.commentsUrl=in.readInt();
        this.commentsCount=in.readString();
        this.postsUrl=in.readInt();
        this.postsCount=in.readString();
        this.viewersUrl=in.readInt();
        this.viewersCount=in.readString();
    }

    public static final Creator<News>CREATOR=new Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[0];             //Create a new array of the Parcelable class.
        }
    };
}

    /*
    startActivity – начинаем вызов Activity

writeToParcel  - мы поместили объект в Intent, и похоже, что при отправке он упаковался в Parcel.
Т.к. сам Parcel не знает, как именно упаковать объект, он вызвал метод writeToParcel, где мы реализовали упаковку.

getParcelableExtra – извлекаем объект из Intent

createFromParcel – это был вызван метод CREATOR.createFromParcel, которому на вход дали Parcel,
а он должен вернуть MyObject. Этот метод в свою очередь
для создания MyObject использует конструктор MyObject(Parcel parcel),
в котором мы расписали, как надо читать Parcel и заполнить объект.

myObj: text, 1 – вывели в лог значения объекта.
     */
