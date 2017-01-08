package com.simpleideas.gymmate;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by George Ciopei on 1/3/2017.
 */

public class CalendarViewCustomized extends AppCompatActivity {


    MaterialCalendarView materialCalendarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_calendar);
        setupActionBar();
        materialCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);


        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.WEDNESDAY)
                .setMinimumDate(CalendarDay.from(2000, 4, 3))
                .setMaximumDate(CalendarDay.from(2100, 5, 12))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();


        customizeMaterialCalendarView(materialCalendarView);

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

                Intent intent = new Intent(CalendarViewCustomized.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void customizeMaterialCalendarView(MaterialCalendarView calendarView){

        ArrayList<DayViewDecorator> collectionOfDecorators = new ArrayList<>();

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        ArrayList<String> dates = databaseHelper.getDaysWithWorkout();
        DayWithWorkout dayWithWorkout = new DayWithWorkout(this,dates, calendarView.getWidth(), calendarView.getHeight());
        CurrentDateDecorator currentDateDecorator = new CurrentDateDecorator(this);
        AllDaysSelector allDaysSelector = new AllDaysSelector(this);

        collectionOfDecorators.add(dayWithWorkout);
        //collectionOfDecorators.add(currentDateDecorator);
        //collectionOfDecorators.add(allDaysSelector);

        //calendarView.addDecorator(dayWithWorkout);

        calendarView.addDecorators(collectionOfDecorators);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calendar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupActionBar(){
        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Calendar");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.adjust_calendar:

                Date date = new Date();

                materialCalendarView.setCurrentDate(date);


                break;


        }

        return super.onOptionsItemSelected(item);
    }
}
