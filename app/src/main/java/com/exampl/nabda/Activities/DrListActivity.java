package com.exampl.nabda.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.exampl.nabda.Adapters.DrInfoDisplayAdapter;
import com.exampl.nabda.Classes.DrData;
import com.exampl.nabda.Dialog.ExampleDialog;
import com.exampl.nabda.ListViewFilter.GovernorateActivity;
import com.exampl.nabda.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DrListActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    /**
     * Firebase Components ...
     */
    private FirebaseDatabase mDrInfoFirebaseDatabase;
    private DatabaseReference mDrInfoMessageDatabaseReference;

    //Declaration of view
    private DrInfoDisplayAdapter mDrInfoDisplayAdapter;
    private ListView primaryMessageListView;
    private List<DrData> DrInformation = new ArrayList<>();
    private ProgressDialog mProgressDialog;
    private ProgressBar mDownloadProgressBar;
    private ImageView mLogoImage;



    //To Show massages in Ur Mob
    ChildEventListener mChildEventListener;

    public static String NameOfPatient;
    public static String PhoneOfPatient;
    public static String DateOfDrSave;
    public static String NameOfDr;



    private boolean TestString = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_list);



        //The Entry point for Database
        mDrInfoFirebaseDatabase = FirebaseDatabase.getInstance();
        mDrInfoMessageDatabaseReference = mDrInfoFirebaseDatabase.getReference().child("Doctors");

        primaryMessageListView = (ListView) findViewById(R.id.GovernorateListView);
        mDownloadProgressBar = (ProgressBar) findViewById(R.id.DownloadProgressBar);
        mLogoImage = (ImageView) findViewById(R.id.DrListActivityLogo);

        mDownloadProgressBar.setVisibility(View.VISIBLE);


        // Initialize message ListView and its adapter
        mDrInfoDisplayAdapter = new DrInfoDisplayAdapter(this, R.layout.item_dr_list, DrInformation);
        mProgressDialog = new ProgressDialog(this);


        primaryMessageListView.setAdapter(mDrInfoDisplayAdapter);


        mLogoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrListActivity.this, MainActivity.class));
                finish(); }
        });


        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                DrData mDrData = dataSnapshot.getValue(DrData.class);
                mDownloadProgressBar.setVisibility(View.GONE);
                mDrInfoDisplayAdapter.add(mDrData);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        };

        primaryMessageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DateOfDrSave = DrInformation.get(position).getDate();
                NameOfDr = DrInformation.get(position).getName();

                primaryMessageListView.getChildAt(position).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDialog();
                    }

                });
            }});

        mDrInfoMessageDatabaseReference.addChildEventListener(mChildEventListener);
    }

    @Override
    public void equals(boolean Test1) {
        if(Test1 = true && TestString) {
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.show();
            mProgressDialog.setCancelable(false);
            startActivity(new Intent(DrListActivity.this, PatientInformationActivity.class));
            finish();
        }

        else if(Test1 = true && !TestString) {
            ViewMessage("ادخل اسم المريض ورقم الهاتف");
        }
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
        exampleDialog.setCancelable(false);

    }

    @Override
    public void applyTexts(String username, String password) {
        TestString = CheckString(username , password);
        NameOfPatient = username;
        PhoneOfPatient = password;
    }

    private boolean CheckString(String username, String password) {
        if(username.length() == 0 || username.length() == 1
            || password.length() == 0 || password.length() == 1)
                return false;

        else
            return true;
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(DrListActivity.this, MainActivity.class));
        finish();
    }

    private void ViewMessage(String message) {
        Toast.makeText(getApplicationContext(), message , Toast.LENGTH_SHORT).show();
    }
}
