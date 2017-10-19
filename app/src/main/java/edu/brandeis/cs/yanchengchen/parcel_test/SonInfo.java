package edu.brandeis.cs.yanchengchen.parcel_test;

/**
 * Created by yancheng on 2017/10/19.
 */
import android.os.Parcel;
import android.os.Parcelable;

public class SonInfo implements Parcelable{

    private String id;
    private String name;

    public SonInfo(){

    }

    public SonInfo(String id,String name){
        this.id = id;
        this.name = name;
    }

    public SonInfo(Parcel source){
        this.id = source.readString();
        this.name = source.readString();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }

    public static final Parcelable.Creator<SonInfo> CREATOR = new Creator<SonInfo>() {
        @Override
        public SonInfo[] newArray(int size) {
            return new SonInfo[size];
        }

        //将Parcel对象反序列化为UserInfo
        @Override
        public SonInfo createFromParcel(Parcel source) {
            return new SonInfo(source);
        }
    };

}