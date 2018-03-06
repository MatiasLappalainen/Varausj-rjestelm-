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
        this.Aikataulut = parseAikataulut();
        this.yhteydet = yhteydet;
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

    /**
     * Tekee arrayn tiedostosta joka sisältää aikataulut
     * @return
     */
    public ArrayList parseAikataulut(){

        ArrayList<String> list = new ArrayList<String>();
        try {
            Scanner s = new Scanner(new File("./src/helsinki.txt"));
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
