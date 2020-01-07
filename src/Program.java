import Communicatie.App;
import Product.VogelVoerBakje;

public class Program
{
    static VogelVoerBakje vogelVoerBakje;
    static App app;

    public static void main(String[] args)
    {
        // Welkom welkom in dit programma
        app = new App();
        vogelVoerBakje = new VogelVoerBakje(app);
    }
}
