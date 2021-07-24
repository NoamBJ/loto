import java.util.Scanner;
import java.util.Arrays;

public class loto {

    Scanner in = new Scanner(System.in);
    private int a = in.nextInt();

    int[] array = new int[5];
    int[] grilleLoto = new int[5];
    joueur[] Joueur = new joueur[num()];
    private int mise = a * 2;
    private int g;

    public int num() {
        return a;
    }

    public void createPlayer() {

        in.nextLine();

        for (int i = 0; i < a; i++) {
            int b = i + 1;
            System.out.println("Bienvenue Joueur " + b);
            System.out.println("Entrez votre nom: ");
            String s = in.nextLine();
            Joueur[i] = new joueur(s, array);
            System.out.println("Entrez vos nombres");
            Joueur[i].setArray();

        }
    }

    public int getArgent() {
        return mise;
    }

    // créé la grille gagnante du Loto
    public int[] gridLoto() {
        for (int i = 0; i < grilleLoto.length; i++) {
            grilleLoto[i] = (int) (Math.random() * 50 + 1);

            for (int j = 0; j < grilleLoto.length; j++) {
                if (i != j) {
                    while (grilleLoto[i] == grilleLoto[j] || grilleLoto[i] < 1 || grilleLoto[i] > 50) {
                        grilleLoto[i] = (int) (Math.random() * 50 + 1);
                    }
                }

            }
        }
        return grilleLoto;
    }

    // affiche la grille gagnante du Loto
    public void afficheLoto() {
        System.out.println(Arrays.toString(gridLoto()));
    }

    public double calculateSomme(int g) {
        double somme = 0;

        if (g == 0) {
            somme = somme;
        } else if (g == 1) {
            somme = (double) mise / 32;
        } else if (g == 2) {
            somme = (double) mise / 16;
        } else if (g == 3) {
            somme = (double) mise / 8;
        } else if (g == 4) {
            somme = (double) mise / 4;
        } else if (g == 5) {
            somme = (double) mise / 2;
        }
        return somme;
    }

    public void checkWinner() {
        g = 0;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array.length; k++) {
                    if (Joueur[i].getArray()[j] == gridLoto()[k]) {
                        g++;
                    }
                }
            }
            System.out.println("Bravo " + Joueur[i].getNom() + ", vous avez " + g
                    + " nombre en commun avec la grille du loto et vous avez donc remporté " + calculateSomme(g)
                    + " €");
        }

    }

    public static void main(String[] args) {
        System.out.println("Combien de joueurs: ");
        loto Loto = new loto();
        int a = Loto.num();

        System.out.println("Les numéros gagnats sont: ");
        Loto.gridLoto();
        Loto.afficheLoto();

        Loto.createPlayer();

        Loto.checkWinner();

    }
}
