package edu.brandeis.cs.yanchengchen.parcel_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,StubActivity.class);
        ArrayList<HashMap<String,SonInfo>> listData = new ArrayList<HashMap<String,SonInfo>>();
        HashMap<String,SonInfo> tempMap = new HashMap<String,SonInfo>();
        tempMap.put("one_child", new SonInfo("001_1","jiangwei_one_child"));
        listData.add(tempMap);

        UserInfo userInfo = new UserInfo("001","jiangwei",24,new String[]{"张三","李四","王五"},listData);
        SonInfo sonInfo = new SonInfo();
        sonInfo.setId("001_1");
        sonInfo.setName("jiangwei_child");
        userInfo.setSonInfo(sonInfo);
        intent.putExtra("userinfo", userInfo);
        startActivity(intent);

    }

}