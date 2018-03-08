import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Varaus {
    Scanner in;

    Matka matka = new Matka();

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
    public Asema asetaLahto(ArrayList<Asema> asemat) {
        in = new Scanner(System.in);

        while(true) {
            listaaAsemat(asemat);
            try {
                int lahto = in.nextInt();
                if (lahto > asemat.size() - 1 || lahto < 0) {
                    System.out.println("Valitse Lähtöpaikka");
                    continue;
                } else return asemat.get(lahto);
            } catch(InputMismatchException ex) {
                in.nextLine();
            }
        }
    }

    /**
     * Kysyy käyttäjältä niin kauan arvoa kunnes arvo on rajojen sisäpuolella
     * @param asemat
     * @param lahto
     * @return
     */
    public Asema asetaMaaranpaa(ArrayList<Asema> asemat, Asema lahto) {
        in = new Scanner(System.in);

        while(true) {
            ArrayList<PääteAsema> yhteydet = lahto.getYhteydet();
            for (int i = 0; i < yhteydet.size(); i++)
                System.out.println(i + ": " + yhteydet.get(i).annaNimi());
            try {
                int mp = in.nextInt();
                if (mp > yhteydet.size() - 1 || mp < 0) {
                    System.out.println("Valitse Määränpää: ");
                    continue;

                } else
                    return yhteydet.get(mp);
            } catch(InputMismatchException ex){
                in.nextLine();
            }
            }
    }

    public String asetaAika(Asema asema, Asema pasema){
        in = new Scanner(System.in);
        System.out.println(asema.annaNimi() + " ... " + pasema.annaNimi());
        ArrayList<String> aikataulut = asema.haeAikataulut("./src/aikataulut/" + asema.annaNimi() + ".txt", pasema.annaNimi());

        while (true) {
            try {
                for (int i = 0; i < aikataulut.size(); i++) {
                    System.out.println(i + ": " + aikataulut.get(i));
                }

                int aika = in.nextInt();
                return aikataulut.get(aika);
            } catch(InputMismatchException ex){
                in.nextLine();
            }
            }
    }
}
