package com.example.activitytest;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileReader;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //活动的启动模式测试
//        Log.d("FirstActivity", this.toString());
        Log.d("FirstActivity", "task id is:" + getTaskId());
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast显示
//                Toast.makeText(FirstActivity.this, "you click Button1", Toast.LENGTH_SHORT).show();
                //跳转到第二个activity
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                //使用隐式intent启动活动
//                Intent intent = new Intent("com/example/activitytest.ACTION_START");
//                intent.addCategory("com/example/activitytest.MY_CATEGORY");
//                Log.d("data", "onClick: ");
//                //向下一个活动传递参数
//                String data = "hello Second Activity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
                //测试活动的启动模式
//                Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
//                //回调信息测试
//                mStartForResult.launch(new Intent(FirstActivity.this, SecondActivity.class));

            }
        });
//        Button button1 = (Button) findViewById(R.id.button_1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(Intent.ACTION_VIEW);
////                intent.setData(Uri.parse("http://www.baidu.com"));
////                startActivity(intent);
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
//            }
//        });
    }

    //获取回调信息
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
//                Log.d("FirstActivity", String.valueOf(result.getResultCode()+" "+Activity.RESULT_OK));;
                Intent intent = result.getData();
                String returndata = intent.getStringExtra("data_return");
                Log.d("FirstActivity", returndata);
            }
        }
    });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "you click Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you click Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("FirstActivity", "onStart");
    }
}