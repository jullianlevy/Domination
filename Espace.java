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
		Type check = Type.VIDE;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length ; j++) {
				if (grille[i][j].getTerrain() != check) {
					print(i,j);
				}
				else {
					System.out.print("| _ ");
				}
			}
			System.out.println("|");
			System.out.println("");
			
		}
	}
	
	public void print(int i, int j) {
		Type type = grille[i][j].getTerrain();
		System.out.print("|" +  type.toString().substring(0, 2)+ " ");
		} 



}

		
