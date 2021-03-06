package com.simpleideas.gymmate;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Geprge on 11/27/2016.
 */

public class LetsMakeAnAdapter extends ArrayAdapter<ExerciseTemplate> {

    private ArrayList<ExerciseTemplate> exercises;

    public void setExercises(ArrayList<ExerciseTemplate> exercises) {
        this.exercises = exercises;
    }

    private Activity activity;
    private static LayoutInflater inflater = null;

    public LetsMakeAnAdapter(Context context, ArrayList<ExerciseTemplate> item) {

        super(context,R.layout.list_element, item);
        this.exercises = item;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View customViewToInflate = convertView;

        if(customViewToInflate == null){

            inflater = LayoutInflater.from(getContext());

            customViewToInflate = inflater.inflate(R.layout.list_element, null);
        }

        TextView textViewExample = (TextView) customViewToInflate.findViewById(R.id.exerciseNameViewWTF);
        TextView textViewWeights = (TextView) customViewToInflate.findViewById(R.id.exerciseNameViewWTFWeights);
        TextView textViewReps = (TextView) customViewToInflate.findViewById(R.id.exerciseNameViewWTFReps);
        String one = exercises.get(position).getExerciseName();
        String two = String.valueOf(exercises.get(position).getWeight());
        String three = String.valueOf(exercises.get(position).getRepetition());
        textViewExample.setText(one.toString());
        textViewWeights.setText(two);
        textViewReps.setText(three);


        return customViewToInflate;
    }
}
