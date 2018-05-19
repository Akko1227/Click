package com.example.xutin_000.finalexam;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

public class AccountActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;//*
    TextView tvAN;
    TextView tvAS;
    TextView tvR2;//database query
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        dbHelper = new MyDatabaseHelper(this,"MyGame.db", null, 2);//*

        tvAN = (TextView) this.findViewById(R.id.tvAN);//tv显示当前按键次数=成绩score
        tvAS= (TextView) this.findViewById(R.id.tvAS);//tv2显示玩家名
        tvAN.setText("玩家姓名"+getIntent().getStringExtra("str_mn"));
        tvAS.setText("玩家成绩"+getIntent().getStringExtra("str_ms"));

        tvR2 = (TextView) this.findViewById(R.id.tvrank2);//query


        final String sstrms=getIntent().getStringExtra("str_ms");//分两个步骤，将string转换成int类型。
        final String sstrmn=getIntent().getStringExtra("str_mn");
        final int istrms=Integer.parseInt(sstrms);

/*button8 保存成绩*/
        Button button8 = (Button) findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();//*
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //ContentValues values = new ContentValues();
                // 记录写入数据库
                ContentValues values=new ContentValues();
                values.put("name",sstrmn);
                values.put("score",sstrms);
                db.insert("MyGame",null,values);
                values.clear();//*

                //db.execSQL("insert into MyGame(name,score) values(?,?)",new String[]{sstrmn,sstrms});
                //db.rawQuery("select * from MyGame",null);

            }
        });

/*button6 回首页*/
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentacc1=new Intent(AccountActivity.this,HomeActivity.class);
                startActivity(intentacc1);
            }
        });
/*button7 排行榜*//*
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentacc2=new Intent(AccountActivity.this,RankActivity.class);
                startActivity(intentacc2);
            }
        });*/
/*
        List<MyGame> d2= DataSupport.findAll(MyGame.class);
        for (MyGame dd:d2){
            Log.d("AccountActivity","My name is"+dd.getName());
        }*/
//显示成绩
        Button button28 = (Button) findViewById(R.id.button28);
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();//*
                Cursor cursor2 =db.rawQuery("select * from MyGame",null);
                if (cursor2.moveToFirst()) {
                    do {
                        // 遍历Cursor对象，取出数据并打印'''''''''''''''''''''''''''''''''''''
                        int id = cursor2.getInt(cursor2.getColumnIndex("id"));
                        String name = cursor2.getString(cursor2.getColumnIndex("name"));
                        int score = cursor2.getInt(cursor2.getColumnIndex("score"));
                        Log.d( "RankActivity","ID is"+id+". The name is " + name+ ". The author is " + score+".");
                        tvR2.append(""+id+"      " + name+ "      " + score+'\n');

                    } while (cursor2.moveToNext());
                }
                cursor2.close();//*
            }
        });


    }
}
