package com.example.ioc_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.butterknifelib.annotation.BindView;
import com.example.butterknifelib.annotation.ContentView;
import com.example.butterknifelib.annotation.OnClick;
import com.example.butterknifelib.annotation.OnLongClick;
import com.example.butterknifelib.util.ButterKnife;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @OnClick({R.id.button})  //可注入多个view
    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                textView.setText("我是手写ButterKnife框架");
                break;
            default:
                Log.e("xxxxxxxxxxx","view not found");
                break;
        }
    }

    @OnLongClick({R.id.button})  //可注入多个view
    public void onLongClick(View view){
        switch (view.getId()){
            case R.id.button:
                textView.setText("button  长按了");
                Log.e("xxxxxxxxxxx","button  长按了");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ButterKnife.inJect(this);

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
    }
}
