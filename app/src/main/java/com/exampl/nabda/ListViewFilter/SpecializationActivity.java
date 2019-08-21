package com.exampl.nabda.ListViewFilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.exampl.nabda.Activities.FinishActivity;
import com.exampl.nabda.Activities.MainActivity;
import com.exampl.nabda.Adapters.SpecializationDisplayAdapter;
import com.exampl.nabda.R;

import java.util.ArrayList;
import java.util.List;

public class SpecializationActivity extends AppCompatActivity {

    //Declaration of view
    private SpecializationDisplayAdapter mSpecializationDisplayAdapter;
    private ListView mSpecializationListView;

    private List<String> mNameOfSpecialty = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialization);


        mSpecializationListView = (ListView) findViewById(R.id.SpecializationListView);



        mNameOfSpecialty.add("كبد وجهاز هضمى");
        mNameOfSpecialty.add("نساء وتوليد");
        mNameOfSpecialty.add("باطنه");
        mNameOfSpecialty.add("عظام");
        mNameOfSpecialty.add("جراحه عامه");
        mNameOfSpecialty.add("عيون");
        mNameOfSpecialty.add("فم وأسنان");
        mNameOfSpecialty.add("علاج طبيعى");
        mNameOfSpecialty.add("سمنه ونحافه");
        mNameOfSpecialty.add("أطفال");
        mNameOfSpecialty.add("انف وأذن");
        mNameOfSpecialty.add("قلب وأوعيه");
        mNameOfSpecialty.add("مخ وأعصاب");
        mNameOfSpecialty.add("معمل تحاليل");
        mNameOfSpecialty.add("مركز أشعه");

        mSpecializationDisplayAdapter = new SpecializationDisplayAdapter(this, R.layout.item_view_filtter, mNameOfSpecialty);


        mSpecializationListView.setAdapter(mSpecializationDisplayAdapter);




        mSpecializationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.Dr_Specialty = mNameOfSpecialty.get(position);
                updateUI();
            }
        });
    }

    private void updateUI() {
        startActivity(new Intent(SpecializationActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SpecializationActivity.this, MainActivity.class));
        finish();
    }

}
