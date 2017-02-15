package dx168.com.demo.apapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import dx168.com.demo.R;

/**
 * Created by lxj on 17/2/15.
 * adapter中的键值对 键是list中的数据类型
 */

public class QuickAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public QuickAdapter(List<String> data) {
        super(R.layout.item_recycler, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String s) {
        int position = holder.getLayoutPosition(); //获取当前item的position
        holder.setText(R.id.tv_content, s);
    }
}
