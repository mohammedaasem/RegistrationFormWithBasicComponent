package com.aasem.basiccomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvName,tvMobileNumber,tvGender,tvDOB,tvYear;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bundle=getIntent().getExtras();

        tvName=findViewById(R.id.tv_name);
        tvMobileNumber=findViewById(R.id.tv_mobile_number);
        tvGender=findViewById(R.id.tv_gender);
        tvDOB=findViewById(R.id.tv_dob);
        tvYear=findViewById(R.id.tv_year);

        tvName.setText(bundle.getString("name"));
        tvMobileNumber.setText(bundle.getString("mobileNumber"));
        tvGender.setText(bundle.getString("gender"));
        tvDOB.setText(bundle.getString("dob"));
        tvYear.setText(bundle.getString("year"));
    }
}
