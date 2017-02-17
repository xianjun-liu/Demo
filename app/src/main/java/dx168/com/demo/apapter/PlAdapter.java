package dx168.com.demo.apapter;

import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import dx168.com.demo.R;

/**
 * Created by lxj on 17/2/17.
 */

public class PlAdapter extends BasicAdapter<String>{
    public static final int LEFT_CLICK = 0;
    public static final int RIGHT_CLICK = 1;

    public PlAdapter() {
        super(R.layout.item_pl, PlViewHolder.class);
    }

    @Override
    protected void bindData(final int position, Object o, final String data) {
        PlViewHolder holder = (PlViewHolder) o;
        holder.tv_1.setText(data);
        holder.tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emitEvent(position, LEFT_CLICK, data);
            }
        });

        holder.tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emitEvent(position, RIGHT_CLICK, data);
            }
        });
    }

    public static class PlViewHolder {
        @Bind(R.id.tv_1)       TextView    tv_1;
        @Bind(R.id.tv_2)       TextView    tv_2;
    }
}
