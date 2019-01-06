import java.util.ArrayList;
import java.util.Scanner;

public class Joueurs {

	public  String name;
	static int nbrjoueurs;
	private int score;
	static ArrayList<Joueurs> listjoueurs=new ArrayList<Joueurs>();
	ArrayList<Rois> listrois=new ArrayList<Rois>();
	ArrayList<Domino> dominojoueurs=new ArrayList<Domino>();
	
	Espace plateau;
	

	
	
	
	
	public Joueurs(String name) {
		this.name=name;


	
}
	
	


public void NombreJoueurs() {
	Scanner nbjoueur=new Scanner(System.in);
	System.out.println("Indiquer le nombre de joueur: ? ");
	while(!nbjoueur.hasNext("[2-4]")) {
		System.out.println("Entrer un nombre entre 2 et 4");
	nbjoueur.next();
	}
	nbrjoueurs=nbjoueur.nextInt();
	
}



public void NomJoueur() {
	Scanner scan= new Scanner(System.in);
	int i=0;
	for(i=0;i<getListjoueurs().size();i++) {
		System.out.println("joueur "+i+1);
		name=scan.nextLine();
	}
}

 


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Joueurs> getListJoueurs() {
		return this.getListjoueurs();
	}
	public void setListeRois(ArrayList<Joueurs> listjoueurs) {
		this.setListjoueurs(listjoueurs);
	}





	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}




	public static ArrayList<Joueurs> getListjoueurs() {
		return listjoueurs;
	}




	public void setListjoueurs(ArrayList<Joueurs> listjoueurs) {
		this.listjoueurs = listjoueurs;
	}


}
