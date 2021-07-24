import java.util.Scanner;
import java.util.Arrays;

public class loto {

    Scanner in = new Scanner(System.in);
    private int a;

    int[] array = new int[5];
    int[] grilleLoto = new int[5];
    joueur[] Joueur = new joueur[num()];
    private final int mise = a * 2;
    private int g = 0;

    public void nbrJoueur() {
        System.out.println("Combien de joueurs: ");
        a = in.nextInt();
    }

    public int num() {
        return a;
    }

    public void createPlayer() {

        a = in.nextInt();
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

    public int[] gridLoto() {
        for (int i = 0; i < grilleLoto.length; i++) {
            grilleLoto[i] = (int) (Math.random() * 50);
        }
        return grilleLoto;
    }

    public void afficheLoto() {
        System.out.println(Arrays.toString(gridLoto()));
    }

    public void checkWinner() {

        int somme;
        // double for pour regarder si i=j et stocker dans une variable ++ dès qu'il le
        // rencontre
        // final int somme et puis pour chaque gagnant 1,2,3,4 varibale depuis somme
        // avec Math.pow mais en dehors du double for je pense

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array.length; k++) {
                    if (Joueur[i].getArray()[j] == gridLoto()[k]) {
                        g++;
                    }
                }
            }
            if (g == 1) {
                somme = mise / 32;
                System.out.println("Bravo " + Joueur[i].getNom() + ", vous avez" + g
                        + "nombre en commun avec la grille du loto et vous avez donc remporté" + somme + " €");
            } else if (g == 2) {
                somme = mise / 16;
                System.out.println("Bravo " + Joueur[i].getNom() + ", vous avez" + g
                        + "nombre en commun avec la grille du loto et vous avez donc remporté" + somme + " €");
            } else if (g == 3) {
                somme = mise / 8;
                System.out.println("Bravo " + Joueur[i].getNom() + ", vous avez" + g
                        + "nombre en commun avec la grille du loto et vous avez donc remporté" + somme + " €");
            } else if (g == 4) {
                somme = mise / 4;
                System.out.println("Bravo " + Joueur[i].getNom() + ", vous avez" + g
                        + "nombre en commun avec la grille du loto et vous avez donc remporté" + somme + " €");
            } else if (g == 5) {
                somme = mise / 2;
                System.out.println("Bravo " + Joueur[i].getNom() + ", vous avez" + g
                        + "nombre en commun avec la grille du loto et vous avez donc remporté" + somme + " €");
            }
        }

    }

    public static void main(String[] args) {

        loto Loto = new loto();
        System.out.println("Les numéros gagnats sont: ");
        Loto.gridLoto();
        Loto.afficheLoto();

        Loto.createPlayer();
        Loto.checkWinner();

    }
}
