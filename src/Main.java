import java.util.*;

public class Main {


    public final ArrayList<Asema> asemat;
    public final ArrayList<String> Kaupungit = new ArrayList<>(Arrays.asList("Helsinki", "Hämeenlinna", "Joensuu", "Jyväskylä", "Kajaani", "Kouvola", "Turku", "Rovaniemi"));

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
        Juna juna = new Juna();

        // Ohjelman tila eli katsoo askeleen ja menee sitä mukaan ohjelmassa eteenpäin methodilla lisaaAskel
        switch(askel.annaAskel()){
            case 0:
                System.out.print("\n\n\n\n\n\n\n");
                lahto = varaus.asetaLahto(asemat);
                matka.asetaLahto(lahto);
            case 1:
                System.out.print("\n\n\n\n\n\n\n");
                maaranpaa = varaus.asetaMaaranpaa(lahto);
                matka.asetaMaaranpaa(maaranpaa);
            case 2:
                System.out.print("\n\n\n\n\n\n\n");
                matka.asetaAika(varaus.asetaAika(lahto, maaranpaa));
            case 3:
                System.out.print("\n\n\n\n\n\n\n");
                matka.asetaIstumapaikka(varaus.getIstumapaikka(juna));
            case 4:
                System.out.print("\n\n\n\n\n\n\n");
                System.out.printf("Lähtö: %s, Määränpää: %s%n, Aika: %s, Istumapaikka: %s", lahto.annaNimi(), maaranpaa.annaNimi(), matka.annaAika(), matka.annaIstumapaikka());
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
