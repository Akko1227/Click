package com.example.xutin_000.finalexam;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

public class HomeActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //开始游戏button3
        dbHelper = new MyDatabaseHelper(this,"MyGame.db", null, 2);

        // 显示intent用来跳转页面

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  LitePal.getDatabase();
                dbHelper.getWritableDatabase();


                Toast.makeText(HomeActivity.this, "开始游戏", Toast.LENGTH_SHORT).show();
                Intent intent1;
                intent1=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent1);


            }
        });
        //进入排名button4

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentacc3=new Intent(HomeActivity.this,RankActivity.class);
                startActivity(intentacc3);
            }
        });
        //再玩一次buttonadd
        /*Button buttonadd = (Button) findViewById(R.id.buttonadd);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentacc4=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intentacc4);
            }
        });*/
//神秘商店btntoshop

        Button btntoshop = (Button) findViewById(R.id.btntoshop);
        btntoshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents1;
                intents1=new Intent(HomeActivity.this,ShopActivity.class);
                startActivity(intents1);
            }
        });


    }
}
