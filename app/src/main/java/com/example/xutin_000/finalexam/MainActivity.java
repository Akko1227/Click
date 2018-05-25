package com.example.xutin_000.finalexam;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
//倒计时
import com.example.xutin_000.finalexam.MyDataClass;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    TextView tv2;
 //   TextView tvm1;
    int n1=0;
    String str1;
//倒计时数字
 //   String mname;
private ImageView iv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        tv = (TextView) this.findViewById(R.id.tv);//tv显示当前按键次数=成绩score
        tv2= (TextView) this.findViewById(R.id.tv2);//tv2显示玩家名
        iv1 = (ImageView) findViewById(R.id.imageView2);
        //设置游戏入场图片
        switch(MyDataClass.skinid){
            case 1:
                iv1.setImageResource(R.drawable.akko_3);
                break;
            case 2:
                iv1.setImageResource(R.drawable.cha1);
                break;
            default:
                iv1.setImageResource(R.drawable.akko_3);
                break;
        }


        //    mname=getIntent().getStringExtra("string_data");
        tv2.setText(getIntent().getStringExtra("string_data")+"的成绩：");


        //计数器button
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            int tempa=0;//用tempa的值控制两张图片随点击交替出现。
            @Override
            public void onClick(View v) {
                str1 = String.valueOf(n1 + 1);
                n1 = Integer.parseInt(str1);
                //tv.setText(str1);
                tv2.setText(getIntent().getStringExtra("string_data")+"的成绩："+str1+"");
                if(tempa%2==0) {
                    switch (v.getId()) {
                        case R.id.button:
                            //switch-case语句增加修改皮肤功能
                            switch(MyDataClass.skinid){
                                case 1:
                                    iv1.setImageResource(R.drawable.akko_4);
                                    break;
                                case 2:
                                    iv1.setImageResource(R.drawable.cha2);
                                    break;
                                default:
                                    iv1.setImageResource(R.drawable.akko_4);
                                    break;
                            }
                            //iv1.setImageResource(R.drawable.cha2);//akko_4
                        default:
                            break;
                    }
                }
                else
                {
                    switch (v.getId()) {
                        case R.id.button:
                            //switch-case语句增加修改皮肤功能
                            switch(MyDataClass.skinid){
                                case 1:
                                    iv1.setImageResource(R.drawable.akko_3);
                                    break;
                                case 2:
                                    iv1.setImageResource(R.drawable.cha1);
                                    break;
                                default:
                                    iv1.setImageResource(R.drawable.akko_3);
                                    break;
                            }
                        default:
                            break;
                    }
                }
                tempa++;

                //        Toast.makeText(MainActivity.this, "You clicked Button", Toast.LENGTH_SHORT).show();

            }
        });
        //重置按钮
 /*       Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=0;
                str1 ="0";
                tv.setText(str1);

                //if (button.getVisibility()==View.VISIBLE){
                button.setVisibility(4);//4表示不可见。不知道为什么btnSubmit.setVisibility(View.VISIBLE);不好用
            //}else{
                 //   button.setVisibility(View.GONE);
              //  }
            }

        });*/
        /***/
        final Intent it = new Intent(MainActivity.this, AccountActivity.class); //你要转向的Activity
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                String mname;
                mname=getIntent().getStringExtra("string_data");
               // button.setVisibility(4);//在此处设置按钮不可见会导致程序闪退 不知道为什么
                it.putExtra("str_mn",mname);//将玩家名字传递到下一个activity
                it.putExtra("str_ms",str1);//将玩家成绩传递到下一个activity
                startActivity(it); //执行
            }
        };
        timer.schedule(task, 1000 * 10);//10s
        /***/

    }
}
