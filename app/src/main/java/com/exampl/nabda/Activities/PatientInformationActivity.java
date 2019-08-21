package com.exampl.nabda.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.exampl.nabda.ListViewFilter.SpecializationActivity;
import com.exampl.nabda.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PatientInformationActivity extends AppCompatActivity {

    /**
     * Firebase Components ...
     */
    private FirebaseAuth mFirebaseAuth ;


    private Spinner mySpinner;
    private TextView mPatientNameTextView;
    private TextView mWhoSavedPatientNameTextView;
    private TextView mPatientPhoneTextView;
    private TextView mSavedDateTextView;
    private Button mReservationConfirmationButton;
    private ImageView mLogoImage;


    public static String ReservationType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_information);


        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();


        mySpinner = (Spinner) findViewById(R.id.ReservationTypeSpinner);
        mPatientNameTextView = (TextView) findViewById(R.id.PatientNameTextView);
        mWhoSavedPatientNameTextView = (TextView) findViewById(R.id.WhoSavedPatientNameTextView);
        mPatientPhoneTextView = (TextView) findViewById(R.id.PatientPhoneTextView);
        mSavedDateTextView = (TextView) findViewById(R.id.SavedDateTextView);
        mReservationConfirmationButton = (Button) findViewById(R.id.Reservation_Confirmation_Button);
        mLogoImage = (ImageView) findViewById(R.id.PatientInformationActivityLogo);


        mPatientNameTextView.setText("\t" + DrListActivity.NameOfPatient);
        mPatientPhoneTextView.setText("\t" + DrListActivity.PhoneOfPatient);
        mSavedDateTextView.setText("\t" + DrListActivity.DateOfDrSave);
        mWhoSavedPatientNameTextView.setText("\t" + user.getDisplayName());

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(PatientInformationActivity.this,
                R.layout.spinner_item, getResources().getStringArray(R.array.ReservationType));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) { ReservationType = "حجز عادى"; }
                else if (i == 2) { ReservationType = "حجز مستعجل"; }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mLogoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PatientInformationActivity.this, MainActivity.class));
                finish(); }
        });


        mReservationConfirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { {
                startActivity(new Intent(PatientInformationActivity.this, FinishActivity.class));
                finish(); } }});
    }

    @Override
    public void onBackPressed() {
        DrListActivity.NameOfPatient = null;
        DrListActivity.PhoneOfPatient = null;
        DrListActivity.DateOfDrSave = null;

        startActivity(new Intent(PatientInformationActivity.this, DrListActivity.class));
        finish();
    }
}
