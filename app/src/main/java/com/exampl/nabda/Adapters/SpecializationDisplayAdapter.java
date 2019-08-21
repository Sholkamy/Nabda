package com.exampl.nabda.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.exampl.nabda.R;

import java.util.List;

public class SpecializationDisplayAdapter extends ArrayAdapter<String>{
    public SpecializationDisplayAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_view_filtter, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.textViewSubtitle);


        String s = getItem(position);

        nameTextView.setText(s);


        return convertView;
    }
}

