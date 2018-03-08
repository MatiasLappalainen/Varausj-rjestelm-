import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Asema {

    private final String nimi;

    public Asema(String nimi){
        this.nimi = nimi;
    }

    public Asema(){
        this.nimi = "";
    }

    public String annaNimi(){
        return nimi;
    }


    /**
     * Tekee arrayn tiedostosta joka sisältää aikataulut
     * @return
     */

    public ArrayList<String> haeAikataulut(String tunniste){
        ArrayList<String> aikataulut = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("./src/aikataulut/" + this.nimi + ".txt"));
            boolean found = false;
            sc.next();
            while(sc.hasNext()) {
                String value = sc.next();
                if(value.equalsIgnoreCase(tunniste)){
                    found = true;
                }else if(value.equalsIgnoreCase("$")){
                    found =false;
                }else if(found){
                    aikataulut.add(value);
                }
            }
        } catch(FileNotFoundException ie){
            System.out.println("Väärä polku");
        }
        return aikataulut;
    }
    //Etsii tiedostoista yhteys kaupunkien nimet
    public ArrayList<PaateAsema> getYhteydet() {
        Scanner scanner = null;
        Pattern pattern= Pattern.compile("[^A-Za-z-äösÄÖS]");
        String word;
        ArrayList<PaateAsema> asemat = new ArrayList<>();

        try{
            System.out.println(nimi);
            scanner = new Scanner(new File("./src/aikataulut/" + this.nimi + ".txt"));
        }catch(FileNotFoundException e){
            System.out.println("Polku on väärä");
        }
        scanner.nextLine();
        while(scanner.hasNext()){
            scanner.useDelimiter(pattern);
            word = scanner.next();
            if(!word.equals("")){
                asemat.add(new PaateAsema(word));
            }
        }
        return asemat;
    }
}
