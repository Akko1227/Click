package com.example.xutin_000.finalexam;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RankActivity extends AppCompatActivity {
    TextView tvr3;

    private MyDatabaseHelper dbHelper;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        tvr3 = (TextView) this.findViewById(R.id.tvrank3);
        dbHelper = new MyDatabaseHelper(this, "MyGame.db", null, 2);

        SQLiteDatabase db = dbHelper.getWritableDatabase();


        Button deleteButton=(Button)findViewById(R.id.btndelete);
        deleteButton.setOnClickListener(new View.OnClickListener(){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            @Override
            public void onClick(View v){
                Toast.makeText(RankActivity.this, "删除成功，请重新进入排名页面。", Toast.LENGTH_SHORT).show();
                db.execSQL("delete from MyGame");
                db.execSQL("DELETE FROM sqlite_sequence");//所有自增列归零
            }

        });


        Cursor cursor2 =db.rawQuery("select * from MyGame order by score DESC;",null);
        if (cursor2.moveToFirst()) {
            do {
                // 遍历Cursor对象，取出数据并打印'''''''''''''''''''''''''''''''''''''
                int id = cursor2.getInt(cursor2.getColumnIndex("id"));
                String name = cursor2.getString(cursor2.getColumnIndex("name"));
                int score = cursor2.getInt(cursor2.getColumnIndex("score"));
                Log.d( "RankActivity","ID is"+id+". The name is " + name+ ". The author is " + score+".");
                tvr3.append(""+id+"      " + name+ "      " + score+'\n');

            } while (cursor2.moveToNext());
        }
        cursor2.close();



        // 查询Book表中所有的数据
       /* Cursor cursor2 = db.query("Score", null, null, null, null, null, null);
        if (cursor2.moveToFirst()) {
            do {
                // 遍历Cursor对象，取出数据并打印'''''''''''''''''''''''''''''''''''''
                String name = cursor2.getString(cursor2.getColumnIndex("name"));
                int score = cursor2.getInt(cursor2.getColumnIndex("score"));
                tvr3.setText( "The name is " + name+ ". The author is " + score+".");

            } while (cursor2.moveToNext());
        }
        cursor2.close();*/
/*
        Cursor cursor2 =db.rawQuery("select * from MyGame",null);
        if (cursor2.moveToFirst()) {
            do {
                // 遍历Cursor对象，取出数据并打印'''''''''''''''''''''''''''''''''''''
                String name = cursor2.getString(cursor2.getColumnIndex("name"));
                int score = cursor2.getInt(cursor2.getColumnIndex("score"));
                Log.d( "RankActivity","The name is " + name+ ". The author is " + score+".");

            } while (cursor2.moveToNext());
        }
        cursor2.close();*/

        /*Cursor cursor2 = db.rawQuery("select * from MyGame", null);
        if (cursor2.next()) {
            tvr3.setText(cursor2.getString("name"));
        }*/
    }
}
