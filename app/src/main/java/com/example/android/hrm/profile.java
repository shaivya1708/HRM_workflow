package com.example.android.hrm;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class profile extends Fragment {
    Button b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vi=inflater.inflate(R.layout.fragment_profile, container, false);
        b=vi.findViewById(R.id.buttonLogout);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(profile.this.getActivity(),MainActivity.class);
                startActivity(i);
            }
        });
        return vi;
    }
}