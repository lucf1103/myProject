package freestyle.lu.android.myapplication333.ListActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import freestyle.lu.android.myapplication333.R;
import freestyle.lu.android.myapplication333.adapter.MyRecyclerAdapter;

/**
 * Created by lu on 2018/2/28.
 */

public class ListActivity extends Activity {
    RecyclerView recycleListView;
    MyRecyclerAdapter myRecyclerAdapter;
    List<String> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        initView();
    }

    private void initView() {
        recycleListView = findViewById(R.id.recycle_list);
        //设置布局管理器
        recycleListView.setLayoutManager(new LinearLayoutManager(this));
        initData();
        myRecyclerAdapter = new MyRecyclerAdapter(this, mData);
        //设置为垂直布局，这也是默认的
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        recycleListView.setAdapter(myRecyclerAdapter);
        //设置增加或删除条目的动画
        recycleListView.setItemAnimator(new DefaultItemAnimator());

    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("item" + String.valueOf(i));
        }
    }
}
