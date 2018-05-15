package info.mik.mrud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class NotificationActivity extends AppCompatActivity {

    // This is a class to invoke an action and show a view when previously created
    // Notification gets tapped by user in Notification Bar
    // It gets invoked even when main app gets closed, if Notification is visible
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // this one will just show notification_activity view with info
        // what it is, but it can be used for some more complex activity
        setContentView(R.layout.notification_activity);
    }
}
