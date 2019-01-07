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
			
	
	
	

	

}
