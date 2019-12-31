package com.example.gymboy.ui.main;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

public class ExerciseSpinner implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.v("taggy", adapterView.getItemAtPosition(i).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
