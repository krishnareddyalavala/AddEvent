package com.example.krishna.addingevents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;

import java.util.Calendar;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void AddCalendarEvent(View view) {
        Calendar calendarEvent = Calendar.getInstance();
        calendarEvent.set(Calendar.MONTH, 4);
        calendarEvent.set(Calendar.DAY_OF_MONTH, 10);
        calendarEvent.set(Calendar.SECOND, 0);
        //the above values are gonna stay default

        calendarEvent.set(Calendar.HOUR_OF_DAY, 9);
        calendarEvent.set(Calendar.MINUTE, 0);

//        calendarEvent.se;


        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis()  );

        i.putExtra("allDay", false);

        i.putExtra("rrule", "FREQ=WEEKLY");
        i.putExtra("endTime",  calendarEvent.getTimeInMillis()+(60*60)*1000);
        i.putExtra(CalendarContract.Events.TITLE, "demo Event");

        startActivity(i);
    }
}