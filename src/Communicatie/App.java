package Communicatie;

// heule mooie app
public class App
{
    public App()
    {

    }

    public void StuurNotificatie(Notification notification)
    {
        // TODO move down to notification
        System.out.println("(APP) " + notification.getDate() + " @ " + notification.getTime() + " | " + notification.getMessage());
    }
}
