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


}
