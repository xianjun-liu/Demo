package dx168.com.demo.apapter;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import dx168.com.demo.R;

/**
 * Created by lxj on 17/2/17.
 */

public class PlAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    static final int STATE_MORE = 0, STATE_LOAIND = 1, STATE_END = 2, STATE_ERROR = 3;
    int state = STATE_MORE;

    public void setState(int state) {
        if (this.state != state) {
            this.state = state;
            notifyItemChanged(getItemCount() - 1);
        }
    }

    public int getState() {
        return state;
    }

    List<String> datas = new ArrayList<>();
    public PlAdapter( List<String> data) {
        super(R.layout.item_recycler, data);
        this.datas = data;
    }

    @Override
    protected void convert(BaseViewHolder holder, String item) {
        holder.setText(R.id.tv_content, item);
        int position = holder.getLayoutPosition();
        if (position == getFooterLayoutCount()) {
            ProgressBar progressBar = (ProgressBar) holder.itemView.findViewById(R.id.foot_view_progressbar);
            TextView textView = (TextView) holder.itemView.findViewById(R.id.foot_view_item_tv);
            if (state == STATE_END) {
                progressBar.setVisibility(View.GONE);
                textView.setText("没有更多了");
            } else if (state == STATE_MORE) {
                progressBar.setVisibility(View.GONE);
                textView.setText("点击加载");
            } else if (state == STATE_LOAIND) {
                progressBar.setVisibility(View.VISIBLE);
                textView.setText("加载中...");
            } else if (state == STATE_ERROR) {
                progressBar.setVisibility(View.GONE);
                textView.setText("加载失败,点击重新加载");
            }
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (onRefreshHandler != null && !isRefresh && (state == STATE_MORE || state == STATE_ERROR)) {
//                        setState(STATE_LOAIND);
//                        onRefreshHandler.loadMore();
//                    }
//                }
//            });
        }

    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void addDatas(List<String> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }
}
