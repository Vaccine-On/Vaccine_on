package com.example.vaccine_on;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    private EditText email_join;
    private EditText pwd_join;
    private EditText hospital_code_join;
    private EditText hospital_name_join;
    private EditText hospital_phone_number_join;
    private EditText hospital_address_join;
    private Button sign_up;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestoreDb;
    ProgressDialog pd;

    String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email_join = (EditText) findViewById(R.id.sign_up_email);
        pwd_join = (EditText) findViewById(R.id.sign_up_pwd);
        hospital_code_join = (EditText) findViewById(R.id.hospital_code);
        hospital_name_join = (EditText) findViewById(R.id.hospital_name);
        hospital_phone_number_join = (EditText) findViewById(R.id.hospital_phone_number);
        hospital_address_join = (EditText) findViewById(R.id.hospital_address);
        sign_up = (Button) findViewById(R.id.sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        firestoreDb = FirebaseFirestore.getInstance();

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = new ProgressDialog(SignUpActivity.this);
                pd.setMessage("준비중입니다");
                pd.show();

                String email = email_join.getText().toString().trim();
                String pwd = pwd_join.getText().toString().trim();
                String hospital_code = hospital_code_join.getText().toString().trim();
                String hospital_name = hospital_name_join.getText().toString().trim();
                String hospital_phone_number = hospital_phone_number_join.getText().toString().trim();
                String hospital_address = hospital_address_join.getText().toString().trim();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd) ||
                        TextUtils.isEmpty(hospital_code) || TextUtils.isEmpty(hospital_name) ||
                        TextUtils.isEmpty(hospital_phone_number) || TextUtils.isEmpty(hospital_address)) {
                    Toast.makeText(SignUpActivity.this, "모든 항목을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (pwd.length() < 6) {
                    Toast.makeText(SignUpActivity.this, "비밀번호를 6자 이상으로 설정해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    register(email, pwd, hospital_code, hospital_name, hospital_phone_number, hospital_address);
                }
            }
        });
    }
    private void register(final String email, String pwd, String hospital_code, String hospital_name, String hospital_phone_number, String hospital_address){
        firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            firestoreDb = FirebaseFirestore.getInstance();

                            HashMap<String, Object> user = new HashMap<>();
                            user.put("email", email);
                            user.put("pwd", pwd);
                            user.put("hospital_code", hospital_code);
                            user.put("hospital_name", hospital_name);
                            user.put("hospital_phone_number", hospital_phone_number);
                            user.put("hospital_address", hospital_address);

                            firestoreDb.collection("users")
                                    .add(user)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            pd.dismiss();
                                            Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(intent);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error adding document", e);
                                        }
                                    });
                        }
                        else {
                            pd.dismiss();
                            Log.e("!!!!!!!!!!!", task.getException().toString());
                            //Toast.makeText(SignUpActivity.this, "이미 존재하는 이메일입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}