package com.khaana.mad;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity {

    EditText email, pass;
    Button button3;
    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        button3 = findViewById(R.id.button3);
        auth = FirebaseAuth.getInstance();
        authm = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){

                        startActivity(new Intent(LoginActivity.this, menuActivity.class));

                }

            }
        };

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startlogin();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authm);
    }

    private void startlogin() {

        String Email = email.getText().toString();
        String Pass = pass.getText().toString();

        if (TextUtils.isDigitsOnly(Email) || TextUtils.isEmpty(Pass)) {

            Toast.makeText(LoginActivity.this, "Some Fields are Empty!", Toast.LENGTH_LONG).show();

        }
        else {
            auth.signInWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!(task.isSuccessful())) {

                        Toast.makeText(LoginActivity.this, "Signin Failed!", Toast.LENGTH_LONG).show();

                    }else {

                        startActivity(new Intent(LoginActivity.this, menuActivity.class));
                    }

                }
            });



        }
    }

}