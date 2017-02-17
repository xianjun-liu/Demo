package dx168.com.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import dx168.com.demo.R;
import dx168.com.demo.apapter.QuickAdapter;
import dx168.com.demo.divider.LDividerItemDecoration;

/**
 * Created by lxj on 17/2/14.
 */

public class RecyclerViewActivity extends BaseActivity {

    @Bind(R.id.recycler_view)       RecyclerView    mRecyclerView;
    private ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        HomeAdapter adapter = new HomeAdapter(this, data);
//        adapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                showLongToast("点击" + position);
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//                showLongToast("长按" + position);
//            }
//        });

        //***********************   使用quickAdapter
        final QuickAdapter adapter = new QuickAdapter(data);
        adapter.addHeaderView(View.inflate(this, R.layout.view_header, null));
        adapter.addFooterView(View.inflate(this, R.layout.view_header, null));

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                showLongToast("点击" + position);
                jump2Function(position);
            }
        });

        mRecyclerView.addOnItemTouchListener(new OnItemLongClickListener() {
            @Override
            public void onSimpleItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                showLongToast("长按" + position);
            }
        });

        mRecyclerView.setAdapter(adapter);
        //设置分割线
        mRecyclerView.addItemDecoration(new LDividerItemDecoration(this, LDividerItemDecoration.VERTICAL_LIST));
    }

    private void jump2Function(int position) {
        switch (position) {
            case 0:
                startActivity(PlRefreshRecyclerViewActivity.class);
                break;
            case 1:
                startActivity(MultipleRecyclerViewActivity.class);
                break;
            case 2:
                startActivity(SwipeRefreshRecyclerViewActivity.class);
                break;
        }
    }

    private void initData() {
        data.add("下拉刷新和滚动加载");
        data.add("recyclerview 显示复杂条目");
        data.add("recyclerview + SwipeRefreshLayout实现下拉刷新");
    }
}
