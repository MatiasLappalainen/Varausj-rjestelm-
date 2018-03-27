import java.util.*;
import java.io.IOException;
import java.io.File;

public class Main {


    public final ArrayList<Asema> asemat;
    public final ArrayList<String> Kaupungit = new ArrayList<>(Arrays.asList("Helsinki", "Hämeenlinna", "Joensuu", "Jyväskylä", "Kajaani", "Kouvola", "Turku", "Rovaniemi"));

    //Constructor
    public Main() {

        asemat = new ArrayList<>();

        for (String k : Kaupungit) {
            asemat.add(new Asema(k));
        }
        // Kutsu init
        init();
    }

    // ns main metodi
    public void init() {
        Matka matka = new Matka();
        Askel askel = new Askel();
        Varaus varaus = new Varaus();
        Asema lahto = new Asema();
        Asema maaranpaa = new Asema();
        Juna juna = new Juna();
        new File(System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Liput").mkdirs();
        boolean paalla = true;
        // Ohjelman tila eli katsoo askeleen ja menee sitä mukaan ohjelmassa eteenpäin methodilla lisaaAskel
        while (paalla) {

            switch (askel.annaAskel()) {
                case 0:
                    System.out.print("\n\n\n\n\n\n\n");
                    System.out.println("Valitse Lähtöpaikka");
                    lahto = varaus.asetaLahto(asemat);
                    matka.asetaLahto(lahto);
                case 1:
                    System.out.print("\n\n\n\n\n\n\n");
                    System.out.println("Valitse Määränpää");
                    maaranpaa = varaus.asetaMaaranpaa(lahto);
                    matka.asetaMaaranpaa(maaranpaa);
                case 2:
                    System.out.print("\n\n\n\n\n\n\n");
                    System.out.println("Valitse lähtöaika");
                    matka.asetaAika(varaus.asetaAika(lahto, maaranpaa));
                case 3:
                    System.out.print("\n\n\n\n\n\n\n");
                    boolean istumapaikka = false;
                    while (!istumapaikka) {
                        System.out.println("Valitse paikka junasta, asteriskilla merkatut paikat ovat ikkunapaikkoja");
                        matka.asetaIstumapaikka(varaus.getIstumapaikka(juna));
                        String path = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Liput\\";
                        try {
                            if (matka.paikanVapaus(lahto.annaNimi(), maaranpaa.annaNimi(), matka.annaAika(), matka.annaIstumapaikka(), path) == true) {
                                istumapaikka = true;
                            }
                            else{
                                System.out.print("\n\n\n\n\n\n\n");
                                System.out.println("Valitsemasi paikka on varattu. Valitse toinen paikka.");
                            }
                        } catch (IOException e) {
                            System.out.println("Virhe paikanvalinnassa");
                        }
                    }
                case 4:
                    System.out.print("\n\n\n\n\n\n\n");
                    System.out.print("Lähtöpaikka: " + lahto.annaNimi() + ", Määränpää: " + maaranpaa.annaNimi() + " , Lähtöaika: " + matka.annaAika() + ", Istumapaikka " + matka.annaIstumapaikka());
                case 5:
                    String[] info = new String[4];
                    info[0] = "Lähtö: " + lahto.annaNimi();
                    info[1] = "Määränpää: " + maaranpaa.annaNimi();
                    info[2] = "Aika: " + matka.annaAika();
                    info[3] = "Istumapaikka " + Integer.toString(matka.annaIstumapaikka());
                    String path = System.getProperty("user.home") + "\\AppData\\Local\\Temp\\Liput\\";
                    path += matka.generoiTiedostonimi(path);
                    try {
                        matka.kirjoitaTiedostoon(info, path);
                    } catch (IOException e) {
                        System.out.println("Virhe kirjoitettaessa tiedostoon");
                    }
                case 6:
                    System.out.print("\n");
                    boolean uusi = varaus.jatketaankoVarausta();
                    if (uusi) {
                        paalla = true;
                    } else {
                        paalla = false;
                    }
                }
            }
        }

        public static void main (String[]args){
            new Main();
        }
    }
