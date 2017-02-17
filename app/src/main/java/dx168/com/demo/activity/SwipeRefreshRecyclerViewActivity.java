package dx168.com.demo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import dx168.com.demo.R;
import dx168.com.demo.apapter.RefreshFootAdapter;
import dx168.com.demo.divider.LDividerItemDecoration;
import dx168.com.demo.util.Logger;

/**
 * Created by lxj on 17/2/17.
 */

public class SwipeRefreshRecyclerViewActivity extends BaseActivity {
    private SwipeRefreshLayout swipe_refreshlayout;
    private RecyclerView recycler_view;
    private RefreshFootAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private int lastVisibleItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_recycler);
        getTitleView().setTitle("下拉刷新上拉加载更多...");
        swipe_refreshlayout=(SwipeRefreshLayout)this.findViewById(R.id.swipe_refreshlayout);
        recycler_view=(RecyclerView)this.findViewById(R.id.recycler_view);
        //设置刷新时动画的颜色，可以设置4个
        swipe_refreshlayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swipe_refreshlayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);

        swipe_refreshlayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recycler_view.setLayoutManager(linearLayoutManager);
        //添加分隔线
        recycler_view.addItemDecoration(new LDividerItemDecoration(this, LDividerItemDecoration.VERTICAL_LIST));

        adapter = new RefreshFootAdapter(this);
        recycler_view.setAdapter(adapter);
        swipe_refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Logger.d("zttjiangqq", "invoke onRefresh...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> newDatas = new ArrayList<String>();
                        for (int i = 0; i < 5; i++) {
                            int index = i + 1;
                            newDatas.add("new item" + index);
                        }
                        adapter.addItem(newDatas);
                        swipe_refreshlayout.setRefreshing(false);
                        showLongToast("更新了五条数据...");
                    }
                }, 5000);
            }
        });
        //RecyclerView滑动监听
        recycler_view.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    adapter.changeMoreStatus(RefreshFootAdapter.LOADING_MORE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            List<String> newDatas = new ArrayList<String>();
                            for (int i = 0; i < 5; i++) {
                                int index = i + 1;
                                newDatas.add("more item" + index);
                            }
                            adapter.addMoreItem(newDatas);
                            adapter.changeMoreStatus(RefreshFootAdapter.PULLUP_LOAD_MORE);
                        }
                    }, 2500);
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
    }
    class CustomOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            SwipeRefreshRecyclerViewActivity.this.finish();
        }
    }
}
