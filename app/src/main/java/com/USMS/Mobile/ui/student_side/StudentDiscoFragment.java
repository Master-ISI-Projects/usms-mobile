package com.USMS.Mobile.ui.student_side;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.USMS.Mobile.R;

import static android.content.Context.MODE_PRIVATE;

public class StudentDiscoFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_disco, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        SharedPreferences preferences = getActivity().getSharedPreferences("com.USMS.Mobile.token", 0);
        preferences.edit().remove("token").commit();

        Intent i = new Intent(getActivity(), com.USMS.Mobile.MainActivity.class);
        startActivity(i);

    }
}
