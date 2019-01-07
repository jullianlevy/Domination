import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Espace {
	static int largeur=9;
	static int longueur=9;
	Case[][] grille=new Case[largeur][hauteur];
	
	
	public Espace(){
		for(int i=0;i<longueur;i++){
			for(int j=0;j<largeur;j++){
				grille[i][j]=new Case(i,j);
			}
		}
		chateau=grille[4][4];
		chateau.setTerrain(Type.Terrain.CHATEAU);
		chateau.setNbCouronnes(0);
	}
			
	
	
	

	

}
