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
        System.out.println("Commandos: eet, laad, vul, stroom");
        // Welkom welkom in dit programma
        app = new App();
        bakje = new Bakje(app);
        vogel = new Vogel(bakje);

        bakje.addStroom(); //Je moet natuurlijk het bakje eerst opladen.
        bakje.addVoer(100); // Je moet het bakje natuurlijk wel vol gooien met voer(In mililiter).

        Thread stroomThread = new Thread(bakje);
        stroomThread.start();

        try {
            while(true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String input = reader.readLine();

                switch(input){
                    case "eet": //Vogel eet voer.
                        if(bakje.getStroom() > 0)
                        {
                            voerNiveau = bakje.getVoer();
                            vogel.eetVoer();
                        }
                        else {
                            System.out.println("Bakje heeft geen stroom!");
                        }
                        break;

                    case "laad": //laat het bakje op
                        bakje.addStroom();
                        break;

                    case "vul": //Vul het bakje bij
                        bakje.addVoer(100);

                        break;

                    case "stroom": //Laat de batterij op
                        int stroom = bakje.getStroom();
                        if (stroom > 0)
                        {
                            System.out.println("Batterij percentage is nu: " +stroom+"%");
                        }
                        break;
                }
            }
        }catch (java.io.IOException ex){

        }
    }
}
