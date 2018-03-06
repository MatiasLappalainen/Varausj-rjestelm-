import java.util.ArrayList;

public class Matka {

    public int lahto;
    public int maaranpaa;

    public String aika;

    public int maara;

    ArrayList<Integer> istumapaikka;
    //Matka tallennetaan loppujenlopuksi tiedostoon varaukset.txt?
    public Matka(int lahto, int maaranpaa, String aika, int maara, ArrayList istumapaikka){
        this.lahto = lahto;
        this.maaranpaa = maaranpaa;
        this.aika = aika;
        this.maara = maara;
        this.istumapaikka = istumapaikka;
    }

}
