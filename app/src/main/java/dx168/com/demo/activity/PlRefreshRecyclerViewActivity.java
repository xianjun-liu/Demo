package dx168.com.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import dx168.com.demo.R;
import dx168.com.demo.apapter.BasicAdapter;
import dx168.com.demo.apapter.PlAdapter;
import dx168.com.demo.divider.LDividerItemDecoration;
import dx168.com.demo.view.RefreshLayout;

/**
 * Created by lxj on 17/2/16.
 * 下拉刷新和滚动加载的recyclerview
 */

public class PlRefreshRecyclerViewActivity extends BaseActivity {
    @Bind(R.id.re) RecyclerView recyclerView;
    @Bind(R.id.refresh) RefreshLayout refreshLayout;
//    private MyAdapter adapter;
    private PlAdapter adapter;
    private int flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plrefresh);
        ButterKnife.bind(this);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new LDividerItemDecoration(this, LDividerItemDecoration.VERTICAL_LIST));
//        adapter = new MyAdapter();
        adapter = new PlAdapter();
        adapter.setOnItemEventListener(new BasicAdapter.OnItemEventListener() {
            @Override
            public void onItemEvent(RefreshLayout.Adapter adapter, int position, int event, Object data) {
                if (event == ((PlAdapter)adapter).LEFT_CLICK) {
                    showLongToast("左边被点击了，position＝" + position + " data=" + data);
                } else if (event == ((PlAdapter)adapter).RIGHT_CLICK) {
                    showLongToast("右边被点击了，position＝" + position);
                }
            }
        });
        refreshLayout.setAdapter(recyclerView,adapter);
        refreshLayout.setOnRefreshHandler(new RefreshLayout.OnRefreshHandler() {
            @Override
            public void refresh() {
                flag = 0;
                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> datas = new ArrayList<>();
                        for (int i = 0; i < 30; i++) {
                            datas.add("DATA: " + i);
                        }
                        adapter.setDatas(datas);
                        refreshLayout.setRefreshing(false);
                    }
                },1500);

            }

            @Override
            public void loadMore() {
                super.loadMore();
                flag ++;
                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(flag % 3 == 2){
                            refreshLayout.loadError();
                        }else if(flag % 3 == 1){
                            List<String> datas = new ArrayList<>();
                            for (int i = 0; i < 10; i++) {
                                datas.add("ADD: " + i);
                            }
                            adapter.addDatas(datas);
                            refreshLayout.loadComplete(true);
                        }else {
                            refreshLayout.loadComplete(false);
                        }
                    }
                },1000);


            }
        });
        refreshLayout.autoRefresh();
    }

//    private class MyAdapter extends RefreshLayout.Adapter {
//
//        List<String> datas = new ArrayList<>();
//
//        public void setDatas(List<String> datas) {
//            this.datas = datas;
//            notifyDataSetChanged();
//        }
//
//        public void addDatas(List<String> datas) {
//            this.datas.addAll(datas);
//            notifyDataSetChanged();
//        }
//
//        @Override
//        public RecyclerView.ViewHolder onCreateItemHolder(ViewGroup parent, int viewType) {
//            return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false)) {
//            };
//        }
//
//        @Override
//        public void onBindItemHolder(final RecyclerView.ViewHolder holder, int position) {
//            TextView tv = (TextView) holder.itemView.findViewById(R.id.tv_content);
//            tv.setText(datas.get(position));
//        }
//
//        @Override
//        public int getCount() {
//            return datas.size();
//        }
//    }
}
