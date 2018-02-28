package freestyle.lu.android.myapplication333.ListActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import freestyle.lu.android.myapplication333.R;

/**
 * Created by lu on 2018/2/28.
 */

public class ListActivity extends Activity {
    RecyclerView recycleListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        initView();
    }

    private void initView() {
        recycleListView = findViewById(R.id.recycle_list);
        recycleListView.setLayoutManager(new LinearLayoutManager(this));


    }
}
