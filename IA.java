import java.util.Random;
import java.util.ArrayList;

public class IA {
	
	int a; //Comtpeur de tours
	ArrayList<Domino> pioche = new ArrayList<Domino>();
	ArrayList<Case> vides = new ArrayList<Case>(); 
	ArrayList<Case> jouable = new ArrayList<Case>();
	Joueurs IA;
	String orientation ; 
	int cooX;
	int cooY;

	// main-like
	public void play () {
		if ( a == 1 ) {
			tour1();
		}
	}
	
	public void tour1() {
		
		// On suppose l'implentation de l'ia en tant que joueur , on suppose le choix du roi.
		//TODO : Placer le domino : aleat entre 1 et 4 pour A ; aleat entre 1 et 3 pour l'orient ;
		// Placement1 est fait : on a les coo de A et B pour le 1er jeu, reste à la placer sur le plateau ; 
	}
	
	public void sortCouronnes() {
		
		int total = 0;
		int totali;
		int j;
		
		for (Domino domi : pioche) { 
			for (int i = 0; i < pioche.size(); i++) {
				totali = domi.getNbcCouronneDroite() + domi.getNbCouronneFaceGauche();
				if (totali > total) { // supérieur strict : on prend le 1er donc celui avec le num le plus petit car pioche est sort
					total = totali;
					j = i; //indice du domino jouable aux couronnes le + élevé	
				}
				
			}
			
			System.out.println("Suzanne L'IA a choisi le domino d'indice "+j+"." );
			
			joueur.dominojoueurs.add(pioche.get(j));
															// IA OU JOUEUR POUR ADD ?
			ordredomino.add(pioche.get(j));

			pioche.remove(pioche.get(j));
			
		}
		
			
		}
	
	public void placement1() {
		Random random = new Random();
		int pos;
		int orient;
		
		pos = random.nextInt(4); //Random pour la position ( 0 1 2 3 )
		orient = random.nextInt(3); //Random pour l'orientation ( 0 1 2 ) 
		
		switch (pos) {
		case 0 : 
			cooX = 4;
			cooY = 3;
			switch (orient) {
			case 0 : 
				orientation = "Gauche";
				break;
			case 1 : 
				orientation = "Haut";
				break;
			case 2 : 
				orientation = "Droite";
				break;
			}
		case 1 : 
			cooX = 5;
			cooY = 4;
			switch (orient ) {
			case 0 : 
				orientation = "Haut";
				break; 
			case 1 : 
				orientation = "Droite";
				break;
			case 2 : 
				orientation = "Bas";
				break; 
			}
		case 2 : 
			cooX = 4;
			cooY = 5;
			switch (orient) {
			case 0 : 
				orientation = "Droite";
				break;
			case 1 : 
				orientation = "Bas";
				break;
			case 2 : 
				orientation = "Gauche";
				break;
			}
		case 3 : 
			cooX = 3;
			cooY = 4;
			switch (orient ) {
			case 0 : 
				orientation = "Bas";
				break;
			case 1 : 
				orientation = "Gauche";
				break;
			case 2: 
				orientation = "Haut";
				break;
			}
			
		}
		
		int[] cooB = rotation(orientation, cooX, cooY); //FONCTION DE PLACEMENT DE DOMINOS DANS LE DEROULEMENT
		
		int[] cooA = new int[2]; 
		cooA[0] = cooX;
		cooA[1] = cooY;
		
		
		
		
	}

	public void tourN() {
		
		// sort encore une fois ( priorité ) 
		//  i,j parcourent la grille ; isolation des cases libres ; add les libres à une liste ; rd dans les libre ;
	}
	
	public void vide() {
		Type testVide = Type.VIDE;

		
		
		for (int i = 0 ; i < IA.getPlateau().grille.length ; i++ ) {
			for (int j = 0 ; j < IA.getPlateau().grille[i].length ; j++ ) {
				if ( IA.getPlateau().grille[i][j].getTerrain() == testVide) {
					vides.add(IA.getPlateau().grille[i][j]);
				}
			}
		}
	}
	
			
	public void testVide() {
		Random rd = new Random() ;
		int aleat ;
		aleat = rd.nextInt(vides.size()); 
		
		//ensuite on test si la case à l'indice aleat est jouable
		// si pas jouable on recommence
		// si jouable on joue 
		
		
		
			
			
			
			
			
	}
	
	


		}

		


	

