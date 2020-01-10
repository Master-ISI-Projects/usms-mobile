package com.USMS.Mobile.ui.student_side;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.USMS.Mobile.R;


public class StudentHomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView cardViewStudentHomeToResult = view.findViewById(R.id.on_student_result_click);
        CardView cardViewStudentHomeToNotif = view.findViewById(R.id.on_student_notif_click);
        CardView cardViewStudentHomeToTable = view.findViewById(R.id.on_student_table_click);
        CardView cardViewStudentHomeToAccro = view.findViewById(R.id.on_student_accro_click);

        cardViewStudentHomeToResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), com.USMS.Mobile.Student_result_Activity.class));
            }
        });
        cardViewStudentHomeToNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), com.USMS.Mobile.Student_notification_Activity.class));
            }
        });
        cardViewStudentHomeToTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), com.USMS.Mobile.Student_table_Activity.class));
            }
        });
        cardViewStudentHomeToAccro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), com.USMS.Mobile.Student_Accronyme_Activity.class));
            }
        });

    }

}
