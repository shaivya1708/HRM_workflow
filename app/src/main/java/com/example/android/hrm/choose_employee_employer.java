
package com.example.android.hrm;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class choose_employee_employer extends AppCompatActivity {

    Button employer, employee;
    EditText Name, Phone,Address;
    Spinner occ_spinner1;
    Spinner exp_spinner2;
    Spinner gen_spinner3;
    String occ,exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
        employee=(Button) findViewById(R.id.button3);
        employer=(Button) findViewById(R.id.button4);


        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choose_employee_employer.this, RegistrationActivity.class);
                //intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);
            }
        });
        employer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                Intent intent = new Intent(choose_employee_employer.this, Registration_employer.class);
                //intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);

            }
        });
    }
}

