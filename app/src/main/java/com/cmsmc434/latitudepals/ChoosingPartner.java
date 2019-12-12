package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ChoosingPartner extends AppCompatActivity {
    private static int partnerIndex = 1;
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

    public void addPartner(View view) {
        EditText partnerEditText = (EditText) findViewById(R.id.partnerNameInput);
        String partner = partnerEditText.getText().toString();
        partnerEditText.setText("");
        partnerEditText.clearFocus();
        TextView partnerList = (TextView)findViewById(R.id.TimChenTextView);
        partnerList.setText( partnerIndex + ". " + partner);
        partnerList.setTextColor(Color.BLACK);
        TextView title = (TextView) findViewById(R.id.buddiesTitle);
        title.setTextColor(Color.BLACK);

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(partnerEditText.getWindowToken(),
                InputMethodManager.RESULT_UNCHANGED_SHOWN);

        // custom toast
        String[] splitPartnerName = partner.split(" ");
        String justName = splitPartnerName[0] + " " + splitPartnerName[1];
        Toast toast = Toast.makeText(this, justName + " successfully invited!", Toast.LENGTH_LONG);
        View toastView = toast.getView();
        toastView.setBackgroundColor(Color.GREEN);
        toast.show();
    }

    public void goToHomeScreen(View view) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToWorkoutScreen(View view) {
        Intent intent= new Intent(this, WorkoutPlayingScreenInitial.class);
        startActivity(intent);
    }

}
