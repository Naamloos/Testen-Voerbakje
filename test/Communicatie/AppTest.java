package Communicatie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AppTest
{
    private App app;

    @BeforeEach
    void setUp()
    {
        this.app = new App();
    }

    @Test
    void stuurNotificatie()
    {
        app.StuurNotificatie(new Notification("Test notification", LocalDate.now(), LocalTime.now()));
        // Je kan een printline niet echt testen dus let op console output.
    }
}