package Communicatie;

import java.time.LocalDate;
import java.time.LocalTime;

public class Notification
{
    private String message;
    private LocalDate date;
    private LocalTime time;

    public Notification(String message, LocalDate date, LocalTime time)
    {
        this.message = message;
        this.date = date;
        this.time = time;
    }

    public String getMessage()
    {
        return message;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public LocalTime getTime()
    {
        return time;
    }
}
