import java.util.ArrayList;
import java.util.Scanner;

public class Deroulement {
	static ArrayList<String> couleur=new ArrayList<String>();
	
	public static void creationJoueur() {
		NombreJoueurs();
		for (int i=0;i<Joueurs.nbrjoueurs;i++) {
			Joueurs joueur=new Joueurs();
			Joueurs.listjoueurs.add(joueur);
		}
		NomJoueur();
	}
	
	public static void NombreJoueurs() {
		Scanner nbjoueur=new Scanner(System.in);
		System.out.println("Indiquer le nombre de joueur: ? ");
		while(!nbjoueur.hasNext("[2-4]")) {
			System.out.println("Entrer un nombre entre 2 et 4");
		nbjoueur.next();
		}
		Joueurs.nbrjoueurs=nbjoueur.nextInt();
		
	}



	public static void NomJoueur() {
		System.out.println("Rentrez le noms des participants");
		Scanner scan= new Scanner(System.in);
		int i=1;
		for(i=1;i<Joueurs.listjoueurs.size()+1;i++) {
			System.out.println("pseudo du joueur"+i+" : ");
			Joueurs.name=scan.nextLine();
		}
	}
	public static void creationrois() {
		couleur.add("bleue");
		couleur.add("vert");
		couleur.add("jaune");
		couleur.add("rouge");
		
		for(int i=0;i<couleur.size();i++) {
			Rois rois=new Rois();
			Rois.setColor(couleur.get(i));
			Rois.listrois.add(rois);
			
			
		
			
		}for(int i=0;i<Rois.listrois.size();i++) {
			System.out.println(Rois.getColor());
		}

		
		
		
	}




	
}
