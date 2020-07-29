package com.example.android.hrm;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration_employer extends AppCompatActivity {

    Button save,home;
    EditText Name, Phone, Address;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer);
        Name = findViewById(R.id.editTextTextPersonName2);
        Phone = findViewById(R.id.editTextPhone2);
        Address = findViewById(R.id.editTextAddress2);
        save=findViewById(R.id.button6);
        home=findViewById(R.id.button7);
       databaseReference =db.getReference("Employer");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                senddata();
                Intent i=new Intent(Registration_employer.this,ProfileActivity.class);
                i.putExtra("Name",Name.getText().toString());
                i.putExtra("Phone",Phone.getText().toString());
                i.putExtra("Address",Address.getText().toString());
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent i=new Intent(Registration_employer.this,ProfileActivity.class);
                startActivity(i);
            }
        });

    }

    public void senddata()
    {
        String name=Name.getText().toString();
        String phn=Phone.getText().toString();
        String add=Address.getText().toString();
        String id=databaseReference.push().getKey();
        if(!TextUtils.isEmpty(name)) {
            Employer emp = new Employer(id, name, phn, add);
            if(id!=null)
            {
                databaseReference.child(id).setValue(emp);
                Toast.makeText(this, "Successfuly data entered", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this,"DATA required",Toast.LENGTH_SHORT).show();
        }
    }

}




