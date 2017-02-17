package dx168.com.demo.apapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;
import dx168.com.demo.util.Logger;
import dx168.com.demo.view.RefreshLayout;

/**
 * Created by lxj on 17/2/17.
 */

public abstract class BasicAdapter<T> extends RefreshLayout.Adapter {
    protected List<T> datas;
    protected Integer layoutResource;
    protected Class<?> viewHolderClazz;

    //需要子类复写
    public BasicAdapter(Integer layoutResource,Class<?> viewHolderClazz) {
        this.layoutResource = layoutResource;
        this.viewHolderClazz = viewHolderClazz;
    }

    @Override
    public RecyclerView.ViewHolder onCreateItemHolder(ViewGroup parent, int viewType) {
        return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutResource, parent, false)) {
        };
    }

    @Override
    public void onBindItemHolder(RecyclerView.ViewHolder holder, int position) {
        T t = datas.get(position);
        View convertView = holder.itemView;
        Object viewHolder = getViewHolder();
        ButterKnife.bind(viewHolder, convertView);
        bindData(position, viewHolder, t);
    }

    protected Object getViewHolder() {
        try {
            return viewHolderClazz.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<T> getData() {
        return datas;
    }


    public void setDatas(List<T> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void addDatas(List<T> datas) {
        if (getData() != null) {
            this.datas.addAll(datas);
            Logger.d(">>>>添加数据: " + datas.toString());
            notifyDataSetChanged();
        } else {
            setDatas(datas);
        }
    }

    public void addData(T data) {
        if (getData() != null) {
            this.datas.add(data);
            Logger.d(">>>>添加数据: " + data.toString());
            notifyDataSetChanged();
        } else {
            List<T> dataList = new ArrayList<>();
            dataList.add(data);
            setDatas(dataList);
        }
    }

    public void delete(int position) {
        getData().remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount()  {
        return datas != null ? datas.size() : 0;
    }

    protected abstract void bindData(int position, Object o, T t);

    private OnItemEventListener mOnItemEventListener;

    public void emitEvent(int position,int event) {
        emitEvent(position,event,null);
    }

    protected void emitEvent(int position,int event,Object data) {
        if (mOnItemEventListener != null) {
            mOnItemEventListener.onItemEvent(this,position,event,data);
        }
    }

    public void setOnItemEventListener(OnItemEventListener listener) {
        this.mOnItemEventListener = listener;
    }

    public interface OnItemEventListener {
        void onItemEvent(RefreshLayout.Adapter adapter, int position, int event, Object data);
    }
}
