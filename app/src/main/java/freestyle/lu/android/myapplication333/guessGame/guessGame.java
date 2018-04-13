package freestyle.lu.android.myapplication333.guessGame;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import freestyle.lu.android.myapplication333.R;
import freestyle.lu.android.myapplication333.adapter.MyRecyclerAdapter;

/**
 * Created by lu on 2018/3/27.
 */

public class guessGame extends Activity {

    RecyclerView recycleListView;
    MyRecyclerAdapter myRecyclerAdapter;
    Button enterButton;
    EditText numberEdit;
    List<String> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        initView();
    }

    private void initView() {
        numberEdit = findViewById(R.id.edit_enterNumber);
        numberEdit.setText("4321");
        recycleListView = findViewById(R.id.recycle_list);
        //设置布局管理器
        recycleListView.setLayoutManager(new LinearLayoutManager(this));

        //设置为垂直布局，这也是默认的
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter

        //设置增加或删除条目的动画
        recycleListView.setItemAnimator(new DefaultItemAnimator());
        enterButton = findViewById(R.id.btn_init);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();


            }
        });
    }

    private void initData() {
        String stringNumber = null;
        if (numberEdit.getText() != null) {
            stringNumber = numberEdit.getText().toString();
        } else {
            Toast.makeText(this, "请输入值", Toast.LENGTH_LONG).show();
            return;
        }
        if (stringNumber.length() != 4) {
            numberEdit.setText("");
            Toast.makeText(this, "请输入4个数值", Toast.LENGTH_LONG).show();
        } else {
//            String s[] = stringNumber.split("");
            mData.add(stringNumber);
            myRecyclerAdapter = new MyRecyclerAdapter(this, mData);
            recycleListView.setAdapter(myRecyclerAdapter);
        }
//hhhhh测试
    }

    public static void main(String[] args) {
        String str = "1234";
        String[] split = str.split("");
        System.out.println(split.length);
    }

}
