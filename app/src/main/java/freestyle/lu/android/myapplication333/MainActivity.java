package freestyle.lu.android.myapplication333;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
                if (getPackageManager().resolveActivity(goList, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                    try {
                        startActivity(goList);
                    } catch (ActivityNotFoundException e) {
                        Log.e("main:activity", e.toString());
                    }
                }
//                    startActivity(goList);
            }
        });
    }
}
