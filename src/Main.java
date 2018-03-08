import java.util.*;

public class Main {


    public ArrayList<Asema> asemat;
    public ArrayList<String> Kaupungit = new ArrayList<>(Arrays.asList("Helsinki", "Hämeenlinna", "Joensuu", "Jyväskylä", "Kajaani", "Kouvola", "Turku", "Rovaniemi"));

    //Constructor
    public Main(){

        asemat = new ArrayList<>();

        for(String k : Kaupungit){
            asemat.add(new Asema(k));
        }
        // Kutsu init
        init();
    }

    // ns main metodi
    public void init(){
        Matka matka = new Matka();
        Askel askel = new Askel();
        Varaus varaus = new Varaus();
        Asema lahto = new Asema();
        Asema maaranpaa = new Asema();

        // Ohjelman tila eli katsoo askeleen ja menee sitä mukaan ohjelmassa eteenpäin methodilla lisaaAskel
        switch(askel.annaAskel()){
            case 0:
                lahto = varaus.asetaLahto(asemat);
                matka.asetaLahto(lahto);
                askel.lisaaAskel();
            case 1:
                maaranpaa = varaus.asetaMaaranpaa(asemat, lahto);
                matka.asetaMaaranpaa(maaranpaa);
                askel.lisaaAskel();
            case 2:
                matka.asetaAika(varaus.asetaAika(lahto, maaranpaa));
                askel.lisaaAskel();
            case 3:
                System.out.printf("Lähtö: %s, Määränpää: %s%n, Aika: %s", lahto.annaNimi(), maaranpaa.annaNimi(), matka.annaAika());
                askel.lisaaAskel();


        }
    }

    public static void main(String[] args){
        new Main();
    }
}
