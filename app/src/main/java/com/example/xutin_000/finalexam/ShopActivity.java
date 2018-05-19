package com.example.xutin_000.finalexam;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        dbHelper = new MyDatabaseHelper(this,"MyGame.db", null, 2);

        Button btns1 = (Button) findViewById(R.id.btns1);
        btns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                String shopidstr;
                shopidstr=editText2.getText().toString();
                int shopidint=Integer.parseInt(shopidstr);
                Toast.makeText(ShopActivity.this, "修改成功！", Toast.LENGTH_SHORT).show();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update MyGame set score=score+10 where id="+shopidint+";");
            }

        });
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText4 = (EditText) findViewById(R.id.editText4);
                String secretword="我爱你";
                if (editText4.getText().toString().equals(secretword)){
                    EditText editText3 = (EditText) findViewById(R.id.editText3);
                    String shopidstr2;
                    shopidstr2=editText3.getText().toString();
                    int shopidint=Integer.parseInt(shopidstr2);
                    Toast.makeText(ShopActivity.this, "修改成功！", Toast.LENGTH_SHORT).show();
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("update MyGame set score=score+100 where id="+shopidint+";");
                }
                else{
                    new AlertDialog.Builder(ShopActivity.this).setTitle("？？？").setMessage("求求你说一句爱我吧呜呜呜").setPositiveButton("好吧", null).show();
                }
            }

        });


    }
}
