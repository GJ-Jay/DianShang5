package com.bwie.gejuan.adapter;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.bwie.gejuan.R;
import com.bwie.gejuan.activity.GoodsShowActivity;
import com.bwie.gejuan.bean.Goods;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：gj
 * 时间：20190120
 * 商品适配器
 */
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.MyHolder> {
    Context context;
    private String replace;
    private double price;
    private String title;
    private String images;
    private long pid;

    public GoodsAdapter(Context context) {
        this.context = context;
    }

    ArrayList<Goods> list = new ArrayList<>();//商品集合

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {//创建视图holder
        View view = View.inflate(context,R.layout.list_item,null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
//        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {//绑定视图holder
        Goods goods = list.get(i);
        price = goods.getPrice();
        title = goods.getTitle();
        images = goods.getImages();
        pid = goods.getPid();
        myHolder.title.setText(title);//设置标题
        myHolder.price.setText("￥ "+ price);//设置价格
        String[] split = images.split("\\|");
        if(split.length>0){
            //得到的截取后的图片
            replace = split[0].replace("https", "http");
        }
        myHolder.simpleDraweeView.setImageURI(replace);//设置图片

        //点击跳转详情
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,GoodsShowActivity.class);
                intent.putExtra("images", images);
                intent.putExtra("title", title);
                intent.putExtra("price", price);
                intent.putExtra("pid", pid);
                context.startActivity(intent);//点击跳转详情
            }
        });

        //长按删除
        myHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(225f,0f);
                alphaAnimation.setDuration(1000);
                list.remove(i);
                notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {//数量
        return list.size();
    }

    public void addAll(List<Goods> data) {//集合添加数据
        if(data!=null){
            list.addAll(data);
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final SimpleDraweeView simpleDraweeView;
        private final TextView price;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }
    }
}
