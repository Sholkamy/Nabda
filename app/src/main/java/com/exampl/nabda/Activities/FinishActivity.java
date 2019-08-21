package com.exampl.nabda.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.exampl.nabda.Adapters.DrInfoDisplayAdapter;
import com.exampl.nabda.R;

public class FinishActivity extends AppCompatActivity {

    private TextView mFinishText;
    private ImageView mLogoImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        mFinishText = (TextView) findViewById(R.id.FinishTextView);
        mLogoImage = (ImageView) findViewById(R.id.FinishActivityLogo);

        mFinishText.setText("لقد تم تأكيد حجزك لدى عيادة الدكتور " + DrListActivity.NameOfDr + " فى " + DrListActivity.DateOfDrSave);


        mLogoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinishActivity.this, MainActivity.class));
                finish(); }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(FinishActivity.this, MainActivity.class));
        finish();
    }
}
