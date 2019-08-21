package com.exampl.nabda.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.exampl.nabda.ListViewFilter.GovernorateActivity;
import com.exampl.nabda.ListViewFilter.SpecializationActivity;
import com.exampl.nabda.ListViewFilter.ZoneActivity;
import com.exampl.nabda.R;

public class MainActivity extends AppCompatActivity {


    /**
     * Views ...
     */
    private Button mSearchButton;
    private Button mGovernorateButton;
    private Button mZoneButton;
    private Button mSpecializationButton;
    private LinearLayout mErrorGovernorateImageView;
    private LinearLayout mErrorSpecializationImageView;
    private ImageView mLogoImage;



    public static String Dr_Specialty;
    public static String GovernorateChose;
    public static String ZoneChose;


    private long backPressedTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchButton = (Button) findViewById(R.id.SearchButton);
        mGovernorateButton = (Button) findViewById(R.id.GovernorateButton);
        //mZoneButton = (Button) findViewById(R.id.ZoneButton);
        mSpecializationButton = (Button) findViewById(R.id.SpecializationButton);
        mErrorGovernorateImageView = (LinearLayout) findViewById(R.id.GovernorateError);
        mErrorSpecializationImageView = (LinearLayout) findViewById(R.id.SpecializationError);
        mLogoImage = (ImageView) findViewById(R.id.MainActivityLogo);


        CheckView();


        mLogoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent()); }
        });


        mGovernorateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GovernorateActivity.class));
                finish(); }
        });


        /*mZoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ZoneActivity.class));
                finish(); }
        });*/


        mSpecializationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SpecializationActivity.class));
                finish(); }
        });


        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckCompleteProcess())
                {
                    startActivity(new Intent(MainActivity.this, DrListActivity.class));
                    finish(); } }});
    }

    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast = Toast.makeText(getBaseContext() , "Press back again to exit" ,Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    private boolean CheckCompleteProcess() {
        if(GovernorateChose == null && Dr_Specialty == null)
        {
            mErrorGovernorateImageView.setVisibility(View.VISIBLE);
            mErrorSpecializationImageView.setVisibility(View.VISIBLE);
            ViewMessage("ادخل المحافظه وتخصص الطبيب!");
            return false;
        }

        if(GovernorateChose == null)
        {
            mErrorGovernorateImageView.setVisibility(View.VISIBLE);
            ViewMessage("ادخل المحافظه!");
            return false;
        }

        if (Dr_Specialty == null)
        {
            mErrorSpecializationImageView.setVisibility(View.VISIBLE);
            ViewMessage("ادخل تخصص الطبيب!");
            return false;
        }

        return true;
    }

    private void CheckView() {
        if(GovernorateChose == null)
        {
            mGovernorateButton.setText("المحافظه");
            mGovernorateButton.setTextColor(getResources().getColor(R.color.colorWhite));
            mGovernorateButton.setTextSize(24);
            mGovernorateButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_black_24dp, 0);
            //mZoneButton.setEnabled(false);
        }

        if(GovernorateChose != null)
        {
            mGovernorateButton.setText(GovernorateChose);
            mGovernorateButton.setTextColor(getResources().getColor(R.color.colorSelected));
            mGovernorateButton.setTextSize(20);
            mGovernorateButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            //mZoneButton.setEnabled(true);
        }

        /*if(ZoneChose == null)
        {
            mZoneButton.setText("المركز");
            mZoneButton.setTextColor(getResources().getColor(R.color.colorWhite));
            mZoneButton.setTextSize(24);
            mZoneButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_black_24dp, 0);
        }

        if(ZoneChose != null)
        {
            mZoneButton.setText(ZoneChose);
            mZoneButton.setTextColor(getResources().getColor(R.color.colorSelected));
            mZoneButton.setTextSize(24);
            mZoneButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }*/

        if(Dr_Specialty == null)
        {
            mSpecializationButton.setText("تخصص الطبيب");
            mSpecializationButton.setTextColor(getResources().getColor(R.color.colorWhite));
            mSpecializationButton.setTextSize(24);
            mSpecializationButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_black_24dp, 0);
        }

        if(Dr_Specialty != null)
        {
            mSpecializationButton.setText(Dr_Specialty);
            mSpecializationButton.setTextColor(getResources().getColor(R.color.colorSelected));
            mSpecializationButton.setTextSize(24);
            mSpecializationButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private void ViewMessage(String message) {
        Toast.makeText(getApplicationContext(), message , Toast.LENGTH_SHORT).show();
    }

}
