package dx168.com.demo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by lxj on 17/2/15.
 */

public class MultipleItem implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;

    private int itemType;

    public MultipleItem(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public String getText() {
        return "刘贤俊";
    }

    public int getUrl() {
        return R.drawable.ic_launcher;
    }
}
