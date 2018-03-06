import java.util.ArrayList;
import java.util.Scanner;

public class Varaus {
    Scanner in;

    private void listaaPaikat(ArrayList<Asema> paikat){
        int i = 0;
        for(Asema n : paikat){
            System.out.println(i++ + ": " + n.annaNimi());
        }
    }

    public int asetaLahto(ArrayList<Asema> paikat) {
        in = new Scanner(System.in);

        while(true) {
            listaaPaikat(paikat);
            int lahto = in.nextInt();
            if(lahto > paikat.size()-1 || lahto < 0){
                System.out.println("Valitse Lähtöpaikka");
                continue;
            }else return lahto;

        }
    }

    public int asetaMaaranpaa(ArrayList<Asema> paikat, int lahto) {
        in = new Scanner(System.in);
        while(true) {
            for (int i = 0; i < paikat.get(lahto).annaYhteydet().size(); i++) {
                System.out.println(i + ": " + paikat.get(lahto).annaYhteydet().get(i));
            }

            int mp = in.nextInt();
            if(mp > paikat.get(lahto).annaYhteydet().size()-1 || mp < 0){
                System.out.println("Valitse Määränpää: ");
                continue;
            }else
            return mp;
        }
    }
}
