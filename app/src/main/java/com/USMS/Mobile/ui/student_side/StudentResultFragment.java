package com.USMS.Mobile.ui.student_side;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.USMS.Mobile.R;

import java.util.ArrayList;

public class StudentResultFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_result, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TableLayout table = (TableLayout) view.findViewById(R.id.table);

        class Person{
            String name;
            String mail;
            int age;

            public Person(String name, String mail, int age) {
                this.name = name;
                this.mail = mail;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }


        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("name 1", "mail 1", 20));
        persons.add(new Person("name 2", "mail 2", 10));
        persons.add(new Person("name 3", "mail 3", 30));

        for(Person person : persons) {
            TableRow row = new TableRow(getActivity());
            TextView tvName = new TextView(getActivity());
            TextView tvAge = new TextView(getActivity());
            TextView tvMail = new TextView(getActivity());
            tvName.setText(person.getName());
            tvAge.setText(String.valueOf(person.getAge()));
            tvMail.setText(person.getMail());
            tvName.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
            row.addView(tvName);
            row.addView(tvAge);
            row.addView(tvMail);
            table.addView(row);
        }

        /*
        *
        *
        * */

    }
}
