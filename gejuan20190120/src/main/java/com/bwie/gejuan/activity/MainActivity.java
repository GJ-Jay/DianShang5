package com.bwie.gejuan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bwie.gejuan.R;
import com.bwie.gejuan.adapter.GoodsAdapter;
import com.bwie.gejuan.bean.Goods;
import com.bwie.gejuan.bean.Result;
import com.bwie.gejuan.bean.gndao.DaoMaster;
import com.bwie.gejuan.bean.gndao.DaoSession;
import com.bwie.gejuan.bean.gndao.GoodsDao;
import com.bwie.gejuan.core.DataCall;
import com.bwie.gejuan.presenter.GoodsPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：gj
 * 时间：20190120
 * 主页面，商品列表展示
 */
public class MainActivity extends AppCompatActivity{

    @BindView(R.id.btn_address)
    Button mBtnAddress;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private GoodsPresenter goodsPresenter;
    private GoodsAdapter mGoodsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        goodsPresenter = new GoodsPresenter(new GoodsCall());

        mGoodsAdapter = new GoodsAdapter(this);//创建适配器
        mRlv.setAdapter(mGoodsAdapter);//设置适配器

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL);
        mRlv.setLayoutManager(layoutManager);
        goodsPresenter.request();
        /*mRlv.refresh();*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        goodsPresenter.unBind();
    }

    @OnClick(R.id.btn_address)
    public void setClick(){
        startActivity(new Intent(MainActivity.this,AddressActivity.class));
    }

    private class GoodsCall implements DataCall<Result<List<Goods>>> {
        @Override
        public void success(Result<List<Goods>> result) {
            if(result.getCode().equals("0")){
                DaoSession daoSession = DaoMaster.newDevSession(MainActivity.this, GoodsDao.TABLENAME);
                GoodsDao goodsDao = daoSession.getGoodsDao();
                List<Goods> data = result.getData();
                for (int i = 0; i <data.size() ; i++) {
                    goodsDao.insertOrReplace(data.get(i));
                }
                mGoodsAdapter.addAll(data);//适配器添加数据
                mGoodsAdapter.notifyDataSetChanged();//刷新适配器
            }
        }

        @Override
        public void fail(Result result) {
            Toast.makeText(MainActivity.this,"请求失败"+result.getMsg(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
