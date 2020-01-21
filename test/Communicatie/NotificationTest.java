package Communicatie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest
{
    private Notification notificiation;
    private LocalDate date;
    private LocalTime time;

    @BeforeEach
    void setUp()
    {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.notificiation = new Notification("test message", date, time);
    }

    @Test
    void getMessage()
    {
        assertEquals("test message", this.notificiation.getMessage());
    }

    @Test
    void getDate()
    {
        assertEquals(date, notificiation.getDate());
    }

    @Test
    void getTime()
    {
        assertEquals(time, notificiation.getTime());
    }
}