package ohtu.main;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {
        final double tilavuus = 100.0;
        final double oluenMaara = 20.2;
        final double tonni = 1000.0;
        Varasto mehua = new Varasto(tilavuus);
        Varasto olutta = new Varasto(tilavuus, oluenMaara);

        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Olutgetterit:");
        System.out.println("getSaldo()     = " + olutta.getSaldo());
        System.out.println("getTilavuus    = " + olutta.getTilavuus());
        System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());

        final double lisataan = 50.7;
        final double otetaan = 3.14;
        System.out.println("Mehusetterit:");
        System.out.println("Lisätään 50.7");
        mehua.lisaaVarastoon(lisataan);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Otetaan 3.14");
        mehua.otaVarastosta(otetaan);
        System.out.println("Mehuvarasto: " + mehua);

        final double huononTilavuus = -100.0;
        System.out.println("Virhetilanteita:");
        System.out.println("new Varasto(-100.0);");
        Varasto huono = new Varasto(huononTilavuus);
        System.out.println(huono);

        System.out.println("new Varasto(100.0, -50.7)");
        huono = new Varasto(tilavuus, -lisataan);
        System.out.println(huono);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.lisaaVarastoon(1000.0)");
        olutta.lisaaVarastoon(tonni);
        System.out.println("Olutvarasto: " + olutta);

        final double kuuskuuskuus = -666.0;
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.lisaaVarastoon(-666.0)");
        mehua.lisaaVarastoon(kuuskuuskuus);
        System.out.println("Mehuvarasto: " + mehua);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.otaVarastosta(1000.0)");
        double saatiin = olutta.otaVarastosta(tonni);
        System.out.println("saatiin " + saatiin);
        System.out.println("Olutvarasto: " + olutta);

        final double vika = -32.9;
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.otaVarastosta(-32.9)");
        saatiin = mehua.otaVarastosta(vika);
        System.out.println("saatiin " + saatiin);
        System.out.println("Mehuvarasto: " + mehua);
    }
}
