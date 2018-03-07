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


    /**
     * Tekee arrayn tiedostosta joka sisältää aikataulut
     * @return
     */

    public ArrayList haeAikataulut(String path, String tunniste){
        ArrayList<String> aikataulut = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(path));
            boolean found = false;
            while(sc.hasNext()) {
                String value = sc.next();
                if(value.equalsIgnoreCase(tunniste)){
                    found = true;
                }else if(value.equalsIgnoreCase("s")){
                    found =false;
                }else if(found == true){
                    aikataulut.add(value);
                }
            }
        } catch(FileNotFoundException ie){
            ie.printStackTrace();
        }
        return aikataulut;
    }
}
