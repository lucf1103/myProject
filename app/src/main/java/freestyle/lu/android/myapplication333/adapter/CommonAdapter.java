package freestyle.lu.android.myapplication333.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lu on 2018/3/5.
 * 通用的adapter和viewHolder
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<CommonAdapter.ViewHolder> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;


    public CommonAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, parent, mLayoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
//        holder.updatePosition(position);
        convert(holder, mDatas.get(position));
    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        private SparseArray<View> mViews;
        private View mConvertView;
        private Context mContext;

        public ViewHolder(Context context, View itemView, ViewGroup parent) {
            super(itemView);
            mContext = context;
            mConvertView = itemView;
            mViews = new SparseArray<View>();
        }

        public static ViewHolder get(Context context, ViewGroup parent, int layoutId) {
            View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                    false);
            ViewHolder holder = new ViewHolder(context, itemView, parent);
            return holder;
        }

        public <T extends View> T getView(int viewId) {
            View view = mViews.get(viewId);
            if (view == null) {
                view = mConvertView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T) view;
        }
    }
}
