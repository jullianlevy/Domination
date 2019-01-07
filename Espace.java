import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class Espace {
	static final int largeurY=9;
	static final int longueurX=9;
	Case[][] grille=new Case[longueurX][largeurY];
	
	
	public Espace(){
		for(int i=0;i<longueurX;i++){
			for(int j=0;j<largeurY;j++){
				grille[i][j]=new Case(i,j);
			}
		}
		Case chateau=grille[4][4];
		chateau.setTerrain(TypeTerrain.CHATEAU);
		chateau.setNbCouronne(0);
	}
	
	// 1. Coordonnées de la Face A.
	// 2. Orientation du domino.
	// 3. Coordonnées de la Face B.
	// 4. est ce que c'est jouable AKA : -  Cases a coté ( chateau + terrain ) 
	// 				     -  x et y E 1 ; 9 
	//                                   -  Case nulle
	// une fois que tt est ok passage à un autre joueur
	
	
	
	// Choix des Coordonnées du domino
	public static int choixCoordonneesX() {
		int cooX ;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Coordonnée X de la face A ?");
		while(!scan.hasNext("[1-9]")) {
			System.out.println("Entrez une coordonnée comprise entre 1 et 9");
			scan.next();
		}
		cooX = scan.nextInt();
		return cooX;
		

	}
	
	public static int choixCoordonneesY() {
		int cooY ;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Coordonnée Y de la face A ?");
		while(!scan.hasNext("[1-9]")) {
			System.out.println("Entrez une coordonnée comprise entre 1 et 9");
			scan.next();
		}
		cooY = scan.nextInt();
		return cooY;
	}
		
		
	
	//Choix de l'orientation du domino
	public static String orientation() { 
		int sens ;
		String orientation ="";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Quel est le sens du domino ?");
		System.out.println("Rotation 90° horaire");
		System.out.println("1. Haut");
		System.out.println("2. Droite");
		System.out.println("3. Bas");
		System.out.println("4. Gauche");
		
		while(!scan.hasNext("[1-4]")) {
			System.out.println("Entrez un nombre entre 1 et 4");
			scan.next();
		}
		sens = scan.nextInt();
		
		
		switch (sens) {
		case 1: 
			orientation = "Haut";
		
		case 2:
			orientation="Droite";
		
		case 3: 
			orientation="Bas";
		
		case 4: 
			orientation="Gauche";
		
		return orientation;
			
		
			
		}
		
		
	}	

	// Coordonnées de B ( Rotation ) 
	public static int[] rotation(String orientation, int cooX, int cooY) {	
		int[] cooB = new int[2];
		int cooX2;
		int cooY2;
		switch(orientation) {
		case ("Haut"): 
			cooX2 = cooX; 
			cooY2 = cooY - 1;
			break;
		case ("Droite"):
			cooX2 = cooX - 1;
			cooY2 = cooY;
			break;
		case("Bas"):
			cooX2 = cooX;
			cooY2 = cooY + 1;
			break;
		case("Gauche"): 
			cooX2 = cooX + 1;
			cooY2 = cooY;
			break;
		}

		cooB[0] = cooX2;
		cooB[1] = cooY2; 

		return cooB;
		
	}

	public static boolean testB(int[] cooB) {
		
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
	
	
	//Coordonnées de A ( sous la forme d'une seule variable ) 
	public static int[] coordonnesA(int cooX, int cooY) {
		int[] cooA = new int[2];
		cooA[0] = cooX;
		cooA[1] = cooY;
		
		return cooA;
	}

	// Check list pour poser le domino :
	// Cases cooA et cooB dans les limites du plateau.
	// Cases en cooA et cooB libres.
	// Cases adjacentes selon les règles : 
	//       - SI TOUR 1 : Adjacent au château.
	//       - SI TOUR n : Liens de Terrain. 
	
	public static boolean libre(int[] cooA,int[] cooB) {

	}


	

}
