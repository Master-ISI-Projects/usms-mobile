package com.USMS.Mobile.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.USMS.Mobile.R;

import java.util.Calendar;

public class AuthFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auth, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final TextView dateET = view.findViewById(R.id.Auth_Date_edit_Text);
        final EditText eTNationaleCode, eTApoge;

        eTNationaleCode = view.findViewById(R.id.eTNationale_login);
        eTApoge  = view.findViewById(R.id.eTApoge_login);


        dateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);


                DatePickerDialog.OnDateSetListener setListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.i("minetag", "data set "+year+ " month "+month+ " day "+dayOfMonth);
                        int Truemonth = month + 1;
                        String date = year + "/" + Truemonth + "/" + dayOfMonth;
                        dateET.setText(date);
                    }
                };

                DatePickerDialog dpq = new DatePickerDialog(
                        getActivity(),
                        R.style.Theme_AppCompat_Dialog,
                        setListener,
                        year,
                        month,
                        day);
                dpq.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dpq.show();

            }
        });
        Button b = view.findViewById(R.id.button_authentication);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NationaleCode = eTNationaleCode.getText().toString().trim();
                String ApogeCode = eTApoge.getText().toString().trim();
                String BirthDate = dateET.getText().toString().trim();


                if (NationaleCode.isEmpty() || ApogeCode.isEmpty() || BirthDate.isEmpty())
                {
                    Toast.makeText(getActivity(), "veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                }
                else {
                    
                }
            }
        });

    }
}
