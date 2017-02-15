package dx168.com.demo.apapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import dx168.com.demo.MultipleItem;
import dx168.com.demo.R;

/**
 * Created by lxj on 17/2/15.
 */

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    public MultipleItemQuickAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.item_recycler);
        addItemType(MultipleItem.IMG, R.layout.item_img);
    }

    @Override
    protected void convert(BaseViewHolder holder, MultipleItem item) {
        switch (holder.getItemViewType()) {
            case MultipleItem.TEXT:
                holder.setText(R.id.tv_content, item.getText());
                break;

            case MultipleItem.IMG:
                holder.setImageResource(R.id.iv, item.getUrl());
                break;
        }
    }
}
