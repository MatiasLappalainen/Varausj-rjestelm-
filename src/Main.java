import java.util.*;

public class Main {

    Asema asema;

    public ArrayList<Asema> paikat;
    public ArrayList<String> Kaupungit = new ArrayList<>(Arrays.asList("Helsinki", "Hämeenlinna", "Joensuu", "Jyväskylä", "Kajaani"));

    // Tee randomina muutama yhteys asemille
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

    public Main(){

        paikat = new ArrayList<>();
        ArrayList<String> yhteydet;

        for(String k : Kaupungit){
            paikat.add(new Asema(k, randomYhteydet()));
        }

        init();
    }
    // ns main metodi
    public void init(){
        Askel askel = new Askel();
        Varaus varaus = new Varaus();
        Asema asema  = new Asema("Helsinki", randomYhteydet());
        int lahto = 0;
        int maaranpaa = 0;
        switch(askel.annaAskel()){
            case 0:
                lahto = varaus.asetaLahto(paikat);
                askel.lisaaAskel();
            case 1:
                maaranpaa = varaus.asetaMaaranpaa(paikat, lahto);
                askel.lisaaAskel();
            case 2:
                System.out.println("Lähtö: " + paikat.get(lahto).annaNimi() + ", Määränpää: " + paikat.get(lahto).annaYhteydet().get(maaranpaa));
                askel.lisaaAskel();
            case 3:
                for(String s : asema.annaAikataulut()) {
                    System.out.println(s);
                }

        }
    }

    public static void main(String[] args){
        new Main();
    }
}
