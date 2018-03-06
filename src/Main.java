import java.util.*;

public class Main {

    Asema asema;

    public ArrayList<Asema> asemat;
    public ArrayList<String> Kaupungit = new ArrayList<>(Arrays.asList("Helsinki", "Hämeenlinna", "Joensuu", "Jyväskylä", "Kajaani"));

    //Constructor
    public Main(){

        asemat = new ArrayList<>();
        ArrayList<String> yhteydet;

        for(String k : Kaupungit){
            asemat.add(new Asema(k, randomYhteydet()));
        }
        // Kutsu init
        init();
    }

    // Tee randomina muutama yhteys asemien välille
    public ArrayList randomYhteydet(){
        Random r = new Random();

        List<String> kaupungitList = new LinkedList<>(Kaupungit);
        ArrayList<String> yhteydet = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            int random = r.nextInt(kaupungitList.size());
            yhteydet.add(kaupungitList.get(random));
            kaupungitList.remove(kaupungitList.get(random));
        }


        return yhteydet;
    }

    // ns main metodi
    public void init(){
        Askel askel = new Askel();
        Varaus varaus = new Varaus();
        Asema asema  = new Asema("Helsinki", randomYhteydet());
        int lahto = 0;
        int maaranpaa = 0;
        // Ohjelman tila eli katsoo askeleen ja menee sitä mukaan ohjelmassa eteenpäin methodilla lisaaAskel
        switch(askel.annaAskel()){
            case 0:
                lahto = varaus.asetaLahto(asemat);
                askel.lisaaAskel();
            case 1:
                maaranpaa = varaus.asetaMaaranpaa(asemat, lahto);
                askel.lisaaAskel();
            case 2:
                System.out.println("Lähtö: " + asemat.get(lahto).annaNimi() + ", Määränpää: " + asemat.get(lahto).annaYhteydet().get(maaranpaa));
                askel.lisaaAskel();


        }
    }

    public static void main(String[] args){
        new Main();
    }
}
