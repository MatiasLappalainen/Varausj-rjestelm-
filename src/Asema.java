import java.util.ArrayList;

public class Asema {

    public String nimi;
    ArrayList<String> yhteydet;


    public Asema(String nimi, ArrayList yhteydet){
        this.nimi = nimi;
        this.yhteydet = yhteydet;
    }


    public String annaNimi(){
        return nimi;
    }

    public ArrayList<String> annaYhteydet(){
        return yhteydet;
    }
    public void listAll() {
        for(String k : yhteydet){
            System.out.println(k);
        }
    }

}
