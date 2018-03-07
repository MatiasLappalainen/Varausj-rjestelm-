import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matka {

    public Asema lahto;
    public Asema maaranpaa;

    public String aika;

    public int maara;

    List<Integer> istumapaikka;
    //Matka tallennetaan loppujenlopuksi tiedostoon varaukset.txt?
    public Matka(Asema lahto, Asema maaranpaa, String aika, int maara, ArrayList istumapaikka){
        this.lahto = lahto;
        this.maaranpaa = maaranpaa;
        this.aika = aika;
        this.maara = maara;
        this.istumapaikka = istumapaikka;
    }

    public Matka(){
        this.aika = "";
        this.maara = 0;
        this.istumapaikka = Arrays.asList(1, 2);
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

    public void asetaIstumapaikka(List istumapaikka) {
        this.istumapaikka = istumapaikka;
    }

    public String annaAika(){
        return aika;
    }


}
