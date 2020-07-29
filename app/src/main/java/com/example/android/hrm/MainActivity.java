package com.example.android.hrm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //FragmentManager fm=getSupportFragmentManager();
        //fm.beginTransaction().add(R.id.fragment,fragment_history).commit();
        //editText = findViewById(R.id.editTextPhone3);
       findViewById(R.id.home_button).setOnClickListener(new View.OnClickListener() {
         @Override
          public void onClick(View v) {
             FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
             ft.add(R.id.fragment,new home());
             ft.commit();
             //   String number = editText.getText().toString().trim();

               // if (number.isEmpty()) {
                //editText.setError("Field Empty");
                //editText.requestFocus();
                  //return;
                //}
                //if (number.length() != 10) {
                //editText.setError("Valid number is required");
                //editText.requestFocus();
                  //return;
                //}

                //String phoneNumber = "+91" + number;
                //Intent intent = new Intent(MainActivity.this, Employer_requirement.class);
                //intent.putExtra("phonenumber", phoneNumber);
                //startActivity(intent);
           }
        });
       findViewById(R.id.history_button).setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v)
           {
               FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
               ft.add(R.id.fragment,new history());
               ft.commit();
           }
       });
        findViewById(R.id.profile_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.add(R.id.fragment,new profile());
                ft.commit();
            }
        });
    }

}