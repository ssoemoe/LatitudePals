package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ChoosingPartner extends AppCompatActivity {
    // hardcoded for demo purpose
    private String[] partners = {
           "Tim Chen  \uD83D\uDFE2", "Timothee Chalamet \u25EF", "John Smith \u25EF", "Billy Jean \u25EF"
    };
    private AutoCompleteTextView autoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosingpartner);

        // auto complete text view
        autoTextView = findViewById(R.id.partnerNameInput);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, partners);
        autoTextView.setThreshold(1); //will start working from first character
        autoTextView.setAdapter(adapter);
    }

}
