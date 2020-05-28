package com.example.shimada_workspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.d("button","ボタン押されたよ");
                Log.d("","サブ画面に遷移します。");
                // 別アクティビティでの画面遷移
                Intent intent = new Intent(getApplication(), SubActivity.class);
                startActivity(intent);

                // 同一アクティビティでの画面遷移
//                setContentView(R.layout.activity_sub);

            }

        });

    }
}
