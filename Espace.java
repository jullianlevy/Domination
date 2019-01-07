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
			
	public static String orientation() { //Choix de l'orientation du domino
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
	
	

	

}
