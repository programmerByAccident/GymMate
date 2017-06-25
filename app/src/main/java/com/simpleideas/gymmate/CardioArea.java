package com.simpleideas.gymmate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Set;

import adapters.CardioAdapter;

/**
 * Created by George on 04/05/2017.
 */

public class CardioArea extends AppCompatActivity{

    private RecyclerView cardioElements;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardio_elements);

        cardioElements = (RecyclerView) findViewById(R.id.cardio_elements_list);

        Set<String> exercises = getExercises(Constants.CARDIO);
        ArrayList<String> exercisesForAdapter = new ArrayList<>();
        exercisesForAdapter.addAll(exercises);

        CardioAdapter adapter = new CardioAdapter(this,exercisesForAdapter);

        cardioElements.setLayoutManager(new LinearLayoutManager(this));
        cardioElements.addItemDecoration(new DividerItemDecoration(CardioArea.this,RecyclerView.VERTICAL));
        cardioElements.setAdapter(adapter);

    }


    private Set<String> getExercises(String muscle_name){

        SharedPreferences sharedPreferences = getSharedPreferences(muscle_name, MODE_PRIVATE);

        return sharedPreferences.getStringSet(muscle_name, null);

    }















































































//    private void perform_changes_to_decoviewsize(DecoView time_elapsed) {
//
//        time_elapsed.requestLayout();
//        time_elapsed
//                .addSeries(new SeriesItem.Builder(Color.argb(255, 64, 196, 0))
//                        .setRange(0,100,0)
//                        .setInitialVisibility(true)
//                        .setLineWidth(2f)
//                        .build());
//        SeriesItem seriesItem1 = new SeriesItem.Builder(Color.argb(255, 64, 196, 0))
//                .setRange(0, 100, 25)
//                .setLineWidth(35f)
//                .build();
//
//        int series1Index = time_elapsed.addSeries(seriesItem1);
//
//        time_elapsed.addEvent(new DecoEvent.Builder(75)
//                .setDuration(2000)
//                .setDelay(0)
//                .setIndex(series1Index)
//                .build());
//        time_elapsed.addEvent(new DecoEvent.Builder(0)
//                .setDuration(3600)
//                .setDelay(4000)
//                .setIndex(series1Index)
//                .build());
//
//
//
//    }
//
//    private void generate_behaviour_for_chronometer_DecoView(final TextView textView, EditText time_to_exercise){
//
//        int milliseconds = Integer.valueOf(time_to_exercise.getText().toString()) * 60000;
//
//        new CountDownTimer(milliseconds, 1000) {
//            @Override
//            public void onTick(long l) {
//                textView.setText("counting " + l / 1000000);
//            }
//
//            @Override
//            public void onFinish() {
//                textView.setText("DONE");
//            }
//        }.start();
//
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        switch(view.getId()){
//
//            case R.id.submit_chrono:
//
//
//
//        }
//
//    }
}





































