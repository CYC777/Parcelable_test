package edu.brandeis.cs.yanchengchen.parcel_test;

/**
 * Created by yancheng on 2017/10/19.
 */
import java.util.ArrayList;
import java.util.HashMap;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 用户信息，实现Parcelable接口
 * String,int,String[],ArrayList<HashMap<String,Object>>这四种类型测试
 * @author weijiang204321
 *
 */
public class UserInfo implements Parcelable{

    private String id;
    private String name;
    private int age;
    private String[] boyfriendAry = new String[3];
    private ArrayList<HashMap<String,SonInfo>> listData = new ArrayList<HashMap<String,SonInfo>>();
    private SonInfo sonInfo;

    public UserInfo(){
    }

    public UserInfo(String id,String name,int age,String[] boyfriendAry,ArrayList<HashMap<String,SonInfo>> listData){
        this.id = id;
        this.name = name;
        this.age = age;
        this.boyfriendAry = boyfriendAry;
        this.listData = listData;
    }

    public UserInfo(Parcel source){
        id = source.readString();
        name = source.readString();
        age = source.readInt();
        sonInfo = source.readParcelable(SonInfo.class.getClassLoader());
        source.readStringArray(boyfriendAry);
        source.readList(listData, SonInfo.class.getClassLoader());
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SonInfo getSonInfo(){
        return sonInfo;
    }

    public void setSonInfo(SonInfo sonInfo){
        this.sonInfo = sonInfo;
    }

    public String[] getBoyfriendAry() {
        return boyfriendAry;
    }

    public void setBoyfriendAry(String[] boyfriendAry) {
        this.boyfriendAry = boyfriendAry;
    }

    public ArrayList<HashMap<String, SonInfo>> getListData() {
        return listData;
    }

    public void setListData(ArrayList<HashMap<String, SonInfo>> listData) {
        this.listData = listData;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    //进行序列化存储
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeParcelable(sonInfo, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);

        dest.writeStringArray(boyfriendAry);
        dest.writeList(listData);
    }

    public static final Parcelable.Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }

        //将Parcel对象反序列化为UserInfo
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }
    };

}