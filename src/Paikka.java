import java.util.ArrayList;

public class Paikka{

    public String nimi;
    ArrayList<String> ajat = new ArrayList<String>();
    ArrayList<String> yhteydet = new ArrayList<>();


    public Paikka(String nimi, ArrayList ajat, ArrayList yhteydet){
        this.nimi = nimi;
        this.ajat = ajat;
        this.yhteydet = yhteydet;
    }


    public String annaNimi(){
        return nimi;
    }

    public ArrayList<String> annaAjat(){
        return ajat;
    }


    public ArrayList<String> annaYhteydet(){
        return yhteydet;
    }

}
