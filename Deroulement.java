import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

import javafx.scene.paint.Color;

import java.util.Random;
import java.util.Collections;
import java.util.Comparator;

public class Deroulement {
	ArrayList<String> couleur = new ArrayList<String>();
	ArrayList<Joueurs> listjoueurs = new ArrayList<>();
	ArrayList<Domino> listdomino = new ArrayList<>();
	ArrayList<Domino> pioche = new ArrayList<Domino>();
	ArrayList<Rois> listrois = new ArrayList<Rois>();
	ArrayList<Domino> ordredomino = new ArrayList<Domino>();

	public Deroulement() throws FileNotFoundException, IOException {

		creationJoueur();
		creationliste();
		Jeux();

		
	}

	

	// On prepare le jeux
	public void Jeux() {
		NombreDomino();
		System.out.println("-------------");

		Melangerdom();
		System.out.println("-------------");

		tiredomino();
		System.out.println("-------------");
		ChoisirRois();
		System.out.println("-------------");
		System.out.println("------   LE JEUX COMMENCE   -----");
		
		showpioche();
		choisirdomino();
		System.out.println("----  LIST ORDRE CONTIENT-------");
		Toursuivant();
		

	}public void creationJoueur() {
		NombreJoueurs();

		NomJoueur();

	}



	public void choisirdomino() {

		if (Joueurs.nbrjoueurs == 2) {

			for (Joueurs joueur : listjoueurs) { // Chaque joueur doit choisir un domino

				System.out.println("C'est au tour de " + joueur.getName().toUpperCase() + " de jouer ");
				System.out.println(" -------                                  ---------");
				int i = 0;

				Scanner choixdomi = new Scanner(System.in);
				for (Domino domi : pioche) {

					System.out.println(" Pour le domino " + domi.getNumDomino() + " tapez " + i);

					i++;
				}
				int nombre = pioche.size();

				while (!choixdomi.hasNext("[0-nombre]")) {
					System.out.println("------- Vous devez entrer chiffre entre 0 et " + nombre);
					choixdomi.next();

				}
				int choixjoueur = choixdomi.nextInt();
				joueur.dominojoueurs.add(pioche.get(choixjoueur));

				ordredomino.add(pioche.get(choixjoueur));

				pioche.remove(pioche.get(choixjoueur));
				

			}
			for (Joueurs joueur : listjoueurs) { // Chaque joueur doit choisir un domino

				System.out.println("C'est au tour de " + joueur.getName().toUpperCase() + " de jouer ");
				System.out.println(" -------                                  ---------");
				int i = 0;

				Scanner choixdomi = new Scanner(System.in);
				for (Domino domi : pioche) {

					System.out.println(" Pour le domino " + domi.getNumDomino() + " tapez " + i);

					i++;
				}
				int nombre = pioche.size();

				while (!choixdomi.hasNext("[0-nombre]")) {
					System.out.println("------- Vous devez entrer chiffre entre 0 et " + nombre);
					choixdomi.next();

				}
				int choixjoueur = choixdomi.nextInt();
				joueur.dominojoueurs.add(pioche.get(choixjoueur));

				ordredomino.add(pioche.get(choixjoueur));

				pioche.remove(pioche.get(choixjoueur));
				

			}
			

		}

		if (Joueurs.nbrjoueurs == 3 || Joueurs.nbrjoueurs == 4) {
			for (Joueurs joueur : listjoueurs) { // Chaque joueur doit choisir un domino

				System.out.println("C'est au tour de " + joueur.getName().toUpperCase() + " de jouer ");
				System.out.println(" -------                                  ---------");
				int i = 0;

				Scanner choixdomi = new Scanner(System.in);
				for (Domino domi : pioche) {

					System.out.println(" Pour le domino " + domi.getNumDomino() + " tapez " + i);

					i++;
				}
				int nombre = pioche.size();

				while (!choixdomi.hasNext("[0-nombre]")) {
					System.out.println("------- Vous devez entrer chiffre entre 0 et " + nombre);
					choixdomi.next();

				}
				int choixjoueur = choixdomi.nextInt();
				joueur.dominojoueurs.add(pioche.get(choixjoueur));

				ordredomino.add(pioche.get(choixjoueur));

				pioche.remove(pioche.get(choixjoueur));

			}

		}
		System.out.println("-----             --------");
		System.out.println("La pioche est terminé");
		System.out.println("-----             --------");

		mesDom();
	}

	public void Toursuivant() {
		

			ordredomino.sort(Comparator.comparing(Domino::getNumDomino));
			for (Domino domi : ordredomino) {
				System.out.println("domino dans la liste ordre domino " + domi.getNumDomino());
				
			}
			
			
			

			// voir qui a le domino le plus petit et set son id à 0

		
	}

	public void mesDom() {

		for (Joueurs mesdomi : listjoueurs)
			for (int i = 0; i < mesdomi.dominojoueurs.size(); i++) {
				System.out.println(
						"les dominos de " + mesdomi.getName() + " : NUM°" + mesdomi.dominojoueurs.get(i).getNumDomino()
								+ " Face DROITE: " + mesdomi.dominojoueurs.get(i).getTypeFaceDroite() + "/NbCourone1= "
								+ mesdomi.dominojoueurs.get(i).getNbcCouronneDroite() + "  Face GAUCHE : "
								+ mesdomi.dominojoueurs.get(i).getTypeFaceGauche() + "/Nbcourone= "
								+ mesdomi.dominojoueurs.get(i).getNbCouronneFaceGauche());

			}

	}

	// on fixe le nombre de domino en fonction du nombre de joueurs.
	public void NombreDomino() {
		Random rand = new Random();
		if (Joueurs.nbrjoueurs == 2) {
			for (int i = 0; i < 24; i++) {
				int nbAleatoire = rand.nextInt(listdomino.size());

				listdomino.remove(nbAleatoire);
			}
			for (int i = 0; i < listdomino.size(); i++) {
				System.out.println("domino est " + listdomino.get(i).getNumDomino());
			}
		}
		if (Joueurs.nbrjoueurs == 3) {
			for (int i = 0; i < 12; i++) {
				int nbAleatoire = rand.nextInt(listdomino.size());
				listdomino.remove(nbAleatoire);
			}
			for (int i = 0; i < listdomino.size(); i++) {
				System.out.println("domino est " + listdomino.get(i).getNumDomino());
			}
		}
		System.out.println("--------------------------------------");
	}

	public void showdomino() {

		for (Domino domi : listdomino) {
			System.out.println("domino est " + domi.getNumDomino());
		}
		System.out.println("----------------");
	}

	

	public void NombreJoueurs() {
		Scanner nbjoueur = new Scanner(System.in);
		System.out.println(
				"Tout d'abord il vous faut indiquer ci dessous le nombre de joueur compris entre 2 et 4 joueurs:  ");
		while (!nbjoueur.hasNext("[2-4]")) {
			System.out.println("-----------Attention, veuillez resaisir le nombre de joueurs---------");
			nbjoueur.next();
		}
		Joueurs.nbrjoueurs = nbjoueur.nextInt();

	}

	// on melange les dominos.
	public void Melangerdom() {

		System.out.println("Les " + listdomino.size() + " dominos sont mélangés");
		Collections.shuffle(listdomino);
		for (int i = 0; i < listdomino.size(); i++) {
			System.out.println("domino est " + listdomino.get(i).getNumDomino());
		}
	}

	public void tiredomino() {

		if (Joueurs.nbrjoueurs == 2 || Joueurs.nbrjoueurs == 4) {
			for (int i = 0; i < 4; i++) {

				pioche.add(listdomino.get(i));
				listdomino.remove(listdomino.get(i));

			}
		}
		if (Joueurs.nbrjoueurs == 3) {
			for (int i = 0; i < 3; i++) {
				pioche.add(listdomino.get(i));
				listdomino.remove(listdomino.get(i));

			}
		}

	}

	public void showpioche() {// Nous montre les dominos dans la pioche
		pioche.sort(Comparator.comparing(Domino::getNumDomino));
		for (Domino domipioche : pioche) {
			System.out.println("le domino dans la pioche est :" + domipioche.getNumDomino());

		}
	}

	public void NomJoueur() {
		System.out.println("Rentrez le noms des participants");
		Scanner scan = new Scanner(System.in);
		int i = 1;
		for (i = 1; i < Joueurs.nbrjoueurs + 1; i++) {
			System.out.print("pseudo du joueur" + i + " : ");
			Joueurs joueur = new Joueurs(scan.nextLine(), i);
			listjoueurs.add(joueur);
			System.out.println("");

		}
	}

	public void ChoisirRois() {
		Rois bleu = new Rois(Couleur.BLEU, 1);
		Rois jaune = new Rois(Couleur.JAUNE, 2);
		Rois rouge = new Rois(Couleur.ROUGE, 3);
		Rois vert = new Rois(Couleur.VERT, 4);
		listrois.add(vert);
		listrois.add(jaune);
		listrois.add(rouge);
		listrois.add(bleu);

		if (Joueurs.nbrjoueurs == 2) {
			System.out.println(
					"Vous etes " + Joueurs.nbrjoueurs + " ainsi vous devez choisir 2 rois pour chaque joueur. ");
			for (Joueurs joueurtest : listjoueurs) {
				Scanner rois = new Scanner(System.in);
				String var = joueurtest.getName();

				System.out.println("");
				System.out.println("Maintenant c'est au tour de " + joueurtest.getName().toUpperCase()
						+ " de choisir la couleur de son rois");

				for (Rois roi : listrois) {
					System.out.println(roi.getColorRoi() + "  : TAPER " + roi.getNbr());

				}
				while (!rois.hasNext("[1-4]")) {

					System.out.println("Cette couleur n'est pas disponible,veuillez saisir un chiffre entre 1 et 4");
					rois.next();

				}
				int reponse = rois.nextInt();
				if (reponse == bleu.getNbr()) {
					joueurtest.listrois.add(bleu);
					listrois.remove(bleu);
				}
				if (reponse == rouge.getNbr()) {
					joueurtest.listrois.add(rouge);
					listrois.remove(rouge);
				}
				if (reponse == jaune.getNbr()) {
					joueurtest.listrois.add(jaune);
					listrois.remove(jaune);
				}
				if (reponse == vert.getNbr()) {
					joueurtest.listrois.add(vert);
					listrois.remove(vert);
				}
			}
			for (Joueurs joueurtest : listjoueurs) {
				Scanner rois = new Scanner(System.in);

				System.out.println("Maintenant c'est au tour de " + joueurtest.getName().toUpperCase()
						+ " de choisir la couleur de ses deux rois" + "/n");
				System.out.println("Chossissez parmi ces rois ");

				for (Rois roi : listrois) {
					System.out.println(roi.getColorRoi() + "  : TAPER " + roi.getNbr());

				}
				while (!rois.hasNext("[1-4]")) {

					System.out.println("Cette couleur n'est pas disponible,veuillez saisir un chiffre entre 1 et 4");
					rois.next();

				}
				int reponse = rois.nextInt();
				if (reponse == bleu.getNbr()) {
					joueurtest.listrois.add(bleu);
					listrois.remove(bleu);
				}
				if (reponse == rouge.getNbr()) {
					joueurtest.listrois.add(rouge);
					listrois.remove(rouge);
				}
				if (reponse == jaune.getNbr()) {
					joueurtest.listrois.add(jaune);
					listrois.remove(jaune);
				}
				if (reponse == vert.getNbr()) {
					joueurtest.listrois.add(vert);
					listrois.remove(vert);
				}
			}

		}
		if (Joueurs.nbrjoueurs == 3 || Joueurs.nbrjoueurs == 4) {
			System.out.println("Vous etes " + Joueurs.nbrjoueurs + " ainsi vous devez choisir 1 roi chacun");
			for (Joueurs joueurtest : listjoueurs) {
				Scanner rois = new Scanner(System.in);
				System.out.println("Maintenant c'est au tour de " + joueurtest.getName().toUpperCase()
						+ " de choisir la couleur de votre deux rois" + "/n");
				System.out.println("Chossissez parmi ces rois ");
				for (Rois roi : listrois) {
					System.out.println(roi.getColorRoi() + "  : TAPER " + roi.getNbr());

				}
				while (!rois.hasNext("[1-4]")) {

					System.out.println("Cette couleur n'est pas disponible,veuillez saisir un chiffre entre 1 et 4");
					rois.next();

				}
				int reponse = rois.nextInt();
				if (reponse == bleu.getNbr()) {
					joueurtest.listrois.add(bleu);
					listrois.remove(bleu);
				}
				if (reponse == rouge.getNbr()) {
					joueurtest.listrois.add(rouge);
					listrois.remove(rouge);
				}
				if (reponse == jaune.getNbr()) {
					joueurtest.listrois.add(jaune);
					listrois.remove(jaune);
				}
				if (reponse == vert.getNbr()) {
					joueurtest.listrois.add(vert);
					listrois.remove(vert);
				}
			}
		}
	}

	public void creationliste() throws FileNotFoundException, IOException {

		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader("dominos.csv"))) {

			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");

				int nbCouronne1 = Integer.valueOf(values[0]);
				String type1 = String.valueOf(values[1]);
				int nbCouronne2 = Integer.valueOf(values[2]);
				String type2 = String.valueOf(values[3]);
				int numeroDomino = Integer.valueOf(values[4]);

				Face facegauche = new Face(nbCouronne1, type1);
				Face facedroite = new Face(nbCouronne2, type2);

				Domino domino = new Domino(numeroDomino, facegauche, facedroite);

				listdomino.add(domino);
			}

		}
	}

}
