import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Asema {

    public String nimi;
    ArrayList<String> Aikataulut;
    ArrayList<PääteAsema> yhteydet;


    public Asema(String nimi, ArrayList yhteydet){
        this.nimi = nimi;
        this.yhteydet = yhteydet;
    }

    public Asema(){
        this.nimi = "";
    }

    public String annaNimi(){
        return nimi;
    }

    public ArrayList<PääteAsema> annaYhteydet(){
        return yhteydet;
    }

    public ArrayList<String> annaAikataulut(){
        return Aikataulut;
    }

    public void setAikataulut(String nimi) {
        this.Aikataulut = parseAikataulut(nimi);
    }

    /**
     * Tekee arrayn tiedostosta joka sisältää aikataulut
     * @return
     */
    public ArrayList parseAikataulut(String nimi){

        ArrayList<String> list = new ArrayList<String>();
        try {
            Scanner s = new Scanner(new File("./src/" + nimi + ".txt"));
            while (s.hasNext()) {
                list.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }



}
