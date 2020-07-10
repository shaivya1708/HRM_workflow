package com.example.android.hrm;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    TextView Name, Number, OCC,EXP;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Name = findViewById(R.id.textView3);
        Number = findViewById(R.id.textView4);
        OCC = findViewById(R.id.textView5);
        EXP = findViewById(R.id.textView6);
        Name.setText("नाम : "+(getIntent().getStringExtra("Name")));
        Number.setText("फ़ोन नंबर : "+(getIntent().getStringExtra("Phone")));
        OCC.setText("व्यवसाय : "+(getIntent().getStringExtra("Occ")));
        EXP.setText("अनुभव : "+(getIntent().getStringExtra("Exp")));
        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
