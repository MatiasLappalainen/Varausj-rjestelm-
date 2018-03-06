import java.util.*;

public class Main {

    public ArrayList<Paikka> paikat;

    public ArrayList randomYhteydet(){
        Random r = new Random();

        List<String> kaupungitList = new LinkedList<String>(Arrays.asList("Helsinki", "Hämeenlinna", "Joensuu", "Jyväskylä", "Kajaani"));
        ArrayList<String> yhteydet = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            int random = r.nextInt(kaupungitList.size()-1);
            yhteydet.add(kaupungitList.get(random));
            kaupungitList.remove(kaupungitList.get(random));
        }


        return yhteydet;
    }

    public Main(){

        paikat = new ArrayList<>();
        ArrayList<String> yhteydet = randomYhteydet();

    }

    public static void main(String[] args){
        new Main();
    }
}
