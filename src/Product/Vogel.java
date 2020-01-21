package Product;

import Communicatie.App;

public class Vogel
{
    private Bakje bakje;
    private int voerNiveau;

    public Vogel(Bakje bakje)
    {
        this.bakje = bakje;
    }

    public void eetVoer()
    {
//        voerNiveau = bakje.getVoer();
//        if (voerNiveau >= 50)
//        {
//            voerNiveau -= 50;
//            bakje.setVoer(voerNiveau);
//        }
//        else{
//            bakje.printNotEnoughVoer();
//        }
        bakje.removeVoer(50);
    }
}
