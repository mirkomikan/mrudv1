package info.mik.mrud;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create an alarm service
        AlarmManager alarmManager = (AlarmManager) getSystemService(
                Context.ALARM_SERVICE);

        // create a notification intent
        Intent notificationIntent = new Intent(this,
                AlarmReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(this,
                100,
                notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // we need a calendar for Time at which to fire-up notification
        //Calendar myCalendar = Calendar.getInstance();
        // set notification time in 10 sec after app starts
        //myCalendar.add(Calendar.SECOND, 10);

        // Let's create a Timer
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();
        myTimer.schedule(myTask, 10000, 10000);

/* OBSOLETE... you'd better use MyTimerTask...
        // Error "Call requires API level 19 (current min is 17)...
        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
        // ...so we have to differentiate between SDK vers
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            try {
                Objects.requireNonNull(alarmManager).set(AlarmManager.RTC_WAKEUP,
                        myCalendar.getTimeInMillis(),
                        broadcast);
            } catch (java.lang.NullPointerException e) {
                System.out.println("NullPointerException " + e.getMessage());
            }
        } else {
            try {
                assert alarmManager != null;
                (alarmManager).set(AlarmManager.RTC_WAKEUP,
                        myCalendar.getTimeInMillis(),
                        broadcast);
            } catch (java.lang.NullPointerException e) {
                System.out.println("NullPointerException " + e.getMessage());
            }
        }
*/
    }

    public class MyTimerTask extends TimerTask {
        public void run() {
            AlarmReceiver alarmReceiver = new AlarmReceiver();
            Intent notificationIntent = new Intent(getApplicationContext(),
                    AlarmReceiver.class);

            alarmReceiver.onReceive(getApplicationContext(), notificationIntent);

        }
    }
}
