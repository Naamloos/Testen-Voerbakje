package Product;

import Communicatie.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VogelTest
{
    private Vogel vogel;
    private Bakje bakje;

    @BeforeEach
    void setUp()
    {
        App app = new App();
        this.bakje = new Bakje(app);
        this.vogel = new Vogel(bakje);
    }

    @Test
    void eetVoer()
    {
        bakje.setVoer(500);
        vogel.eetVoer();
        int voer = bakje.getVoer();
        assertEquals(450, voer);
    }
}