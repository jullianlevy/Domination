import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Deroulement.creationJoueur();
		Joueurs jullian=new Joueurs();
		Joueurs paul=new Joueurs();
		paul.setName("paul");
		jullian.setName("jullian");
		Joueurs.listjoueurs.add(paul);
		Joueurs.listjoueurs.add(jullian);
		for(Joueurs joueur:Joueurs.listjoueurs) {
			
			System.out.println(joueur.getName());
		
		}
		Rois bleu=new Rois(Couleur.BLEU,1);
		Rois jaune=new Rois(Couleur.JAUNE,2);
		Rois rouge=new Rois(Couleur.ROUGE,3);
		Rois vert=new Rois(Couleur.VERT,4);
		Rois.listrois.add(vert);
		Rois.listrois.add(jaune);
		Rois.listrois.add(rouge);
		Rois.listrois.add(bleu);
		for (Rois roi:Rois.listrois) {
			System.out.println();
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
