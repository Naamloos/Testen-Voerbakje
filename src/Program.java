import Communicatie.App;
import Communicatie.Notification;
import Product.Bakje;
import Product.Vogel;

import java.time.LocalDate;
import java.time.LocalTime;

public class Program
{
    static Vogel vogel;
    static Bakje bakje;
    static App app;
    static int voerNiveau;

    public static void main(String[] args)
    {
        // Welkom welkom in dit programma
        Notification not = new Notification("test", LocalDate.now(), LocalTime.now());
        app = new App();
        app.StuurNotificatie(not);
        bakje = new Bakje(app);
        vogel = new Vogel(bakje);

        bakje.addStroom(); //Je moet natuurlijk het bakje eerst opladen.
        bakje.setVoer(200); // Je moet het bakje natuurlijk wel vol gooien met voer(In mililiter).

        Thread stroomThread = new Thread(bakje);
        stroomThread.start();

        try {
            while(true) {
                System.in.read();
                voerNiveau = bakje.getVoer();
                if(voerNiveau > 49)
                {
                    System.out.println("vogel at");
                }
                vogel.eetVoer();
            }
        }catch (java.io.IOException ex){

        }
    }
}
