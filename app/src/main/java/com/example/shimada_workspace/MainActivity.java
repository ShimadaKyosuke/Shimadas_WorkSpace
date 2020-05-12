package com.example.shimada_workspace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.functions.FirebaseFunctions;

public class MainActivity extends AppCompatActivity {
    private FirebaseFunctions mFunctions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.d("button","ボタン押されたよ");

                mFunctions = FirebaseFunctions.getInstance();


            }

        });

    }
}
