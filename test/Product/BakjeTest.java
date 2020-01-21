package Product;

import Communicatie.App;

import static org.junit.jupiter.api.Assertions.*;

class BakjeTest
{
    Vogel vogel;
    Bakje bakje;
    App app;

    @org.junit.jupiter.api.BeforeEach
    void setUp()
    {
        this.app = new App();
        this.bakje = new Bakje(this.app);
        this.vogel = new Vogel(this.bakje);

        bakje.setVoer(100);
    }

    @org.junit.jupiter.api.Test
    void getVoer()
    {
        assertEquals(100, bakje.getVoer());
    }

    @org.junit.jupiter.api.Test
    void setVoer()
    {
        bakje.setVoer(400);
        assertEquals(400, bakje.getVoer());
    }

    @org.junit.jupiter.api.Test
    void addVoer()
    {
        bakje.setVoer(500);
        bakje.addVoer(100);
        assertEquals(600, bakje.getVoer());
    }

    @org.junit.jupiter.api.Test
    void getStroom()
    {
        bakje.setStroom(100);
        Thread stroomThread = new Thread(bakje);
        stroomThread.start();
        try
        {
            System.out.println("Started bakje thread and waiting for 10 sec to get to 95% power...");
            Thread.sleep(10000);
        }catch (Exception ex){}
        // 10 sec later
        assertEquals(95, bakje.getStroom());
        bakje.stopBakje();
    }

    @org.junit.jupiter.api.Test
    void setStroom()
    {
        bakje.setStroom(60);
        assertEquals(60, bakje.getStroom());
    }

    @org.junit.jupiter.api.Test
    void addStroom()
    {
        bakje.setStroom(60);
        bakje.addStroom();
        assertEquals(100, bakje.getStroom());
    }

    @org.junit.jupiter.api.Test
    void run()
    {
        // same test
        this.getStroom();
    }

    @org.junit.jupiter.api.Test
    void stopBakje()
    {
        bakje.setStroom(100);
        Thread stroomThread = new Thread(bakje);
        stroomThread.start();
        try
        {
            System.out.println("Started bakje thread and waiting for 6 sec to get to 97% power...");
            Thread.sleep(5500);
        }catch (Exception ex){}
        // 10 sec later
        assertEquals(97, bakje.getStroom());
        bakje.stopBakje();
        // wait and see whether it actually stopped
        try
        {
            System.out.println("Started bakje thread and waiting for 6 sec to get to 97% power...");
            Thread.sleep(5500);
        }catch (Exception ex){}
        // 10 sec later
        assertEquals(97, bakje.getStroom());
    }
}