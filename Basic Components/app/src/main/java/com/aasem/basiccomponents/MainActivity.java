package com.aasem.basiccomponents;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etName, etMobileNumber;
    Button btnSubmitData;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale, rbOther;
    TextView tvDOB;
    Spinner spYear;
    Bundle bundle;
    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle = new Bundle();
        etName = findViewById(R.id.et_name);
        etMobileNumber = findViewById(R.id.et_mobile_number);
        btnSubmitData = findViewById(R.id.btn_save);
        rgGender = findViewById(R.id.rg_gender);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        rbOther = findViewById(R.id.rb_other);
        spYear = findViewById(R.id.sp_year);
        tvDOB = findViewById(R.id.tv_dob);

        tvDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });

        btnSubmitData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String mobileNumber = etMobileNumber.getText().toString();
                int selectedGender = rgGender.getCheckedRadioButtonId();
                String gender = null;
                if (selectedGender == R.id.rb_male)
                    gender = "Male";
                if (selectedGender == R.id.rb_female)
                    gender = "Female";
                if (selectedGender == R.id.rb_other)
                    gender = "Other";
                String dob = tvDOB.getText().toString();
                String year = spYear.getSelectedItem().toString();
                bundle.putString("name", name);
                bundle.putString("mobileNumber", mobileNumber);
                bundle.putString("gender", gender);
                bundle.putString("year", year);
                bundle.putString("dob", dob);
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void openDatePicker() {
        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMaxDate(new Date().getTime());
        dialog.show();
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            tvDOB.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
        }
    };
}
