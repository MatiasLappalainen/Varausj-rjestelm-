import java.util.ArrayList;
import java.util.Scanner;

public class Varaus {
    Scanner in;

    private void listaaAsemat(ArrayList<Asema> asemat){
        int i = 0;
        for(Asema n : asemat){
            System.out.println(i++ + ": " + n.annaNimi());
        }
    }

    /**
     * Kysyy käyttäjältä niin kauan arvoa kunnes arvo on rajojen sisäpuolella
     * @param asemat
     * @return
     */
    public int asetaLahto(ArrayList<Asema> asemat) {
        in = new Scanner(System.in);

        while(true) {
            listaaAsemat(asemat);
            int lahto = in.nextInt();
            if(lahto > asemat.size()-1 || lahto < 0){
                System.out.println("Valitse Lähtöpaikka");
                continue;
            }else return lahto;

        }
    }

    /**
     * Kysyy käyttäjältä niin kauan arvoa kunnes arvo on rajojen sisäpuolella
     * @param asemat
     * @param lahto
     * @return
     */
    public int asetaMaaranpaa(ArrayList<Asema> asemat, int lahto) {
        in = new Scanner(System.in);

        while(true) {
            for (int i = 0; i < asemat.get(lahto).annaYhteydet().size(); i++) {
                System.out.println(i + ": " + asemat.get(lahto).annaYhteydet().get(i).annaNimi());
            }

            int mp = in.nextInt();
            if(mp > asemat.get(lahto).annaYhteydet().size()-1 || mp < 0){
                System.out.println("Valitse Määränpää: ");
                continue;
            }else
            return mp;
        }
    }
}
