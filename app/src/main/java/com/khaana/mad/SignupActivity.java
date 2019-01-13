package com.khaana.mad;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignupActivity extends AppCompatActivity {

    EditText fname, sname, user, email, pass;
    Button button4;
    FirebaseDatabase database;
    DatabaseReference ref;
    userinfo Userinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fname = findViewById(R.id.fname);
        sname = findViewById(R.id.sname);
        user = findViewById(R.id.user);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        button4 = findViewById(R.id.button4);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("userinfo");
        Userinfo = new userinfo();

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();
                ref.push().setValue(Userinfo);
                Toast.makeText(SignupActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

    }

    private void getValues() {

        Userinfo.setFname(fname.getText().toString());
        Userinfo.setSname(sname.getText().toString());
        Userinfo.setUser(user.getText().toString());
        Userinfo.setEmail(email.getText().toString());
        Userinfo.setPass(pass.getText().toString());

    }




}

