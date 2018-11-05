package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    // Itse lisätyt (tehtävä 8)

  // konstruktorit

  @Test
  public void tilavuusOltavaPositiivinen() {
    Varasto laitonVarasto = new Varasto(-1);

    assertEquals(0, laitonVarasto.getTilavuus(), vertailuTarkkuus);
  }

  @Test
  public void alkuSaldoTilavuusToimii() {
    Varasto laillinenVarasto = new Varasto(10, 5);

    assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
  }

  @Test
  public void alkuSaldoSaldoToimii() {
    Varasto laillinenVarasto = new Varasto(10, 5);

    assertEquals(5, laillinenVarasto.getSaldo(), vertailuTarkkuus);
  }

  @Test
  public void alkuSaldoOltavaPositiivinen() {
    Varasto laillinenVarasto = new Varasto(10, -55);

    assertEquals(0, laillinenVarasto.getSaldo(), vertailuTarkkuus);
  }

  @Test
  public void alkuSaldoOltavaPienempiKuinTilavuus() {
    Varasto laillinenVarasto = new Varasto(5, 10);

    assertEquals(5, laillinenVarasto.getSaldo(), vertailuTarkkuus);
  }

  @Test
  public void alkuSaldoTilavuusOltavaPositiivinen() {
    Varasto laillinenVarasto = new Varasto(-5, 5);

    assertEquals(0, laillinenVarasto.getTilavuus(), vertailuTarkkuus);
  }

  // lisaaVarastoon

  @Test
  public void eiVoiLisataNegatiivista() {
    varasto.lisaaVarastoon(-1);

    assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
  }

  @Test
  public void eiVoiMennäTilavuudenYli() {
    varasto.lisaaVarastoon(varasto.getTilavuus() + 1);

    assertEquals(varasto.getTilavuus(), varasto.getSaldo(), vertailuTarkkuus);
  }

  // otaVarastosta

  @Test
  public void eiVoiOttaaNegatiivista() {
    assertEquals(0, varasto.otaVarastosta(-10), vertailuTarkkuus);
  }

  @Test
  public void eiVoiOttaaYliSaldon() {
    varasto.lisaaVarastoon(3);
    assertEquals(3, varasto.otaVarastosta(4), vertailuTarkkuus);
  }

  // toString

  @Test
  public void toStringToimii() {
    varasto.lisaaVarastoon(3);
    double saldo = varasto.getSaldo();
    double vielaTilaa = varasto.paljonkoMahtuu();
    assertEquals("saldo = " + saldo + ", vielä tilaa " + vielaTilaa, varasto.toString());
  }
}
