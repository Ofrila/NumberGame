package com.example.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;


//还要写一个产生随机数的函数
public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button checkBtn;
    int randomNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText) findViewById(R.id.et_number);
        checkBtn=(Button) findViewById(R.id.btn_check);

        //produce random number
        randomNum=(int)(Math.random()*9999);
        //给按钮check添加响应事件
        checkBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                int inputnum=(int)Integer.parseInt(editText.getText().toString());

                if(inputnum<1 || inputnum>9999){
                    Toast toast=Toast.makeText(getApplicationContext(),"The number is valid!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();

                }
                else{
                    if(inputnum==randomNum){
                        //right
                        //若正确，可以直接跳到“成功”的页面，而不是只是弹出一个小框
                        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(intent);

                    }

                    if(inputnum<randomNum){
                        //low
                       // Toast.makeText(MainActivity.this,"Wrong!The number is higher",Toast.LENGTH_LONG).show();
                        Toast toast=Toast.makeText(getApplicationContext(),"Wrong!The number is higher than you guess!",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();

                    }

                    if(inputnum>randomNum){
                        //high
                        //Toast.makeText(MainActivity.this,"Wrong!The number is lower",Toast.LENGTH_LONG).show();
                        Toast toast=Toast.makeText(getApplicationContext(),"Wrong!The number is lower than you guess!",Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                }


            }

        });

    }









}
