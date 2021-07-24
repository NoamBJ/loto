import java.util.Arrays;
import java.util.Scanner;

public class joueur {

    Scanner in = new Scanner(System.in);

    private String nom;
    private int[] array = new int[5];
    int a;

    public joueur(String nom, int[] array) {
        this.nom = nom;
        this.array = array;
    }

    public String setNom() {
        return nom = in.nextLine();
    }

    public String getNom() {
        return nom;
    }

    public void setArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();

            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    while (array[i] == array[j] || array[i] < 1 || array[i] > 50) {
                        System.out.println(
                                "Désolé, veuillez réessayer. Vous avez soit saisi un nombre non compris entre 1 et 50 soit entré 2 fois le même nombre");
                        array[i] = in.nextInt();
                    }
                }

            }
        }
        System.out.println(Arrays.toString(array));
    }

    public int[] getArray() {
        return array;
    }

}
