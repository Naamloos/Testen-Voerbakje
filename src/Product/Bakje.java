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
//        System.out.println(gramVoer);
        if(gramVoer < 100 && gramVoer >= 50)
        {
<<<<<<< HEAD
            Notification not = new Notification("Een vogel heeft gegeten en het voer is nu op.", LocalDate.now(), LocalTime.now());
            app.StuurNotificatie(not);
        }
        else if(gramVoer < 50)
        {
            printNotEnoughVoer();
        }
        else{
            Notification not = new Notification("Een vogel heeft gegeten.", LocalDate.now(), LocalTime.now());
            app.StuurNotificatie(not);
=======
            System.out.println("Het voer is bijna op");
        }
        else if(gramVoer < 50)
        {
            System.out.println("Er zit niet genoeg voer in het bakje");
>>>>>>> c437ddcb20d8367f6d90ed12ab7e9eaaace37fe3
        }
    }
    public void removeVoer(int amount){
        setVoer(this.gramVoer);
        if (this.gramVoer >= amount){
            this.gramVoer -= amount;
        }
    }

    public void addVoer(int gramVoer)
    {
        System.out.println(this.gramVoer);
        if((this.gramVoer + gramVoer) <= 400){
            this.gramVoer += gramVoer;
            System.out.println("Voer is bij gevuld");
        }
        else{
            System.out.println("Voer zit vol");
            Notification not = new Notification("Het bakje zit vol.", LocalDate.now(), LocalTime.now());
            app.StuurNotificatie(not);
        }

    }

<<<<<<< HEAD
    public void printNotEnoughVoer(){

        Notification not = new Notification("Er zit niet genoeg voer in het bakje", LocalDate.now(), LocalTime.now());
        app.StuurNotificatie(not);
        System.out.println("Bakje is niet open gegaan");
        //Omdat het een fisiek ding is wordt dit niet mee gegeven als notificatie
        // maar we printen het toch even om het verhaal rond te maken.

    }

=======
>>>>>>> c437ddcb20d8367f6d90ed12ab7e9eaaace37fe3
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
            while (stroom > 0 && running)
            {
<<<<<<< HEAD
                System.out.println(this.stroom);
=======
                System.out.println(stroom);
>>>>>>> c437ddcb20d8367f6d90ed12ab7e9eaaace37fe3
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
