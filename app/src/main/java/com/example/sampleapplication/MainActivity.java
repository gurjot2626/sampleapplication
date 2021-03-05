package com.example.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Spinner dropdown;
    EditText name;
    EditText vote_Id;
    ToggleButton tog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GETTING THE OBJECTS BY ID
        btn = (Button) findViewById(R.id.chkBtn);
        dropdown = (Spinner) findViewById(R.id.mainType);
        name = (EditText) findViewById(R.id.nameEt);
        vote_Id = (EditText) findViewById(R.id.voteId);
        tog = (ToggleButton) findViewById(R.id.togbtn);

        //SETTING THE TOGGLE BUTTON TEXT
        tog.setText("Accept");
        tog.setTextOff("Accept");
        tog.setTextOn("Refuse");
        String[] arr = new String[]{};
        String[] arr2 = new String[]{};

        List<String> arrlist
                = new ArrayList<String>(
                Arrays.asList(arr));
        List<String> arrlist2
                = new ArrayList<String>(
                Arrays.asList(arr2));

        //BUTTON CLICK EVENT
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //STORING THE VALUES AS STRING FOR MANIPULATION
                String nameText = name.getText().toString().trim();
                String voteIdText = vote_Id.getText().toString().trim();
                String spinnerItem = dropdown.getSelectedItem().toString();

                //CHECK FOR CANDIDATE ALREADY EXIST OR NOT
                if ((!arrlist.contains(nameText)) && (!arrlist2.contains(voteIdText))) {

                    if (tog.isChecked()) {


                        //CHECK FOR EMPTY STRING AND ITEM NOT SELECTED

                        if ((nameText.length() > 0) && (voteIdText.length() > 0) && (spinnerItem != "Choose a Candidate")) {
                            arrlist.add(nameText);
                            arrlist2.add(voteIdText);
                            Toast.makeText(MainActivity.this, "VOTED SUCCESSFULLy", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, "IMPROPER DATA", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "PLEASE ACCEPT THE TERMS", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(MainActivity.this, "CANDIDATE ALREADY EXIST", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}