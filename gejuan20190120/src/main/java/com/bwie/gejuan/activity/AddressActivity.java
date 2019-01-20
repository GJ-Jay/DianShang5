package com.bwie.gejuan.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;
import com.bwie.gejuan.R;

public class AddressActivity extends AppCompatActivity {

    public AMapLocationClient mLocationClient = null;
    private TextView tv;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        tv = (TextView) findViewById(R.id.tv);
        button = findViewById(R.id.but_dianji);
        initLocation();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLocationClient.startLocation();//可以写在点击事件中
            }
        });

    }
    //36:EA:8F:23:28:F8:9F:50:7B:66:B2:4D:FF:13:05:F1:72:07:4B:3B
    private void initLocation(){
        //声明AMapLocationClient类对象
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //异步获取定位结果
        AMapLocationListener mAMapLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                if (amapLocation != null) {
                    if (amapLocation.getErrorCode() == 0) {
                        //解析定位结果
                        tv.setText(amapLocation.getAddress());
                        mLocationClient.stopLocation();
                    }
                }
            }
        };
        //设置定位回调监听
        mLocationClient.setLocationListener(mAMapLocationListener);
        //启动定位
    }
}
