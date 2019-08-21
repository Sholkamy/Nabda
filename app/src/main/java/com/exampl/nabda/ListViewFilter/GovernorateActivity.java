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

public class GovernorateActivity extends AppCompatActivity {


    //Declaration of view
    private SpecializationDisplayAdapter mGovernorateDisplayAdapter;
    private ListView mGovernorateListView;

    private List<String> mNameOfGovernorate = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_governorate);

        mGovernorateListView = (ListView) findViewById(R.id.GovernorateListView);



        mNameOfGovernorate.add("El Minya");
        mNameOfGovernorate.add("Asyut");
        mNameOfGovernorate.add("Sohag");
        mNameOfGovernorate.add("Qena");
        mNameOfGovernorate.add("Luxor");


        mGovernorateDisplayAdapter = new SpecializationDisplayAdapter(this, R.layout.item_view_filtter, mNameOfGovernorate);


        mGovernorateListView.setAdapter(mGovernorateDisplayAdapter);




        mGovernorateListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.GovernorateChose = mNameOfGovernorate.get(position);
                updateUI();
            }
        });
    }

    private void updateUI() {
        startActivity(new Intent(GovernorateActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(GovernorateActivity.this, MainActivity.class));
        finish();
    }

}
