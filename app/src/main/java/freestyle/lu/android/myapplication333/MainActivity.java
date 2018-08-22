package freestyle.lu.android.myapplication333;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSMS();
            }
        });
    }

    private void setSMS(){
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");//必须指定type
        smsIntent.putExtra("address", "15158200175,18768490574");//address字段不能改 (用，号分割  可以添加多个手机号)
        smsIntent.putExtra("sms_body", "测试");//sms_body 不能改
        startActivity(smsIntent);
    }

    protected void sendMessageByInterface2() {

//
//        String phoneNumber = vSendNo.getText().toString().trim();
//        String message = vSendContent.getText().toString().trim();
//
//        SmsManager sms = SmsManager.getDefault();
//
//        Intent sentIntent = new Intent(SENT_SMS_ACTION);
//        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, sentIntent, 0);
//
//        Intent deliverIntent = new Intent(DELIVERED_SMS_ACTION);
//        PendingIntent deliverPI = PendingIntent.getBroadcast(this, 0, deliverIntent, 0);
//
//        if (message.length() > 70) {
//            ArrayList<String> msgs = sms.divideMessage(message);
//            ArrayList<PendingIntent> sentIntents =  new ArrayList<PendingIntent>();
//
//            for(int i = 0;i<msgs.size();i++){
//                sentIntents.add(sentPI);
//            }
//            sms.sendMultipartTextMessage(phoneNumber, null, msgs, sentIntents, null);
//        } else {
//            sms.sendTextMessage(phoneNumber, null, message, sentPI, deliverPI);
//        }

    }

 }
