import Communicatie.App;
import Communicatie.Notification;
import Product.Bakje;
import Product.Vogel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        System.out.println("Commandos: eet, laad, vul, exit");
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

        boolean running = true;
        try {
            while(running) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String input = reader.readLine();

                switch(input){
                    case "eet":
                        if(bakje.getStroom() > 0)
                        {
                            voerNiveau = bakje.getVoer();
                            if (voerNiveau > 49)
                            {
                                System.out.println("vogel at");
                            }
                            vogel.eetVoer();
                        }
                        else {
                            System.out.println("Bakje heeft geen stroom!");
                        }
                        break;

                    case "laad":
                        bakje.addStroom();
                        stroomThread = new Thread(bakje);
                        stroomThread.start();
                        break;

                    case "vul":
                        bakje.addVoer(100);

                    case "exit":
                        running = false;
                        break;
                }
            }
        }catch (java.io.IOException ex){

        }

        bakje.stopBakje();
    }
}
