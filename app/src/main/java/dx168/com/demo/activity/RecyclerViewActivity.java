package dx168.com.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import dx168.com.demo.R;
import dx168.com.demo.divider.LDividerItemDecoration;

/**
 * Created by lxj on 17/2/14.
 */

public class RecyclerViewActivity extends BaseActivity {

    @Bind(R.id.recycler_view)       RecyclerView    mRecyclerView;
    private ArrayList<String> data = new ArrayList<>();
    private int mCurrentCounter;
    private static final int TOTAL_COUNTER = 60;
    private boolean isErr = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        initData();
        initMultipleData();
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
//        final QuickAdapter adapter = new QuickAdapter(data);
//        adapter.addHeaderView(View.inflate(this, R.layout.view_header, null));
//        adapter.addFooterView(View.inflate(this, R.layout.view_header, null));
//        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                mRecyclerView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (mCurrentCounter >= TOTAL_COUNTER) {
//                            //Data are all loaded.
//                            adapter.loadMoreEnd();
//                        } else {
//                            if (isErr) {
//                                //Successfully get more data
//                                adapter.addData(addData());
//                                mCurrentCounter = adapter.getData().size();
//                                adapter.loadMoreComplete();
//                            } else {
//                                //Get more data failed
//                                isErr = true;
//                                Toast.makeText(RecyclerViewActivity.this, "数据加载失败", Toast.LENGTH_LONG).show();
//                                adapter.loadMoreFail();
//
//                            }
//                        }
//                    }
//                }, 3000);
//            }
//        });

//        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
//            @Override
//            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
//                showLongToast("点击" + position);
//            }
//        });
//
//        mRecyclerView.addOnItemTouchListener(new OnItemLongClickListener() {
//            @Override
//            public void onSimpleItemLongClick(BaseQuickAdapter adapter, View view, int position) {
//                showLongToast("长按" + position);
//            }
//        });


//        MultipleItemQuickAdapter adapter = new MultipleItemQuickAdapter(data);
//        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new LDividerItemDecoration(this, LDividerItemDecoration.VERTICAL_LIST));
    }

    private void initMultipleData() {
//        MultipleItem item = new MultipleItem();
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            data.add("这是第" + (i + 1) + "条数据");
        }
    }

    private ArrayList<String> addData() {
        for (int i = 0; i < 10; i++) {
            data.add("这是第" + (i + 1 + data.size()) + "条数据");
        }
        return data;
    }


}
