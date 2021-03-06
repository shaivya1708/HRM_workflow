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

public class RegistrationActivity extends AppCompatActivity {

    Button employer, employee;
    EditText Name, Phone;
    Spinner occ_spinner1;
    Spinner exp_spinner2;
    Spinner gen_spinner3;
    String occ,exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Name = findViewById(R.id.editTextTextPersonName1);
        Phone = findViewById(R.id.editTextPhone1);
        occ_spinner1 = (Spinner) findViewById(R.id.spinner1);
        exp_spinner2 = (Spinner) findViewById(R.id.spinner2);
        gen_spinner3 = (Spinner) findViewById(R.id.spinner3);

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Name.getText() == null) {
                    Toast.makeText(getApplicationContext(), "नाम आवश्यक है", Toast.LENGTH_SHORT).show();
                    Name.requestFocus();
                } else if (Phone.getText() == null || Phone.getText().length() != 10) {
                    Toast.makeText(getApplicationContext(), "फ़ोन नंबर मान्य नहीं है", Toast.LENGTH_SHORT).show();
                    Phone.requestFocus();
                } else {
                    occ = (occ_spinner1.getSelectedItem()).toString();
                    exp = (exp_spinner2.getSelectedItem()).toString();
                    Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                    i.putExtra("Name", Name.getText().toString());
                    i.putExtra("Phone", Phone.getText().toString());
                    i.putExtra("occ", occ);
                    i.putExtra("exp", exp);
                    i.putExtra("from","employee");
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}

