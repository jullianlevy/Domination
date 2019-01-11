import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Espace {
	final int largeurY=9;
	final int longueurX=9;
	Case[][] grille=new Case[longueurX][largeurY];
	
	
	public Espace() {
		initPlateau();
		printPlateau();
	}

	
	
	
	public void initPlateau(){
		for(int i=0;i<grille.length;i++){
			for(int j=0;j<grille[i].length;j++){
				this.grille[i][j]=new Case(i,j);
			}
		}
		Case chateau = this.grille[4][4];
		chateau.setTerrain(TypeTerrain.CHATEAU);
		chateau.setNbCouronne(0);
	}
	
	public void printPlateau() {
		for (int i = 0; i < grille.length; i++) {
			System.out.print("| _ ");
			for (int j = 0; j < grille[i].length - 1; j++) {
				System.out.print("| _ ");
			}
			System.out.println("|");
			System.out.println("");
			
		}
	}


}

		
