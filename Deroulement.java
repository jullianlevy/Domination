import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;



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
	ArrayList<Espace> Espaces = new ArrayList<Espace>();
	
	
//LE JEUX TOTAL
	
	public Deroulement() throws FileNotFoundException, IOException {

		
		

		Jeux();

	}

// DEBUT DU JEU
	public void Jeux() {
		creationJoueur();
		plateauJoueur();
		
		NombreDomino();
		System.out.println("-------------");
		ChoisirRois();
		System.out.println("-------------");
		System.out.println("------   LE JEUX COMMENCE   -----");
		int a = 1;

		while(listdomino.size()!=0) {
			System.out.println("---------   TOUR N°" + a + "   ----------");

			tour(a);
			Toursuivant();// Liste joueurs modifié (son id) pour le tour suivant
			a++;
		}
		for(Joueurs joueur:listjoueurs) {
			remplissagecase(joueur);
			delimiterzone(joueur);
			scoretotal(joueur);
			System.out.println(joueur.getName()+"a obtenu le score de "+joueur.getScore());
			}
		
		listjoueurs.sort(Comparator.comparing(Joueurs::getScore));
		int numgagnant=Joueurs.nbrjoueurs-1;
		System.out.println("Le gagnant est "+listjoueurs.get(numgagnant).getName());

	}
	
//PREPARATION DE CHAQUE TOUR 
	
	public void tour(int a) {
		Melangerdom();
		System.out.println("-------------");

		tiredomino();
		System.out.println("-------------");

		showpioche();
		choisirdomino();// choix domino
		for(Joueurs jou:listjoueurs) {
			printPlateau(jou);
			placeDomino(jou,a);
		}
		

	}

	
	
//FONCTION ANNEXES DOMINO	
	
	public void placeDomino(Joueurs joueur,int a) {
		
		// 1. CoordonnÃ©es de la Face A.
		// 2. Orientation du domino.
		// 3. CoordonnÃ©es de la Face B.
		// 4. est ce que c'est jouable AKA : - Cases a cotÃ© ( chateau + terrain )
		// - x et y E 1 ; 9
		// - Case nulle
		// une fois que tt est ok passage Ã  un autre joueur

		// Choix des CoordonnÃ©es du domino
		for (Domino domi : joueur.dominojoueurs) {
			choixCoordonneesX();
			choixCoordonneesY();
			String x=orientation();
			int[] coB=rotation(x, choixCoordonneesX(), choixCoordonneesY());
			if(testB(coB)) {
				int[] coA=coordonneesA(choixCoordonneesX(), choixCoordonneesY());
				libreA(coA,joueur);
				libreB(coB,joueur);
				if(libreB(coA,joueur)==true&&libreB(coB,joueur)==true&&terrainOK(a,coA,coB,joueur,domi)) {
					dominosurplateau(coA,coA,domi,joueur);
					joueur.dominojoueurs.remove(domi);
				}
				else {placeDomino(joueur,a);}
					
			}
			else {placeDomino(joueur,a);}
			
			
			
		}

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
	public void showpioche() {
		// Nous montre les dominos dans la pioche
		pioche.sort(Comparator.comparing(Domino::getNumDomino));
		for (Domino domipioche : pioche) {
			System.out.println("le domino dans la pioche est :" + domipioche.getNumDomino());

		}
	}

	
//FONCTION ANNEXES JOUEUR
	
	public void creationJoueur() {
		NombreJoueurs();

		NomJoueur();

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
//FONCTIONS ANNEXES PLATEAU
	
	public void plateauJoueur() {
		for (Joueurs jou:listjoueurs) {
			
			Espace individuel = new Espace();
			jou.setPlateau(individuel);
			
			Espaces.add(individuel);
		}

		
	
	}
	public void printPlateau(Joueurs jou) {
		Type check = Type.VIDE;
		
		
		for (int i = 0; i < jou.getPlateau().grille.length; i++) {
			for (int j = 0; j < jou.getPlateau().grille[i].length ; j++) {
				if (jou.getPlateau().grille[i][j].getTerrain() != check) {
					jou.getPlateau().print(i,j);
				}
				else {
					System.out.print("| _ ");
				}
			}
			System.out.println("|");
			System.out.println("");
			
		}
	}
	public int choixCoordonneesX() {
		int cooX;

		Scanner scan = new Scanner(System.in);
		System.out.println("CoordonnÃ©e X de la face A ?");
		while (!scan.hasNext("[1-9]")) {
			System.out.println("Entrez une coordonnÃ©e comprise entre 1 et 9");
			scan.next();
		}
		cooX = scan.nextInt();
		return cooX;

	}
	public int choixCoordonneesY() {
		int cooY;

		Scanner scan = new Scanner(System.in);
		System.out.println("CoordonnÃ©e Y de la face A ?");
		while (!scan.hasNext("[1-9]")) {
			System.out.println("Entrez une coordonnÃ©e comprise entre 1 et 9");
			scan.next();
		}
		cooY = scan.nextInt();
		return cooY;
	}
	public String orientation() { // Choix de l'orientation du domino
		int sens;
		String orientation = "";

		Scanner scan = new Scanner(System.in);
		System.out.println("Quel est le sens du domino ?");
		System.out.println("Rotation 90Â° horaire");
		System.out.println("1. Haut");
		System.out.println("2. Droite");
		System.out.println("3. Bas");
		System.out.println("4. Gauche");

		while (!scan.hasNext("[1-4]")) {
			System.out.println("Entrez un nombre entre 1 et 4");
			scan.next();
		}
		sens = scan.nextInt();

		switch (sens) {
		case 1:
			orientation = "Haut";

		case 2:
			orientation = "Droite";

		case 3:
			orientation = "Bas";

		case 4:
			orientation = "Gauche";

		}
		return orientation;

	}
	public int[] rotation(String orientation, int cooX, int cooY) {
		int[] cooB = new int[2];
		int cooX2 = 1;
		int cooY2 = 2;
		switch (orientation) {
		case ("Haut"):
			cooX2 = cooX;
			cooY2 = cooY - 1;
			break;
		case ("Droite"):
			cooX2 = cooX - 1;
			cooY2 = cooY;
			break;
		case ("Bas"):
			cooX2 = cooX;
			cooY2 = cooY + 1;
			break;
		case ("Gauche"):
			cooX2 = cooX + 1;
			cooY2 = cooY;
			break;
		}

		cooB[0] = cooX2;
		cooB[1] = cooY2;

		return cooB;

	}
	public boolean testB(int[] cooB) {// CoordonnÃ©es de A ( sous la forme d'une seule variable )

		if (!((cooB[0] >= 1) && (cooB[0] <= 9))) {
			System.out.println("Rotation incorrecte !");
			return false;
		}

		else if (!((cooB[1] >= 1) && (cooB[1] <= 9))) {
			System.out.println("Rotation incorrecte !");
			return false;

		}

		else {
			return true;
		}
	}
	public  int[] coordonneesA(int cooX, int cooY) {
		int[] cooA = new int[2];
		cooA[0] = cooX;
		cooA[1] = cooY;

		return cooA;
	}
	public void dominosurplateau(int[] x,int[] y,Domino domi,Joueurs joueur) {
		Type faceA=Type.valueOf(domi.facegauche.gettypeface());
		joueur.getPlateau().grille[x[0]][x[1]].setTerrain(faceA);
		joueur.getPlateau().grille[x[0]][x[1]].setNbCouronne(domi.facegauche.getNbCouronnes());
		Type faceB=Type.valueOf(domi.facedroite.gettypeface());
		joueur.getPlateau().grille[y[0]][y[1]].setTerrain(faceB);
		joueur.getPlateau().grille[y[0]][y[1]].setNbCouronne((domi.facedroite.getNbCouronnes()));
		
		
		
	}
	public boolean estLibre(Joueurs joueur) {
		if (libreA(coordonneesA(choixCoordonneesX(),choixCoordonneesY()),joueur) == true) {
			return true;
		}
		else if (libreB(rotation(orientation(), choixCoordonneesX(),choixCoordonneesY()),joueur) == true) {
			return true;
		}
		else {return false;}
	}
	
	public boolean libreA(int[] cooA, Joueurs joueur) {
		Type testLibre = joueur.getPlateau().grille[cooA[0]][cooA[1]].getTerrain();
		if (testLibre == Type.VIDE) {
			return true;
		}
		else { 
			System.out.println("Une des cases n'est pas vide !");
			return false;
		}

	}

	
	public boolean libreB(int[] cooB,Joueurs joueur) {
		Type testLibre = joueur.getPlateau().grille[cooB[0]][cooB[1]].getTerrain();
		if (testLibre == Type.VIDE) {
			return true;
		}
		else { 
			System.out.println("Une des cases n'est pas vide !");
			return false;
		}

	}

	public boolean terrainOK(int a, int[] cooA, int[] cooB,Joueurs joueur,Domino dom) {
		int xA = cooA[0];
		int yA = cooA[1];
		int xB = cooB[0];
		int yB = cooB[1];
		
		Type testChateau = Type.CHATEAU;
				
			
				if (a == 1) {
					if (joueur.getPlateau().grille[xA][yA+1].getTerrain() == testChateau || joueur.getPlateau().grille[xA][yA-1].getTerrain() == testChateau || joueur.getPlateau().grille[xA+1][yA].getTerrain() == testChateau || joueur.getPlateau().grille[xA-1][yA].getTerrain() == testChateau ) {
						return true; 
					}
					else if (joueur.getPlateau().grille[xB][yB+1].getTerrain() == testChateau || joueur.getPlateau().grille[xB][yB-1].getTerrain() == testChateau || joueur.getPlateau().grille[xB+1][yB].getTerrain() == testChateau || joueur.getPlateau().grille[xB-1][yB].getTerrain() == testChateau ) {
						return true;
					}
					else { 
						System.out.println("Veuillez placer votre 1er domino à cote du chateau.");
						return false;
					}
				}
				else {
					String terrainA = dom.facegauche.gettypeface();
					String terrainB = dom.facedroite.gettypeface();
					
					Type sameA = Type.valueOf(terrainA);
					Type sameB = Type.valueOf(terrainB);
					
					if (joueur.getPlateau().grille[xA][yA+1].getTerrain() == sameA || joueur.getPlateau().grille[xA][yA-1].getTerrain() == sameA || joueur.getPlateau().grille[xA+1][yA].getTerrain() == sameA || joueur.getPlateau().grille[xA-1][yA].getTerrain() == sameA || joueur.getPlateau().grille[xA][yA+1].getTerrain() == testChateau || joueur.getPlateau().grille[xA][yA-1].getTerrain() == testChateau || joueur.getPlateau().grille[xA+1][yA].getTerrain() == testChateau ||joueur.getPlateau().grille[xA-1][yA].getTerrain() == testChateau) {
						return true;
					}
					else if (joueur.getPlateau().grille[xB][yB+1].getTerrain() == sameB || joueur.getPlateau().grille[xB][yB-1].getTerrain() == sameB || joueur.getPlateau().grille[xB+1][yB].getTerrain() == sameB || joueur.getPlateau().grille[xB-1][yB].getTerrain() == sameB ||joueur.getPlateau().grille[xB][yB+1].getTerrain() == testChateau || joueur.getPlateau().grille[xB][yB-1].getTerrain() == testChateau || joueur.getPlateau().grille[xB+1][yB].getTerrain() == testChateau ||joueur.getPlateau().grille[xB-1][yB].getTerrain() == testChateau) { 


						return true; 
					}
					else {
						System.out.println("Terrain non valide.");
						return false; 
					}
				}
			
		}
		



	// Check list pour poser le domino :
	// Cases cooA et cooB dans les limites du plateau.
	// Cases en cooA et cooB libres.
	// Cases adjacentes selon les rÃ¨gles :
	// - SI TOUR 1 : Adjacent au chÃ¢teau.
	// - SI TOUR n : Liens de Terrain.

	
// FONCTION ANNEXES POUR TOUR SUIVANT
	public void Toursuivant() {


		ordredomino.sort(Comparator.comparing(Domino::getNumDomino));

		if (Joueurs.nbrjoueurs == 2) {
			for (Joueurs jou : listjoueurs) {
				if (jou.dominojoueurs.contains(ordredomino.get(3))) {
					jou.setId(4);
				}

				if (jou.dominojoueurs.contains(ordredomino.get(2))) {
					jou.setId(2);

				}
				if (jou.dominojoueurs.contains(ordredomino.get(1))) {
					jou.setId(1);
				}

				if (jou.dominojoueurs.contains(ordredomino.get(0))) {
					jou.setId(0);
				}

			}
		}
		listjoueurs.sort(Comparator.comparing(Joueurs::getId));

		if (Joueurs.nbrjoueurs == 3) {
			for (Joueurs jou : listjoueurs) {

				if (jou.dominojoueurs.contains(ordredomino.get(0))) {
					jou.setId(0);
				}
				if (jou.dominojoueurs.contains(ordredomino.get(1))) {
					jou.setId(1);
				}
				if (jou.dominojoueurs.contains(ordredomino.get(2))) {
					jou.setId(2);
				}
			}

		}
		listjoueurs.sort(Comparator.comparing(Joueurs::getId));

		if (Joueurs.nbrjoueurs == 4) {
			for (Joueurs jou : listjoueurs) {
				if (jou.dominojoueurs.contains(ordredomino.get(0))) {
					jou.setId(0);
				}
				if (jou.dominojoueurs.contains(ordredomino.get(1))) {
					jou.setId(1);
				}
				if (jou.dominojoueurs.contains(ordredomino.get(2))) {
					jou.setId(2);
				}
				if (jou.dominojoueurs.contains(ordredomino.get(3))) {
					jou.setId(4);
				}
			}
		}
		listjoueurs.sort(Comparator.comparing(Joueurs::getId));

		// voir qui a le domino le plus petit et set son id à 0

	}


// FONCTION ANNEXES AU SCORE DE CHAQUE JOUEUR
	public void remplissagecase(Joueurs joueur) {
		for(int i=0;i<joueur.getPlateau().grille.length;i++){
			for(int j=0;j<joueur.getPlateau().grille[i].length;j++){
				joueur.listcase.add(joueur.getPlateau().grille[i][j]);
				
				
			}
		}
	}
	public java.util.ArrayList<Case> memeterrain(Case macase){
		ArrayList<Case> sameterrain=new ArrayList<>();
		if (macase.getTerrain()==Type.CHATEAU) {
			return null;
		}
		Case caseA=new Case(macase.getPosX(),macase.getPosY()-1);
		Case caseB=new Case(macase.getPosX(),macase.getPosY()+1);
		Case caseC=new Case(macase.getPosX()-1,macase.getPosY());
		Case caseD=new Case(macase.getPosX()+1,macase.getPosY());
		if(macase.getTerrain()==caseA.getTerrain()) {
			sameterrain.add(caseA);
		}if(macase.getTerrain()==caseB.getTerrain()) {
			sameterrain.add(caseB);
		}if(macase.getTerrain()==caseC.getTerrain()) {
			sameterrain.add(caseC);
		}if(macase.getTerrain()==caseD.getTerrain()) {
			sameterrain.add(caseD);
		}
		return sameterrain;
		
	}
	
	public void delimiterzone(Joueurs joueur) {
		for(Case macase:joueur.listcase) {
			boolean isContained = false;
			for(ArrayList liste:joueur.listzone) {
				if(liste.contains(macase)) {
					isContained=true;
					
				}
			}
			if(isContained==false) {
				ArrayList<Case> zoneterrain=new ArrayList<>();
				for(Case lescases:memeterrain(macase)) {
					zoneterrain.add(lescases);
					joueur.listzone.add(zoneterrain);
					
				}
			}
		}
		
	}
	public void scoretotal(Joueurs joueur) {
		ArrayList<Integer> scorezone=new ArrayList<>();
		for(java.util.ArrayList<Case> list:joueur.listzone) {
			int nbrCouronneZone=0;
			int nbrCaseZone=0;
			for(Case unecase:list) {
				nbrCaseZone+=1;
				nbrCouronneZone+=unecase.getNbCouronne();
				
			}
			int scoreinter=nbrCouronneZone*nbrCaseZone;
			scorezone.add(scoreinter);
		}
		int scorefinal=0;
		for(int i:scorezone) {
			scorefinal+=i;
		}
		joueur.setScore(scorefinal);
	}
	
//Affichage CSV
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
