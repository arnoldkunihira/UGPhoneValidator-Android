package com.example.arnold.ugphonevalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ugphonevalidator.PhoneValidator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String phone_number = "256719345678";

        PhoneValidator validator = new PhoneValidator(phone_number);
        if (validator.validate(phone_number)) {
            Log.i("PV", "YOUR OPERATOR IS " + validator.getOperator());
            Log.i("PV", "YOUR CLEAN PHONE NUMBER IS " + validator.getPhoneNumber());
        } else {
            Log.i("PV", "INVALID PHONE NUMBER");
        }
    }
}
