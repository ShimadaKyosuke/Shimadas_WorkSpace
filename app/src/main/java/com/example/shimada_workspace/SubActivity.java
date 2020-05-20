package com.example.shimada_workspace;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // サブの読み込み
        setContentView(R.layout.activity_sub);

        // 戻るボタンのイベントリスナー
        final Button button = this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Log.d("button","サブでボタン押されたよ");
                finish();
//                setContentView(R.layout.activity_sub);
            }

        });

        // 登録ボタンのイベントリスナー
        final Button regist = this.findViewById(R.id.regist);
        regist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                Log.d("","サブでボタン押されたよ");

                // 姓の取得
                EditText etLaName = (EditText) findViewById(R.id.lName);
                String strEtLaName = etLaName.getText().toString();
                Log.d("strEtLaName","姓：" + strEtLaName);

                // 名の取得
                EditText etFiName = (EditText) findViewById(R.id.fName);
                String strEtFiName = etFiName.getText().toString();
                Log.d("strEtFiName","名：" + strEtFiName);

                // 性別の取得



                FirebaseFirestore db = FirebaseFirestore.getInstance();
// Create a new user with a first and last name
                Map<String, Object> user = new HashMap<>();
                user.put("first_name", strEtFiName);
                user.put("last_name", strEtLaName);

// Add a new document with a generated ID
                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("regist", "DocumentSnapshot added with ID: " + documentReference.getId());
                                Toast myToast = Toast.makeText(
                                        getApplicationContext(),
                                        "登録が完了しました。",
                                        Toast.LENGTH_SHORT
                                );
                                myToast.show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("regist", "Error adding document", e);
                                Toast myToast = Toast.makeText(
                                        getApplicationContext(),
                                        "登録に失敗しました。",
                                        Toast.LENGTH_SHORT
                                );
                                myToast.show();
                            }
                        });


                Log.d("regist","サブでボタン押されたよ");
                finish();
//                setContentView(R.layout.activity_sub);
            }

        });


    }
}
