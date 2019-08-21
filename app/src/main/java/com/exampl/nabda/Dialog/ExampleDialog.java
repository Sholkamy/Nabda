package com.exampl.nabda.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.exampl.nabda.Activities.DrListActivity;
import com.exampl.nabda.Activities.PatientInformationActivity;
import com.exampl.nabda.R;


public class ExampleDialog extends AppCompatDialogFragment {
    private EditText mPatientNameEditText;
    private EditText mPatientPhoneEditText;
    private ExampleDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog_name, null);

        builder.setView(view)
                .setTitle("ادخل معلومات المريض")
                .setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("التالى", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String PatientName = mPatientNameEditText.getText().toString();
                        String PatientPhone = mPatientPhoneEditText.getText().toString();
                        listener.applyTexts(PatientName , PatientPhone);
                        listener.equals(true);
                    }
                });

        mPatientNameEditText = view.findViewById(R.id.PatientNameEdit);
        mPatientPhoneEditText = view.findViewById(R.id.PatientPhobeEdit);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String username, String password);
        void equals(boolean Test1);
    }
}
