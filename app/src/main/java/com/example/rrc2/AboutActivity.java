package com.example.rrc2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView tvVersionNumber = (TextView) findViewById(R.id.tvVersionNumber);
        tvVersionNumber.setText((CharSequence) BuildConfig.VERSION_NAME);
    }
}