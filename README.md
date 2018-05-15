# mrudv1
MRU-D-v1-AlarmManagerReceiverLocalNotification

MRU-Dv1 GLOBAL TIMER (Specs part 10)
------------------------------------
AlarmReceiver extends BroadcastReceiver  
NotificationManager  
TaskStackBuilder  
NotificationActivity 
alarmSound   

DONE:
+ Global Timer to create a local notification that will pop up on every 5 minutes (shortened to 10 seconds for easier testing).
+ Used AlarmManager and TimerTask to schedule AlarmReceiver which will fire-up Notification with alarmSound and PendingIntent
+ Notification will pop-up at the Notification Bar every 10 seconds, and will be updating an existing notification in order to prevent an overloading.
+ Tapping on Notification will open another info view, even if main app gets closed.
