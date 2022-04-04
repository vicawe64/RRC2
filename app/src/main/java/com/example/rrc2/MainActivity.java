package com.example.rrc2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
//import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements rvCodesAdapter.ItemClickListener{
    EditText etCode;
    RecyclerView rvCodeList;
    ArrayList<String> strCodes;
    rvCodesAdapter adapter;
    Codes codes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCode = (EditText) findViewById(R.id.etCode);
        rvCodeList = (RecyclerView) findViewById(R.id.rvCodeList);
        strCodes = new ArrayList<>();
        codes = new Codes(this);

        rvCodeList.setLayoutManager(new LinearLayoutManager(this));
        rvCodeList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new rvCodesAdapter(this, strCodes);
        adapter.setClickListener((rvCodesAdapter.ItemClickListener) this);
        rvCodeList.setAdapter(adapter);

        strCodes = codes.searchCodes("");
        adapter.setmData(strCodes);
        adapter.notifyDataSetChanged();

        etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                strCodes = codes.searchCodes(s.toString());
                adapter.setmData(strCodes);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        // Cleaning the search field and (automatically) re-populating the list
        etCode.setText((CharSequence) "");
    }

    public void cleanETCode(View view) {
        // Cleaning the search field and (automatically) re-populating the list
        etCode.setText((CharSequence) "");
    }

}