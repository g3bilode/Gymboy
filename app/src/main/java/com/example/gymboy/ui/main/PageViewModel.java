package com.example.gymboy.ui.main;

import android.content.Context;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.gymboy.Data.GymRepository;

import java.util.ArrayList;
import java.util.List;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    private MutableLiveData<List<String>> exercises = new MutableLiveData<>();

    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });
    public void setIndex(int index) {
        mIndex.setValue(index);
        buildExerciseList(index);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<List<String>> getExercises() {
        return exercises;
    }

    private void buildExerciseList(int index) {
        List<String> exercise_names = new ArrayList<>(GymRepository.getExercisesPerMuscle(index-1));
        exercises.setValue(exercise_names);
    }

    //private static int getStringIdentifier(Context context, String name) {
    //    return context.getResources().getIdentifier(name, "string", context.getPackageName());
    //}
}