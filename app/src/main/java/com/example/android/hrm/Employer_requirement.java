package com.example.android.hrm;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Employer_requirement extends AppCompatActivity {
    Button create_work;
    Spinner job;
    EditText number_days,number_labourer,job_description,dummy;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_requirement);
        number_days= findViewById(R.id.number_of_days);
        number_labourer= findViewById(R.id.number_of_labourer);
        job_description = findViewById(R.id.job_description);
        dummy=findViewById(R.id.dummy);
        create_work=(Button)findViewById(R.id.create_work);
        job=(Spinner) findViewById(R.id.spinner_employer_need);
        databaseReference =db.getReference("Employer");
        create_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                String nd=number_days.getText().toString();
                String nl=number_labourer.getText().toString();
                String ss=job_description.getText().toString();
                String j=(job.getSelectedItem()).toString();
                if(Integer.parseInt(nd)>20||nd.isEmpty())
                {
                    number_days.setError("Enter within range 1-20");
                    number_days.requestFocus();
                    return;
                }
                if(Integer.parseInt(nl)>20 ||nl.isEmpty())
                {
                    number_labourer.setError("Enter within range 1-20");
                    number_labourer.requestFocus();
                    return;
                }
                String[] len=ss.split("\\s+");
                int word=len.length;
                if(word>5||ss.isEmpty())
                {
                    job_description.setError("not more 5 words");
                    job_description.requestFocus();
                    return;
                }
                if(j.isEmpty())
                {
                    job.setPrompt("required");
                    job.requestFocus();
                    return;
                }
                senddata();
            }
        });
    }

    public void senddata()
    {
        String no_days=number_days.getText().toString();
        String no_labourer=number_labourer.getText().toString();
        String job_desp=job_description.getText().toString();
        String job_required=(job.getSelectedItem()).toString();
        String id=databaseReference.push().getKey();
        if(!TextUtils.isEmpty(job_required)) {
            Employer_requirement_send emp = new Employer_requirement_send(id, no_days,no_labourer,job_desp,job_required);
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

