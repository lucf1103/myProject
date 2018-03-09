package freestyle.lu.android.myapplication333.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import freestyle.lu.android.myapplication333.R;

/**
 * Created by lu on 2018/3/1.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    List<String> data;
    Context context;
    LayoutInflater inflater;

    public MyRecyclerAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.mylist_recycler_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv =  view.findViewById(R.id.tv_item);
        }

//        public MyViewHolder setOnClickListern(int viewid, View.OnClickListener onClickListener) {
//            View view = getView(viewid);
//            view.setOnClickListener(onClickListener);
//            return this;
//        }

    }
}
