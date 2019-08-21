package com.exampl.nabda.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.exampl.nabda.Classes.DrData;
import com.exampl.nabda.R;

import java.util.List;

public class DrInfoDisplayAdapter extends ArrayAdapter<DrData>{
    public DrInfoDisplayAdapter(Context context, int resource, List<DrData> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_dr_list, parent, false);
        }

        TextView mNameTextView = (TextView) convertView.findViewById(R.id.NameOfDrTextView);
        TextView mSpecialtyTextView = (TextView) convertView.findViewById(R.id.SpecialtyOfDrTextView);
        TextView mAddressTextView = (TextView) convertView.findViewById(R.id.AddressOfDrTextView);
        TextView mPhoneTextView = (TextView) convertView.findViewById(R.id.PhoneOfDrTextView);
        TextView mPriceTextView = (TextView) convertView.findViewById(R.id.PriceOfDrTextView);
        TextView mDateTextView = (TextView) convertView.findViewById(R.id.DateOfDrTextView);



        DrData mDrData = getItem(position);

        mNameTextView.setText(mDrData.getName());
        mSpecialtyTextView.setText(mDrData.getSpecialty());
        mAddressTextView.setText(mDrData.getAddress());
        mPhoneTextView.setText(mDrData.getPhone());
        mPriceTextView.setText("" + mDrData.getPrice());
        mDateTextView.setText(mDrData.getDate());


        return convertView;
    }
}

