import java.util.*;

public class Main {

    Asema asema;

    public ArrayList<Asema> paikat;
    public ArrayList<String> Kaupungit = new ArrayList<>(Arrays.asList("Helsinki", "Hämeenlinna", "Joensuu", "Jyväskylä", "Kajaani"));

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

    public void init(){
        Askel askel = new Askel();
        Varaus varaus = new Varaus();
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
        }
    }

    public static void main(String[] args){
        new Main();
        Scanner sc = new Scanner();
        System.out.println("Tervetuloa varausjarjestelmaan! Syota lahtopaikka");
        String start = sc.nextLine();
        System.out.println("Syota matkakohde");
        String target = sc.nextLine();
    }
}
