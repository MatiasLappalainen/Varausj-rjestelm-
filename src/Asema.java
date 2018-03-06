import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Asema {

    public String nimi;
    ArrayList<String> yhteydet;
    ArrayList<String> Aikataulut;

    public Asema(String nimi, ArrayList yhteydet){
        this.nimi = nimi;
        this.yhteydet = yhteydet;
        this.Aikataulut = parseAikataulut();
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

    public ArrayList<String> annaAikataulut(){
        return Aikataulut;
    }

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
