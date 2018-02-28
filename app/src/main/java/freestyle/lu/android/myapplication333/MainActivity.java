package freestyle.lu.android.myapplication333;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import freestyle.lu.android.myapplication333.ListActivity.ListActivity;

public class MainActivity extends AppCompatActivity {
    public TextView tv_InList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_InList = (TextView) findViewById(R.id.helloWorld);
        tv_InList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goList = new Intent(MainActivity.this, ListActivity.class);
                startActivity(goList);
            }
        });
    }
}
