
package com.example.android.hrm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



public class ProfileActivity extends AppCompatActivity {


    Button profile;

    String[] fields = {"नाम :", "फ़ोन नंबर :", "पता : "};

    String[] data={"empname","empnumber","empaddress"};

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile=findViewById(R.id.showprofile);
        String phonenumber = getIntent().getStringExtra("Phone");
        String name= getIntent().getStringExtra("Name");
        String address = getIntent().getStringExtra("Address");

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
               String userid=(user.getUid());
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Employer").child(user.getUid());
                    //Query checkUser = reference.child("-MCrtv8P5vL2LdV9hUm_");
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {

                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            final LinearLayout lLayout = (LinearLayout) findViewById(R.id.layour_profile);
                            if (snapshot.exists()) {
                                for (int i = 0; i < 3; i++) {
                                    final TextView tv = new TextView(getBaseContext());
                                    // Prepare textview object programmatically
                                    Object n = snapshot.child(data[i]).getValue();
                                    if (n != null) {
                                        String da;
                                        da = n.toString();
                                        tv.setText(fields[i] + da);
                                        tv.setGravity(Gravity.CENTER);
                                        tv.setTextColor(Color.BLACK);
                                        tv.setTextSize(20);
                                        tv.setId(i + 3);
                                        lLayout.addView(tv);
                                    }

                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


            }
        });
        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, Registration_employer.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
