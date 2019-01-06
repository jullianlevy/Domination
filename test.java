import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		System.out.println("--------------------------------------");
		System.out.println("BIENVENUE DOMIN'ATION");
		System.out.println("--------------------------------------");
		System.out.println("");
		
	
		Deroulement.creationJoueur();
		Domino.creationliste();
		Deroulement.ChoisirRois();
		
	
		for(Joueurs joueur:Joueurs.listjoueurs) {
			for(Rois roi:joueur.listrois) {
				System.out.println(roi.getColorRoi()+"  "+joueur.getName());
			}
		}
		

			
		
	
		
	}

			
			
		
		
			
			
		
		//Domino.creationliste();
		//Deroulement.NombreDomino();
		//Deroulement.Melangerdom();
		//Deroulement.ChoisirRois();
		//for(Joueurs joueur:Joueurs.listjoueurs) {
			//System.out.println(joueur.getName()+joueur.listrois);
		//}
	
		

	
	
	

	
	
	public static void NombreJoueurs() {
		Scanner nbjoueur=new Scanner(System.in);
		System.out.println("Indiquer le nombre de joueur: ");
		while(!nbjoueur.hasNext("[2-4]")) {
			System.out.println("Entrer un nombre entre 2 et 4");
		
		nbjoueur.nextInt();
		}
		Joueurs.nbrjoueurs=nbjoueur.nextInt();
		
	}
}
