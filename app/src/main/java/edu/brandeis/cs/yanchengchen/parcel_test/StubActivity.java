package edu.brandeis.cs.yanchengchen.parcel_test;

/**
 * Created by yancheng on 2017/10/19.
 */
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;



public class StubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserInfo userInfo = (UserInfo)this.getIntent().getParcelableExtra("userinfo");
        SonInfo sonInfo = userInfo.getSonInfo();

        String[] boyfriend = userInfo.getBoyfriendAry();
        for(int i=0;i<boyfriend.length;i++){
            Log.e("boyfriend_name:",boyfriend[i]);
        }

        ArrayList<HashMap<String,SonInfo>> listData = userInfo.getListData();
        for(int j=0;j<listData.size();j++){
            SonInfo temp_soninfo = listData.get(j).get("one_child");
            Log.e("OneChildId:",temp_soninfo.getId()+"");
            Log.e("OneChildName:",temp_soninfo.getName()+"");
        }



        Log.e("UserId:",userInfo.getId()+"");
        Log.e("UserName:",userInfo.getName()+"");
        Log.e("UserAge:",userInfo.getAge()+"");
        Log.e("Son_id:",sonInfo.getId()+"");
        Log.e("Son_name:",sonInfo.getName()+"");

    }

}