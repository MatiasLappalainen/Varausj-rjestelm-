import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class Matka {

    private Asema lahto;
    private Asema maaranpaa;

    private String aika;

    private int maara;

    private int istumapaikka;

    public Matka(){
        this.aika = "";
        this.maara = 0;
        this.istumapaikka = 1;
    }

    public void asetaLahto(Asema lahto){
        this.lahto = lahto;
    }

    public void asetaMaaranpaa(Asema maaranpaa){
        this.maaranpaa = maaranpaa;
    }

    public void asetaAika(String aika) {
        this.aika = aika;
    }

    public void asetaMaara(int maara) {
        this.maara = maara;
    }

    public void asetaIstumapaikka(int istumapaikka) {
        this.istumapaikka = istumapaikka;
    }

    public int annaIstumapaikka(){
        return this.istumapaikka;
    }

    public String annaAika(){
        return aika;
    }

    public void kirjoitaTiedostoon(String[] tiedot, String polku) throws IOException {
        FileWriter kirjoittaja = new FileWriter(new File(polku));
        for(String t : tiedot){
            kirjoittaja.write(t + "\r\n");
        }
        kirjoittaja.flush();
        kirjoittaja.close();
    }

    public boolean paikanVapaus(String lahto, String maaranpaa, String aika, int paikka, String polku) throws IOException{
        File kansio = new File(polku);
        File[] kansionSisalto = kansio.listFiles();
        if(kansionSisalto ==  null){
            return true;
        }
        String line;
        for(int i = 0; i < kansionSisalto.length; i++){
            try (BufferedReader br = new BufferedReader(new FileReader(polku + kansionSisalto[i].getName()))) {
                if(br.readLine().equals("Lähtö: " + lahto)){
                    if(br.readLine().equals("Määränpää: " + maaranpaa)){
                        if(br.readLine().equals("Aika: " + aika)){
                            if(br.readLine().equals("Istumapaikka " + Integer.toString(paikka))){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public String generoiTiedostonimi(String polku) {
        Random rnd = new Random();
        String tiedostonimi = "lippu" + rnd.nextInt(10000) + ".txt";
        File kansio = new File(polku);
        File[] kansionSisalto = kansio.listFiles();
        if(kansionSisalto ==  null){
            return tiedostonimi;
        }
        for(int i = 0; i < kansionSisalto.length; i++){
            if(kansionSisalto[i].getName().equals(tiedostonimi)){
                tiedostonimi = "lippu" + rnd.nextInt(10000) + ".txt";
            }
        }
        return tiedostonimi;
    }
}
