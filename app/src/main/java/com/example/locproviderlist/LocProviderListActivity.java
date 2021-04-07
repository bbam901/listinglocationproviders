package com.example.locproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;
    LocationManager locMgr;
    List<String> locProviders;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        locMgr = (LocationManager) getSystemService(LOCATION_SERVICE);
        locProviders = locMgr.getAllProviders();

        String s = "";
        for(String locproviders : locProviders) {
            s += "Loc. Provider: " + locProviders + "\n"
                    + "Status: " + locMgr.isProviderEnabled(locproviders);
        }
                mTextView.setText(s);
        }

    }