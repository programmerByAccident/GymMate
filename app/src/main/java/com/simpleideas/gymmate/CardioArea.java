package com.simpleideas.gymmate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;

/**
 * Created by George on 04/05/2017.
 */

public class CardioArea extends AppCompatActivity implements View.OnClickListener{
    EditText requiredMinutes;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardio_area);



        Button submit_chrono_action = (Button) findViewById(R.id.submit_chrono);
        requiredMinutes = (EditText) findViewById(R.id.required_time);
        submit_chrono_action.setOnClickListener(this);
        //ImageView chrono = (ImageView) findViewById(R.id.clock_sketch);

        //
    }


    private void perform_changes_to_decoviewsize(DecoView time_elapsed) {

        time_elapsed.requestLayout();
        time_elapsed
                .addSeries(new SeriesItem.Builder(Color.argb(255, 64, 196, 0))
                .setRange(0,100,0)
                .setInitialVisibility(true)
                .setLineWidth(2f)
                .build());
        SeriesItem seriesItem1 = new SeriesItem.Builder(Color.argb(255, 64, 196, 0))
                .setRange(0, 100, 25)
                .setLineWidth(35f)
                .build();

        int series1Index = time_elapsed.addSeries(seriesItem1);

        time_elapsed.addEvent(new DecoEvent.Builder(75)
                .setDuration(2000)
                .setDelay(0)
                .setIndex(series1Index)
                .build());
        time_elapsed.addEvent(new DecoEvent.Builder(0)
                .setDuration(3600)
                .setDelay(4000)
                .setIndex(series1Index)
                .build());



    }

    private void generate_behaviour_for_chronometer_DecoView(final TextView textView, EditText time_to_exercise){

        int milliseconds = Integer.valueOf(time_to_exercise.getText().toString()) * 60000;

        new CountDownTimer(milliseconds, 1000) {
            @Override
            public void onTick(long l) {
                textView.setText("counting " + l / 1000000);
            }

            @Override
            public void onFinish() {
                textView.setText("DONE");
            }
        }.start();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.submit_chrono:

                

        }

    }
}





































