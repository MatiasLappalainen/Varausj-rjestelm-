import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Varaus {
    private Scanner in;

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
                } else return asemat.get(lahto);
            } catch(InputMismatchException ex) {
                in.nextLine();
            }
        }
    }

    /**
     * Kysyy käyttäjältä niin kauan arvoa kunnes arvo on rajojen sisäpuolella
     * @param lahto
     * @return
     */
    public Asema asetaMaaranpaa(Asema lahto) {
        in = new Scanner(System.in);

        while(true) {
            ArrayList<PaateAsema> yhteydet = lahto.getYhteydet();
            for (int i = 0; i < yhteydet.size(); i++)
                System.out.println(i + ": " + yhteydet.get(i).annaNimi());
            try {
                int mp = in.nextInt();
                if (mp > yhteydet.size() - 1 || mp < 0) {
                    System.out.println("Valitse Määränpää: ");

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
        ArrayList<String> aikataulut = asema.haeAikataulut(pasema.annaNimi());

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
    public int getIstumapaikka(Juna juna){
        juna.setPaikat(24);
        in = new Scanner(System.in);
        int paikka = 0;
        int i;
        while(true) {
            try {
                i = 1;

            while (i < juna.annaPaikat()) {
                System.out.println("*" + i++ + " " + i++ + "   " + i++ + " " + i++ + "*");
            }

                paikka = in.nextInt();
            if(paikka > 0) {
                return paikka;
            }
            } catch (InputMismatchException ex) {
                System.out.println("Valitse Paikka");
                in.nextLine();
            }
        }
    }

    public boolean jatketaankoVarausta(){
        in = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Jatketaanko varausta? \n Kyllä/Ei");
                String vastaus = in.nextLine();
                if (vastaus.equalsIgnoreCase("Kyllä")) {
                    return true;
                } else if (vastaus.equalsIgnoreCase("ei")) {
                    return false;
                }
            } catch(InputMismatchException ex){
                in.nextLine();
            }
        }

    }

}
