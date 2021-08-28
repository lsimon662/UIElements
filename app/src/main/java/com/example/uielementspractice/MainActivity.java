package com.example.uielementspractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = "UIElementsPracticeLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener((v) -> {
            EditText myEditText = (EditText)  findViewById(R.id.editTextTextPersonName);
            Log.i(LOG_TAG, myEditText.getText().toString());
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(LOG_TAG, "In saved instance state");
        EditText editText = (EditText)  findViewById(R.id.editTextTextPersonName);

        CharSequence writtenData = editText.getText();
        outState.putCharSequence("mySavedData", writtenData);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(LOG_TAG, "In restored instance state");

        CharSequence storedData = savedInstanceState.getCharSequence("mySavedData");
        EditText myEditText = (EditText) findViewById(R.id.editTextTextPersonName);
        myEditText.setText(storedData);

    }
}