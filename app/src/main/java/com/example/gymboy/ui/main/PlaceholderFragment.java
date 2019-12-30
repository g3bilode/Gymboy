package com.example.gymboy.ui.main;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.gymboy.Classes.Exercise;
import com.example.gymboy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    private TableLayout tableLayout;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        tableLayout = root.findViewById(R.id.section_table);
        createTable();

        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private void createTable() {
        Context context = this.getContext();
        // Create Header
        createTableHeader(context);
        // Populate content
        loadExerciseHistory("bicep", "Phase 1", context);
        loadExerciseHistory("bicep", "Phase 2", context);
        loadExerciseHistory("bicep", "Phase 3", context);

    }

    private void createTableHeader(Context context) {
        TableRow tableRow = new TableRow(context);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT));

        // First box empty
        tableRow.addView(createTableBox("", context));

        // Set Weeks
        for(int week_idx=1; week_idx <= 4; week_idx++) {
            String weekText = context.getResources().getString(R.string.week) + " " + week_idx;
            TextView textView = createTableBox(weekText, context);
            tableRow.addView(textView);
        }

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT));
    }

    private TextView createTableBox(String text, Context context) {
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textView.setPadding(5, 5, 5, 5);
        textView.setBackgroundResource(R.drawable.table_border);
        return textView;
    }

    private void loadExerciseHistory(String name, String phase, Context context) {
        List<Exercise> exerciseHistory = new ArrayList<Exercise>();
        exerciseHistory.add(new Exercise(name, 60, 4, 12));
        exerciseHistory.add(new Exercise(name, 75, 4, 9));
        exerciseHistory.add(new Exercise(name, 90, 4, 6));
        exerciseHistory.add(new Exercise(name, 105, 4, 3));

        TableRow tableRow = new TableRow(context);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT));

        tableRow.addView(createTableBox(phase, context));

        for (Exercise item : exerciseHistory) {
            String entryText = item.getWeight() + " / " + item.getReps();
            TextView textView = createTableBox(entryText, context);
            tableRow.addView(textView);
        }

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT));
    }
}