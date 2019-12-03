package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SharingLocationWithJen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharinglocationwithjen1);
    }

    public void AskJen(View view){
        Context context = getApplicationContext();
        CharSequence text = "Asked for Jen's location!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void SendJen(View view){
        Context context = getApplicationContext();
        CharSequence text = "Sent your location to Jen!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void BackJen(View view) {
        Intent intent= new Intent(this, SharingLocationGoScreen.class);
        startActivity(intent);
    }
}
