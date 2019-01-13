import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.paint.Color;

import java.util.Random;
import java.util.Collections;
import java.util.Comparator;
import java.io.IOException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		System.out.println("--------------------------------------");
		System.out.println("BIENVENUE DOMIN'ATION");
		System.out.println("--------------------------------------");
		System.out.println("ééééééééé");
		System.out.println("");

		Deroulement der = new Deroulement();

		// Deroulement.ChoisirRois();

	}

	// Domino.creationliste();
	// Deroulement.NombreDomino();
	// Deroulement.Melangerdom();
	// Deroulement.ChoisirRois();
	// for(Joueurs joueur:Joueurs.listjoueurs) {
	// System.out.println(joueur.getName()+joueur.listrois);
	// }

	public static void NombreJoueurs() {
		Scanner nbjoueur = new Scanner(System.in);
		System.out.println("Indiquer le nombre de joueur: ");
		while (!nbjoueur.hasNext("[2-4]")) {
			System.out.println("Entrer un nombre entre 2 et 4");

			nbjoueur.nextInt();
		}
		Joueurs.nbrjoueurs = nbjoueur.nextInt();

	}

}
