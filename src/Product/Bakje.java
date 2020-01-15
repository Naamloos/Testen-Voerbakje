package Product;
import Communicatie.App;
import Communicatie.Notification;
import java.time.LocalDate;
import java.time.LocalTime;

public class Bakje implements Runnable
{
    private int gramVoer;
    private int stroom;
    private App app;

    public Bakje(App app)
    {
        this.gramVoer = 0; // je begint zonder voer natuurlijk
        this.stroom = 0; // je bakje heeft natuurlijk geen stroom in het begin
        this.app = app;
    }

    public int getVoer()
    {
        return this.gramVoer;
    }

    public void setVoer(int gramVoer)
    {
        if(gramVoer < 100 && gramVoer >= 50)
        {
            System.out.println("Het voer is bijna op");
        }
        else if(gramVoer < 50)
        {
            System.out.println("Er zit niet genoeg voer in het bakje");
            System.out.println("Bakje is niet open gegaan");
        }
        this.gramVoer = gramVoer;
    }

    public void addVoer(int gramVoer)
    {
        this.gramVoer += gramVoer;
    }

    public int getStroom()
    {
        return this.stroom;
    }

    public void setStroom(int stroom)
    {
        this.stroom = stroom;
    }

    public void addStroom()
    {
        this.stroom = 100;
    }

    private boolean running = false;
    public synchronized void run() {

        if(!running)
        {
            running = true;
            while (stroom > 0)
            {
                System.out.println(stroom);
                stroom -= 1;
                if (stroom == 20)
                {
                    Notification not = new Notification("Stroom is bijna op", LocalDate.now(), LocalTime.now());
                    app.StuurNotificatie(not);
                } else if (stroom == 0)
                {
                    app.StuurNotificatie(new Notification("Stroom is op", LocalDate.now(), LocalTime.now()));
                }

                try
                {
                    this.wait(2000);
                }
                catch (InterruptedException e)
                {

                    e.printStackTrace();
                }
            }
            running = false;
        }
    }

    public void stopBakje()
    {
        this.running = false;
    }
}
