package com.bwie.gejuan.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.gejuan.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：gj
 * 时间：20190120
 * 商品详情页面
 */
public class GoodsShowActivity extends AppCompatActivity {

    @BindView(R.id.show_img)
    ImageView showImg;
    @BindView(R.id.show_banner)
    Banner showBanner;
    @BindView(R.id.show_title)
    TextView showTitle;
    @BindView(R.id.show_price)
    TextView showPrice;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_show);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String images = intent.getStringExtra("images");//获取传过来的参数
        String title = intent.getStringExtra("title");
        double price = intent.getDoubleExtra("price", 0);

        //设置商品详情数据
        showTitle.setText(title);
        showPrice.setText("￥ " + price);

        String[] split = images.split("\\|");
        if (split.length > 0) {
            for (int i = 0; i < split.length; i++) {//得到的截取后的图片
                String replace = split[i].replace("https", "http");
                list.add(replace);
            }
        }

        showBanner.setImageLoader(new ImageLoader() {//设置无限轮播图片
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                com.nostra13.universalimageloader.core.ImageLoader instance = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
                instance.displayImage((String) path, imageView);
            }
        });

        showBanner.setImages(list);
        showBanner.start();
    }

    @OnClick({R.id.shar,R.id.qq})
    public void setCAlick(View view){
        switch (view.getId()){
            case R.id.shar://分享到微信
                startActivity(new Intent(GoodsShowActivity.this,WeiXinActivity.class));
                break;
            case R.id.qq://分享到QQ
                startActivity(new Intent(GoodsShowActivity.this,QQActivity.class));
                break;
        }
    }
}
