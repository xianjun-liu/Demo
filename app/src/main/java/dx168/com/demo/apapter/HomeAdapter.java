package dx168.com.demo.apapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import dx168.com.demo.R;


/**
 * Created by lxj on 17/2/15.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private ArrayList<String> data;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public HomeAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //使用这个条目的宽度是包裹内容 即使设置了match_parent也是无效的
//        MyViewHolder holder = new MyViewHolder(View.inflate(context, R.layout.item_recycler, null));
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.mTv_content.setText(data.get(position));

        if (listener != null) {
            holder.mTv_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(holder.mTv_content, position);
                }
            });

            holder.mTv_content.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongClick(holder.mTv_content, position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTv_content;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTv_content =  (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
